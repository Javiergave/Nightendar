package com.example.nightendar

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private var username: String? = null
    private var password: String? = null
    private lateinit var opcionModoOscuro: CheckBox
    private lateinit var opcionRecomendaciones: CheckBox
    private lateinit var opcionUbicacion: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        sharedPreferences = getSharedPreferences("checkbox_state", MODE_PRIVATE)

        // Obtén la referencia de la imagen
        val imageView3: ImageView = findViewById(R.id.imageView3)
        val imageView6: ImageView= findViewById(R.id.imageView2)

        // Obtén el username y el password del Intent
        val intent: Intent = intent
        username = intent.getStringExtra("username")
        password = intent.getStringExtra("password")

        // Obtener referencias de las CheckBox
        opcionModoOscuro = findViewById(R.id.opcion_modo_oscuro)
        opcionRecomendaciones = findViewById(R.id.opcion_recomendaciones)
        opcionUbicacion = findViewById(R.id.opcion_ubicacion)

        // Restaurar estados de las CheckBox
        opcionModoOscuro.isChecked = sharedPreferences.getBoolean("modo_oscuro", true)
        opcionRecomendaciones.isChecked = sharedPreferences.getBoolean("recomendaciones", true)
        opcionUbicacion.isChecked = sharedPreferences.getBoolean("ubicacion", true)        // Configura el OnClickListener para imageView3 (volver a MainActivity)

        // Configurar Listener para guardar cambios en SharedPreferences
        opcionModoOscuro.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("modo_oscuro", isChecked).apply()
        }

        opcionRecomendaciones.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("recomendaciones", isChecked).apply()
        }

        opcionUbicacion.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("ubicacion", isChecked).apply()
        }
        
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
