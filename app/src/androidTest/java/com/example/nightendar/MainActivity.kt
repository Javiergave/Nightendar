package com.example.nightendar

// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Puedes agregar aquí más código de inicialización si es necesario
    }

    // Método que se ejecutará cuando se haga clic en la imagen
    fun settingOnClick(view: View) {
        // Crear un Intent para iniciar la actividad de configuración
        val intent = Intent(this, SettingsActivity::class.java)

        // Iniciar la actividad de configuración
        startActivity(intent)
    }
}
