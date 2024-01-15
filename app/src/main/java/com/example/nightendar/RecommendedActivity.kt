package com.example.nightendar

import RecomendacionAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nightendar.data.Recomendacion

class RecommendedActivity : AppCompatActivity() {

    private var username: String? = null
    private var password: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var recomendacionAdapter: RecomendacionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommended)

        // Obtén la referencia de los ImageViews
        val imageView12: ImageView = findViewById(R.id.imageView12)
        val imageView14: ImageView = findViewById(R.id.imageView14)
        val imageView17: ImageView = findViewById(R.id.imageView17)
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageView6: ImageView = findViewById(R.id.imageView6)

        // Obtén el username y el password del Intent
        val intent: Intent = intent
        username = intent.getStringExtra("username")
        password = intent.getStringExtra("password")

        // Configura el OnClickListener para imageView12
        imageView12.setOnClickListener {
            // Llama a la función para volver a MainActivity
            volverAMain()
        }

        // Configura el OnClickListener para imageView14
        imageView14.setOnClickListener {
            // Llama a la función para volver a MainActivity
            volverAMain()
        }

        // Configura el OnClickListener para imageView8
        imageView17.setOnClickListener {
            // Llama a la función para ir a MapActivity
            abrirMapa()
        }

        // Configura el OnClickListener para imageView6
        imageView6.setOnClickListener {
            // Llama a la función para cambiar a la actividad de configuración
            abrirUser()
        }

        // Configura el OnClickListener para imageView
        imageView.setOnClickListener {
            // Llama a la función para cambiar a la actividad de configuración
            abrirConfiguracion()
        }

        // ...

        recyclerView = findViewById(R.id.recyclerView)
        recomendacionAdapter = RecomendacionAdapter()

        // Configura el RecyclerView con un LinearLayoutManager y el adaptador
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recomendacionAdapter

        // Llena el adaptador con tus datos (recomendaciones), por ejemplo:
        val recomendaciones = obtenerRecomendaciones() // Debes implementar esta función
        recomendacionAdapter.submitList(recomendaciones)

    }

    // Función para volver a MainActivity
    private fun volverAMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Función para ir a MapActivity
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

    // Función para cambiar a la actividad de usuario
    private fun abrirUser() {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("username", username)
        intent.putExtra("password", password)
        startActivity(intent)
    }

    private fun obtenerRecomendaciones(): List<Recomendacion> {
        // Aquí debes obtener tus datos de recomendaciones y devolver una lista de Recomendacion.
        // Por ejemplo:
        val recomendacion1 = Recomendacion("1", "Nombre1", "Ubicacion1", 4.5)
        val recomendacion2 = Recomendacion("2", "Nombre2", "Ubicacion2", 3.8)
        return listOf(recomendacion1, recomendacion2)
    }
}
