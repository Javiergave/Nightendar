package com.example.nightendar

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Obtén la referencia de la imagen
        val imageView3: ImageView = findViewById(R.id.imageView3)
        val imageView6: ImageView= findViewById(R.id.imageView2)

        // Obtén el username y el password del Intent
        val intent: Intent = intent
        username = intent.getStringExtra("username")
        password = intent.getStringExtra("password")

        imageView3.setOnClickListener {
            // Llama a la función para volver a la actividad principal
            volverAMain()
        }

        // Configura el OnClickListener para imageView6
        imageView6.setOnClickListener {
            // Llama a la función para cambiar a la actividad de configuración
            abrirUser()
        }
    }

    // Función para volver a la actividad principal
    private fun volverAMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Opcional: cierra la actividad actual para evitar que el usuario vuelva atrás y llegue a esta actividad.
    }

    // Función para cambiar a la actividad de usuario
    private fun abrirUser() {
        val intent = Intent(this, UserActivity::class.java)
        // Pasa el nombre de usuario y la contraseña como extras
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()
    }

}
