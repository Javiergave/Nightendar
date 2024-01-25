import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nightendar.R
import com.example.nightendar.data.Recomendacion

class RecomendacionAdapter :
    ListAdapter<Recomendacion, RecomendacionAdapter.RecomendacionViewHolder>(RecomendacionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recomendacion, parent, false)
        return RecomendacionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecomendacionViewHolder, position: Int) {
        val recomendacion = getItem(position)
        holder.bind(recomendacion)
    }

    class RecomendacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreLugarTextView: TextView = itemView.findViewById(R.id.nombreRecomendacion)
        private val ubicacionTextView: TextView = itemView.findViewById(R.id.ubicacionRecomendacion)
        private val ratingTextView: TextView = itemView.findViewById(R.id.ratingRecomendacion)

        fun bind(recomendacion: Recomendacion) {
            // Asignar valores a los TextView
            nombreLugarTextView.text = recomendacion.nombreLugar
            ubicacionTextView.text = recomendacion.ubicacion
            ratingTextView.text = recomendacion.rating.toString()
        }
    }

    private class RecomendacionDiffCallback : DiffUtil.ItemCallback<Recomendacion>() {
        override fun areItemsTheSame(oldItem: Recomendacion, newItem: Recomendacion): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recomendacion, newItem: Recomendacion): Boolean {
            return oldItem == newItem
        }
    }
}
