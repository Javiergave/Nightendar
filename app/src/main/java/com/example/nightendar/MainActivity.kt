package com.example.nightendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import com.example.nightendar.SettingsActivity
import com.example.nightendar.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtén la referencia del ImageView
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val imageView8: ImageView = findViewById(R.id.imageView8)

        // Configura el OnClickListener para imageView12
        imageView12.setOnClickListener {
            // Llama a la función para cambiar a la actividad de map
            abrirMapa()
        }

        // Configura el OnClickListener para imageView8
        imageView8.setOnClickListener {
            // Llama a la función para cambiar a la actividad de map
            abrirMapa()
        }
        imageView.setOnClickListener {
            // Llama a la función para cambiar a la actividad de configuración
            abrirConfiguracion()
        }
    }

    // Función para cambiar a la actividad de map
    private fun abrirMapa() {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }
    // Función para cambiar a la actividad de configuración
    private fun abrirConfiguracion() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}
