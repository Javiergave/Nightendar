package com.example.nightendar.data

data class Recomendacion(val id: String, val nombreLugar: String, val ubicacion: String, val rating: Double) {

    fun mostrarDetalles() {
        println("ID: $id")
        println("Lugar: $nombreLugar")
        println("Ubicación: $ubicacion")
        println("Rating: $rating")
    }
}

fun main() {
    val recomendacion1 = Recomendacion("1", "Discoteca 1", "Calle 123, Ciudad X", 4.5)
    val recomendacion2 = Recomendacion("2", "Discoteca 2", "Avenida 456, Ciudad Y", 3.8)


    recomendacion1.mostrarDetalles()
    recomendacion2.mostrarDetalles()
}
