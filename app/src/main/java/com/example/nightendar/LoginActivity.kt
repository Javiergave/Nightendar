package com.example.nightendar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            // Obtén el usuario y la contraseña ingresados
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Guarda el usuario y la contraseña si es necesario
            val sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.apply()

            // Abre la MainActivity y envía el usuario y la contraseña como extras
            val mainIntent = Intent(this, MainActivity::class.java)
            mainIntent.putExtra("username", username)
            mainIntent.putExtra("password", password)
            startActivity(mainIntent)
            finish()  // Cierra LoginActivity para evitar volver atrás desde MainActivity
        }

    }
}
