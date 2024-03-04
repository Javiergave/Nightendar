package com.example.nightendar

import android.content.ContentValues
import android.content.Intent
import android.health.connect.datatypes.BloodPressureRecord.BloodPressureMeasurementLocation
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null
    private lateinit var editTextlocalName: EditText
    private lateinit var editTextLocalLocation: EditText
    private lateinit var rating: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        // Obtén la referencia de la imagen
        val imageView3: ImageView = findViewById(R.id.imageView3)
        val imageView6: ImageView= findViewById(R.id.imageView6)
        val imageView9: ImageView= findViewById(R.id.imageView9)
        val imageView: ImageView = findViewById(R.id.imageView)
        editTextlocalName = findViewById(R.id.editTextLocalName)
        editTextLocalLocation = findViewById(R.id.editTextLocalLocation)
        rating=findViewById(R.id.ratingBar)
        // Obtén el username y el password del Intent
        val intent: Intent = intent
        username = intent.getStringExtra("username")
        password = intent.getStringExtra("password")

        imageView3.setOnClickListener {
            volverAMain()
        }
        imageView6.setOnClickListener {
            guardarEstancia()
        }
        imageView.setOnClickListener {
            abrirConfiguracion()
        }
        imageView9.setOnClickListener {
            abrirUser()
        }

    }

    // Función para volver a la actividad principal
    private fun volverAMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
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
    private fun guardarEstancia() {
        var localName=editTextlocalName.text.toString()
        var localUbi=editTextLocalLocation.text.toString()
        var localRating=rating.getRating()
        val admin = BaseDatosApp(this,"bdnightendar",null,1)
        val bd = admin.writableDatabase
        val reg = ContentValues()

        reg.put("NAME",localName)
        reg.put("UBICACION",localUbi)
        reg.put("RATING",localRating)
        bd.insert("LOCAL", null, reg)
        bd.close()
        val intent = Intent(this, MainActivity::class.java)
        // Pasa el nombre de usuario y la contraseña como extras
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()
    }
    private fun abrirConfiguracion() {
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
        finish()
    }


}
