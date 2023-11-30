package com.example.nightendar

// SettingsActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Obtén la referencia de la imagen
        val imageView3: ImageView = findViewById(R.id.imageView3)

        // Configura el OnClickListener para imageView3 (volver a MainActivity)
        imageView3.setOnClickListener {
            // Llama a la función para volver a la actividad principal
            volverAMain()
        }
    }

    // Función para volver a la actividad principal
    private fun volverAMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Opcional: cierra la actividad actual para evitar que el usuario vuelva atrás y llegue a esta actividad.
    }
}

