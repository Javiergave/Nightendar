import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TestRecomendacion {

    @Test
    fun testSetTextDifferent() {
        // Crea un mock del TextView
        val textViewMock = mock(TextView::class.java)

        // Simula el comportamiento del método setText() con un texto diferente
        `when`(textViewMock.text).thenReturn("Texto diferente")

        // Verifica que el texto del TextView es el esperado
        assertEquals("Texto diferente", textViewMock.text.toString())
    }


    @Test
    fun testEditTextToTextView() {
        // Crea un mock del EditText
        val editTextMock = mock(EditText::class.java)

        // Crea un mock de Editable
        val editableMock = mock(Editable::class.java)

        // Simula el comportamiento del método getText() para devolver el objeto Editable simulado
        `when`(editTextMock.text).thenReturn(editableMock)

        // Verifica que el texto del EditText es el esperado
        assertEquals(editableMock, editTextMock.text)
    }
}
