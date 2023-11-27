package com.example.nightendar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // Obtén las referencias de las imágenes
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView4: ImageView = findViewById(R.id.imageView4)
        val imageView7: ImageView = findViewById(R.id.imageView7)
        val imageView13: ImageView = findViewById(R.id.imageView13)

        // Configura el OnClickListener para imageView (navegar a SettingsActivity)
        imageView.setOnClickListener {
            // Llama a la función para cambiar a la actividad de configuración
            abrirConfiguracion()
        }

        // Configura el OnClickListener para imageView4 (volver a MainActivity)
        imageView4.setOnClickListener {
            // Llama a la función para volver a la actividad principal
            volverAMain()
        }

        // Configura el OnClickListener para imageView7 (navegar a RecommendedActivity)
        imageView7.setOnClickListener {
            // Llama a la función para cambiar a la actividad recomendada
            abrirRecomendada()
        }

        // Configura el OnClickListener para imageView13 (volver a MainActivity)
        imageView13.setOnClickListener {
            // Llama a la función para volver a la actividad principal
            volverAMain()
        }
    }

    // Función para cambiar a la actividad de configuración
    private fun abrirConfiguracion() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    // Función para cambiar a la actividad recomendada
    private fun abrirRecomendada() {
        val intent = Intent(this, RecommendedActivity::class.java)
        startActivity(intent)
    }

    // Función para volver a la actividad principal
    private fun volverAMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
