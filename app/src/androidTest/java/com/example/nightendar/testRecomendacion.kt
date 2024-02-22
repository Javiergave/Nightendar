import android.widget.EditText
import android.widget.RatingBar
import androidx.test.core.app.ActivityScenario
import com.example.nightendar.BaseDatosApp
import com.example.nightendar.NewActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.lang.reflect.Method

@RunWith(RobolectricTestRunner::class)
class TestRecomendacion {

    @Test
    fun testRecomendacionFuncion() {
        // Lanzar la actividad utilizando ActivityScenario
        val scenario = ActivityScenario.launch(NewActivity::class.java)

        scenario.onActivity { activity ->
            // Acceder a los campos privados utilizando reflexión
            val editTextlocalNameField = activity.javaClass.getDeclaredField("editTextlocalName")
            editTextlocalNameField.isAccessible = true
            val editTextlocalName = editTextlocalNameField.get(activity) as EditText

            val editTextLocalLocationField = activity.javaClass.getDeclaredField("editTextLocalLocation")
            editTextLocalLocationField.isAccessible = true
            val editTextLocalLocation = editTextLocalLocationField.get(activity) as EditText

            val ratingField = activity.javaClass.getDeclaredField("rating")
            ratingField.isAccessible = true
            val rating = ratingField.get(activity) as RatingBar

            // Establecer los valores de los campos
            editTextlocalName.setText("Nombre del local")
            editTextLocalLocation.setText("Ubicación del local")
            rating.rating = 4.5f

            // Acceder al método guardarEstancia utilizando reflexión
            val guardarEstanciaMethod: Method = activity.javaClass.getDeclaredMethod("guardarEstancia")
            guardarEstanciaMethod.isAccessible = true

            // Llamar al método guardarEstancia
            guardarEstanciaMethod.invoke(activity)

            // Verificar si los datos se guardaron correctamente en la base de datos
            val db = BaseDatosApp(activity, "bdnightendar", null, 1).readableDatabase
            val cursor = db.rawQuery("SELECT * FROM LOCAL", null)

            // Realizar las aserciones necesarias
            // ...

            cursor.close()
            db.close()
        }
    }
}
