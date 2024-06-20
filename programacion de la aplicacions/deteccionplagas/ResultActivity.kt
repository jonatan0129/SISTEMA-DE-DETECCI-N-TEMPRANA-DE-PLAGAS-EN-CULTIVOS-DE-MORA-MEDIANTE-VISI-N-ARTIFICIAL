package com.uta.deteccionplagas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.uta.deteccionplagas.databinding.ActivityResultBinding
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var database: DatabaseReference
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inicializa Firebase Database y obtiene el ID del usuario actual
        database = FirebaseDatabase.getInstance().reference
        userId = FirebaseAuth.getInstance().currentUser?.uid
        // Llamar al método para cargar los datos de detección
        loadDetectionData()
    }

    private fun loadDetectionData() {
        if (userId != null) {
            val detectionsRef = database.child("users").child(userId!!).child("detections")
            detectionsRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // Limpiar la tabla antes de llenarla
                    binding.tableLayout.removeAllViews()

                    // Añadir la fila del encabezado
                    val headerRow = layoutInflater.inflate(R.layout.table_row, null)
                    headerRow.findViewById<TextView>(R.id.labelTextView).text = "Plaga detectada"
                    headerRow.findViewById<TextView>(R.id.dateTextView).text = "Fecha de detección"
                    //headerRow.findViewById<TextView>(R.id.placeTextView).text = "Lugar"
                    //headerRow.findViewById<TextView>(R.id.nameTextView).text = "Usuario"
                   // headerRow.findViewById<TextView>(R.id.plantationNameTextView).text = "Plantación"
                    binding.tableLayout.addView(headerRow)

                    // Iterar sobre las detecciones
                    for (detectionSnapshot in snapshot.children) {
                        val detection = detectionSnapshot.getValue(Detection::class.java)
                        detection?.let {
                            // Crear una nueva fila para la tabla
                            val row = layoutInflater.inflate(R.layout.table_row, null)
                            row.findViewById<TextView>(R.id.labelTextView).text = it.label
                            row.findViewById<TextView>(R.id.dateTextView).text = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(it.timestamp)
                           // row.findViewById<TextView>(R.id.placeTextView).text = it.place
                            //row.findViewById<TextView>(R.id.nameTextView).text = it.name
                            //row.findViewById<TextView>(R.id.plantationNameTextView).text = it.plantationName

                            // Añadir la fila a la tabla
                            binding.tableLayout.addView(row)
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    // Manejar el error de carga de datos
                }
            })
        }
    }

    data class Detection(
        val id: String = "",
        val label: String = "",
        val timestamp: Long = 0,
        val place: String = "",
        val name: String = "",
        val plantationName: String = ""
    )
}
