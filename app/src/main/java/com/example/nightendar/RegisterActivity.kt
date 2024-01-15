package com.example.nightendar

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonRegister.setOnClickListener {
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

            val admin = BaseDatosApp(this,"bdnightendar",null,1)
            val bd = admin.writableDatabase
            val reg = ContentValues()

            reg.put("EMAIL",editTextEmail.text.toString())
            reg.put("USERNAME",editTextUsername.text.toString())
            reg.put("PASSWORD",editTextPassword.text.toString())
            bd.insert("USERS", null, reg)
            bd.close()
            Toast.makeText(baseContext,"Se ha creado el usuario", Toast.LENGTH_SHORT).show();
        }


    }
}
