package com.uta.deteccionplagas

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Acción para el "botón" 1
        val button1: LinearLayout = findViewById(R.id.button1)
        button1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // Acción para el "botón" 2
        val button2: LinearLayout = findViewById(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, CapActivity::class.java)
            startActivity(intent)
        }
        // Acción para el "botón" 3
        val button3: LinearLayout = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, PlagasActivity::class.java)
            startActivity(intent)
        }
        // Acción para el "botón" 4
        val button4: LinearLayout =findViewById(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, ControlActivity::class.java)
            startActivity(intent)
        }
        // Acción para el "botón" 5
        val button5: LinearLayout = findViewById(R.id.button5)
        button5.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

    }

}
