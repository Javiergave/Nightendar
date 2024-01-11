package com.example.nightendar

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

            //Comprueba Login Valido
            val admin = BaseDatosApp(this, "bdnightendar", null, 1)
            val bdnightendar = admin.writableDatabase
            val fila = bdnightendar.rawQuery("SELECT USERNAME,PASSWORD FROM USERS WHERE USERNAME='${username}' AND PASSWORD='${password}'",null)
            var user = "admin"
            var pass = "admin"
            if (fila.moveToFirst()) {
                user = fila.getString(0)
                pass = fila.getString(1)
            }
            if (user == username && pass == password) {
                // Abre la MainActivity y envía el usuario y la contraseña como extras

                val mainIntent = Intent(this, MainActivity::class.java)
                mainIntent.putExtra("username", username)
                mainIntent.putExtra("password", password)
                startActivity(mainIntent)
                finish()

            // Cierra LoginActivity para evitar volver atrás desde MainActivity
            }
            else{
                Toast.makeText(this,"Usuario o Contraseña Incorrecta",Toast.LENGTH_LONG).show()
            }
        }

    }
}



