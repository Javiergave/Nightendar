package com.example.nightendar
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nightendar.data.Recomendacion
import android.util.Log
import android.widget.Toast



class RecomendacionAdapter : RecyclerView.Adapter<RecomendacionAdapter.RecomendacionViewHolder>() {

    private val recomendaciones: MutableList<Recomendacion> = mutableListOf()

    fun actualizarDatos(nuevasRecomendaciones: List<Recomendacion>) {
        recomendaciones.clear()
        recomendaciones.addAll(nuevasRecomendaciones)

        val primeraRecomendacion = recomendaciones.firstOrNull()
        if (primeraRecomendacion != null) {
        } else {
            Log.d("Recomendaciones", "La lista de recomendaciones está vacía.")
        }

        notifyDataSetChanged()
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recomendacion, parent, false)
        return RecomendacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecomendacionViewHolder, position: Int) {
        val recomendacion = recomendaciones[position]
        holder.bind(recomendacion)
    }

    override fun getItemCount(): Int {
        return recomendaciones.size
    }

    class RecomendacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewNombre: TextView = itemView.findViewById(R.id.nombreRecomendacion)
        private val textViewUbicacion: TextView = itemView.findViewById(R.id.ubicacionRecomendacion)

        fun bind(recomendacion: Recomendacion) {
            textViewNombre.text = recomendacion.nombreLugar
            textViewUbicacion.text = recomendacion.ubicacion
        }
    }
}
