package com.example.nightendar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nightendar.data.Recomendacion


class RecomendacionAdapter : RecyclerView.Adapter<RecomendacionAdapter.RecomendacionViewHolder>() {

    private val recomendaciones: MutableList<Recomendacion> = mutableListOf()

    fun actualizarDatos(nuevasRecomendaciones: List<Recomendacion>) {
        // Borrar la lista anterior y añadir las nuevas recomendaciones
        recomendaciones.clear()
        recomendaciones.addAll(nuevasRecomendaciones)

        // Notificar al adaptador que los datos han cambiado
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
        private val textViewRating: TextView = itemView.findViewById(R.id.ratingRecomendacion)

        fun bind(recomendacion: Recomendacion) {
            textViewNombre.text = recomendacion.nombreLugar
            textViewUbicacion.text = recomendacion.ubicacion
            textViewRating.text = recomendacion.rating.toString()
        }
    }

}
