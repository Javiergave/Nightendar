package com.example.nightendar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.nightendar.R
import com.example.nightendar.SettingsActivity

class MainActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtén la referencia del ImageView
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val imageView8: ImageView = findViewById(R.id.imageView8)
        val imageView7: ImageView = findViewById(R.id.imageView7)
        val imageView13: ImageView = findViewById(R.id.imageView13)
        val imageView6: ImageView = findViewById(R.id.imageView6)

        // Obtén el username y el password del Intent
        val intent: Intent = intent
        username = intent.getStringExtra("username")
        password = intent.getStringExtra("password")

        // Configura el OnClickListener para imageView6
        imageView6.setOnClickListener {
            abrirUser()
        }

        // Configura el OnClickListener para imageView12
        imageView12.setOnClickListener {
            abrirMapa()
        }

        // Configura el OnClickListener para imageView8
        imageView8.setOnClickListener {
            abrirMapa()
        }

        // Configura el OnClickListener para imageView7
        imageView7.setOnClickListener {
            abrirRecomendada()
        }

        // Configura el OnClickListener para imageView13
        imageView13.setOnClickListener {
            abrirRecomendada()
        }

        // Configura el OnClickListener para imageView
        imageView.setOnClickListener {
            abrirConfiguracion()
        }
    }

    // Función para cambiar a la actividad de map
    private fun abrirMapa() {
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
    }

    // Función para cambiar a la actividad de configuración
    private fun abrirConfiguracion() {
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
    }

    // Función para cambiar a la actividad recomendada
    private fun abrirRecomendada() {
        val intent = Intent(this, RecommendedActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
    }

    // Función para cambiar a la actividad de usuario
    private fun abrirUser() {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
    }
}

