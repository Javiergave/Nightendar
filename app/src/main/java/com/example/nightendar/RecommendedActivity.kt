package com.example.nightendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class RecommendedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended)

        // Obtén la referencia de los ImageViews
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val imageView14: ImageView = findViewById(R.id.imageView14)
        val imageView8: ImageView = findViewById(R.id.imageView8)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Configura el OnClickListener para imageView12
        imageView12.setOnClickListener {
            // Llama a la función para volver a MainActivity
            volverAMain()
        }

        // Configura el OnClickListener para imageView14
        imageView14.setOnClickListener {
            // Llama a la función para volver a MainActivity
            volverAMain()
        }

        // Configura el OnClickListener para imageView8
        imageView8.setOnClickListener {
            // Llama a la función para ir a MapActivity
            abrirMapa()
        }
        imageView.setOnClickListener {
            // Llama a la función para cambiar a la actividad de configuración
            abrirConfiguracion()
        }
    }

    // Función para volver a MainActivity
    private fun volverAMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun abrirConfiguracion() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    // Función para ir a MapActivity
    private fun abrirMapa() {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }
}
