package hr.santolin.climbingnotebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity

class ClimbedAdapter(private val items: MutableList<ClimbedEntryEntity>) :
    RecyclerView.Adapter<ClimbedAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvClimbedDescription: TextView =
            itemView.findViewById(R.id.tvClimbedDescription)
        private val tvGradeDescription: TextView = itemView.findViewById(R.id.tvGradeDescription)
        fun bind(item: ClimbedEntryEntity) {
            tvClimbedDescription.text = "${item.mountain}, ${item.routeName}, ${item.routeHeight}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.climbed_item, parent, false)
        )
    }

    //when i'm binding (hence the method bind ), pass in viewHolder and position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
/*        holder.itemView.setOnLongClickListener { //cool: remove from list on long press
            items.removeAt(position)
            notifyDataSetChanged()
            true
        }*/
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

}