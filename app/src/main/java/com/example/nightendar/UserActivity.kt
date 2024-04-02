package com.example.nightendar

import ReportGenerator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class UserActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val reportGenerator = ReportGenerator()
        val jrxmlFilePath = "/a/informe.jrxml" // Ruta al archivo JRXML

        val jasperFilePath = "/a/informe.jasper" // Ruta de salida del archivo Jasper

        reportGenerator.compileReport(jrxmlFilePath, jasperFilePath)
        // Obtén el nombre de usuario y la contraseña del Intent
        val intent: Intent = intent
        val username: String? = intent.getStringExtra("username")
        val password: String? = intent.getStringExtra("password")


        // Obtén referencias de los ImageViews
        val imageView2: ImageView = findViewById(R.id.imageView2)
        val imageView3: ImageView = findViewById(R.id.imageView3)

        // Configura el OnClickListener para imageView2
        imageView2.setOnClickListener {
            abrirConfiguracion(username, password)
        }

        // Configura el OnClickListener para imageView3
        imageView3.setOnClickListener {
            abrirMainActivity(username, password)
        }
    }

    // Función para abrir SettingsActivity
    private fun abrirConfiguracion(username: String?, password: String?) {
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()
    }

    // Función para abrir MainActivity
    private fun abrirMainActivity(username: String?, password: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()  // Cierra UserActivity para evitar volver atrás desde MainActivity
    }
}
