package com.uta.deteccionplagas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AuthActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        database = FirebaseDatabase.getInstance().reference

        setup()
    }
    private fun setup() {
        title = "Autenticación"
        val signUpButton: Button = findViewById(R.id.signUpButton)
        signUpButton.setOnClickListener {
            val emailEditText: EditText = findViewById(R.id.emailEditText)
            val passwordEditText: EditText = findViewById(R.id.passwordEditText)
            val nameEditText: EditText = findViewById(R.id.nameEditText)
            val placeEditText: EditText = findViewById(R.id.placeEditText)
            val plantationNameEditText: EditText = findViewById(R.id.plantationNameEditText)

            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty() &&
                nameEditText.text.isNotEmpty() && placeEditText.text.isNotEmpty() &&
                plantationNameEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val userId = FirebaseAuth.getInstance().currentUser?.uid ?: ""
                        val user = User(
                            userId,
                            nameEditText.text.toString(),
                            placeEditText.text.toString(),
                            plantationNameEditText.text.toString(),
                            emailEditText.text.toString()
                        )
                        database.child("users").child(userId).setValue(user)
                        showHome()
                    } else {
                        showAlert()
                    }
                }
            }
        }

        val logInButton: Button = findViewById(R.id.logInButton)
        logInButton.setOnClickListener {
            val emailEditText: EditText = findViewById(R.id.emailEditText)
            val passwordEditText: EditText = findViewById(R.id.passwordEditText)
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome()
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en la autenticación del usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome() {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {}
        startActivity(homeIntent)
        finish()
    }
}
data class User(
    val id: String,
    val name: String,
    val place: String,
    val plantationName: String,
    val email: String
)
