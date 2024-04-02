import net.sf.jasperreports.engine.JREmptyDataSource
import net.sf.jasperreports.engine.JRException
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperReport
import net.sf.jasperreports.engine.util.JRLoader


class ReportGenerator {
    fun compileReport(jrxmlFilePath: String?, jasperFilePath: String) {
        try {
            JasperCompileManager.compileReportToFile(jrxmlFilePath, jasperFilePath)
            println("Informe compilado exitosamente en: $jasperFilePath")
        } catch (e: JRException) {
            e.printStackTrace()
        }
    }
    fun generateReport(
        jasperFilePath: String?,
        parameters: Map<String?, Any?>?,
        outputFilePath: String
    ) {
        try {
            // Cargar el archivo .jasper
            val jasperReport = JRLoader.loadObjectFromFile(jasperFilePath) as JasperReport

            // Compilar el informe utilizando los datos proporcionados
            val jasperPrint =
                JasperFillManager.fillReport(jasperReport, parameters, JREmptyDataSource())

            // Exportar el informe a un archivo (PDF, Excel, etc.)
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath)
            println("Informe generado exitosamente en: $outputFilePath")
        } catch (e: JRException) {
            e.printStackTrace()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val reportGenerator = ReportGenerator()
            val jasperFilePath = "ruta/al/archivo.jasper" // Ruta al archivo .jasper
            val outputFilePath =
                "ruta/de/salida/informe.pdf" // Ruta donde se guardará el informe generado
            val parameters: Map<String?, Any?>? = null // Puedes pasar parámetros si es necesario
            reportGenerator.generateReport(jasperFilePath, parameters, outputFilePath)
        }
    }
}
