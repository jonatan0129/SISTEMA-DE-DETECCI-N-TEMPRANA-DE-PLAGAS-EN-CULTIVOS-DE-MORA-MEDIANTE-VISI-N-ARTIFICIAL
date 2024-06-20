package com.uta.deteccionplagas

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.uta.deteccionplagas.databinding.ActivityCapBinding

class CapActivity : AppCompatActivity(), Detector.DetectorListener {
    private lateinit var binding: ActivityCapBinding
    private lateinit var detector: Detector
    private lateinit var database: DatabaseReference
    private var detectedBitmap: Bitmap? = null
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa Firebase Database
        database = FirebaseDatabase.getInstance().reference
        detector = Detector(baseContext, Constants.MODEL_PATH, Constants.LABELS_PATH, this)
        detector.setup()
        // Obtener el ID del usuario actual
        userId = FirebaseAuth.getInstance().currentUser?.uid
        if (allPermissionsGranted()) {
            // Initialization or start any process if needed
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        binding.selectImage.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }
        binding.takePicture.setOnClickListener {
            takePictureLauncher.launch(null)
        }
    }

    private fun sendDetectionToFirebase(label: String) {
        val detectionId = database.child("users").child(userId!!).child("detections").push().key ?: return
        val detection = Detection(
            detectionId,
            label,
            place = "Lugar de prueba",
            name = "Nombre de prueba",
            plantationName = "Plantación de prueba"
        )
        database.child("users").child(userId!!).child("detections").child(detectionId).setValue(detection)
            .addOnSuccessListener {
                Toast.makeText(this, "Detección enviada exitosamente", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al enviar la detección: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    data class Detection(
        val id: String,
        val label: String,
        val timestamp: Long = System.currentTimeMillis(),
        val place: String,
        val name: String,
        val plantationName: String
    )

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            val inputStream = contentResolver.openInputStream(it)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream?.close()
            bitmap?.let { bmp ->
                detectedBitmap = bmp
                displayImage(bmp)
                detector.detect(bmp)
            }
        }
    }

    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let {
            detectedBitmap = it
            displayImage(it)
            detector.detect(it)
        }
    }

    private fun displayImage(bitmap: Bitmap) {
        binding.imageView.setImageBitmap(bitmap)
        binding.overlay.setImageSize(bitmap.width, bitmap.height)
    }

    override fun onDestroy() {
        super.onDestroy()
        detector.clear()
    }

    override fun onEmptyDetect() {
        binding.overlay.setResults(emptyList())
        binding.overlay.invalidate()
    }

    override fun onDetect(boundingBoxes: List<BoundingBox>, inferenceTime: Long) {
        runOnUiThread {
            binding.inferenceTime.text = "${inferenceTime}ms"
            binding.overlay.apply {
                setResults(boundingBoxes)
                invalidate()
            }

            if (boundingBoxes.isNotEmpty()) {
                val label = boundingBoxes[0].clsName
                Log.d("Detection", "Etiqueta detectada: $label")
                sendDetectionToFirebase(label)
            } else {
                Log.d("Detection", "No se detectaron etiquetas.")
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = mutableListOf(
            Manifest.permission.CAMERA
        ).toTypedArray()
    }
}

