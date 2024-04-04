package com.example.nightendar
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.text.TextPaint
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream


class UserActivity : AppCompatActivity() {
    private val usuarios = arrayOf("Javi Ruiz", "Luis Gonzales", "Ramon Font", "Raul Blanco", "Alvaro Domingo")
    private val tituloText = "Informe de usuarios"
    private val descripcionText = "Número de Usuarios que han iniciado sesión: ${usuarios.size}\n"


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
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

        var btnGenerarPdf = findViewById<Button>(R.id.btnCrearPdf)

        if(checkPermission()) {
            Toast.makeText(this, "Permiso Aceptado", Toast.LENGTH_LONG)
        } else {
            requestPermissions()
        }

        btnGenerarPdf.setOnClickListener(View.OnClickListener {
            generarPdf()
        })
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

    fun generarPdf() {
        val pdfDocument = PdfDocument()
        val paint = Paint()
        val titulo = TextPaint()
        val descripcion = TextPaint()

        val paginaInfo = PdfDocument.PageInfo.Builder(816, 1054, 1).create()
        val pagina1 = pdfDocument.startPage(paginaInfo)
        val canvas = pagina1.canvas

        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.logo_nightendar)
        val bitmapEscala = Bitmap.createScaledBitmap(bitmap, 80, 80, false)
        canvas.drawBitmap(bitmapEscala, 368f, 20f, paint)

        titulo.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        titulo.textSize = 20f
        canvas.drawText(tituloText, 10f, 150f, titulo)

        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL))
        descripcion.textSize = 14f

        val arrDescripcion = descripcionText.split("\n")

        var y = 200f
        for (item in arrDescripcion) {
            canvas.drawText(item, 10f, y, descripcion)
            y += 15
        }

        for (usuario in usuarios) {
            canvas.drawText(usuario, 10f, y, descripcion)
            y += 15
        }

        pdfDocument.finishPage(pagina1)

        val file = File(Environment.getExternalStorageDirectory(), "Archivo.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(this, "Se creó el PDF correctamente", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        pdfDocument.close()
    }

    private fun checkPermission(): Boolean {
        val permission1 = ContextCompat.checkSelfPermission(applicationContext, WRITE_EXTERNAL_STORAGE)
        val permission2 = ContextCompat.checkSelfPermission(applicationContext, READ_EXTERNAL_STORAGE)
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
            200
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 200) {
            if(grantResults.size > 0) {
                val writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if(writeStorage && readStorage) {
                    Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG)
                } else {
                    Toast.makeText(this, "Permisos rechazados", Toast.LENGTH_LONG)
                    finish()
                }
            }
        }
    }
}
