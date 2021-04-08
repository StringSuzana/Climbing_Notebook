package hr.santolin.climbingnotebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity
import hr.santolin.climbingnotebook.utils.applyAnimation


class ClimbedAdapter(private val items: MutableList<ClimbedEntryEntity>) :
    RecyclerView.Adapter<ClimbedAdapter.ViewHolder>() {
    inner class ViewHolder(climbedItemView: View) : RecyclerView.ViewHolder(climbedItemView) {
        private val tvClimbedDescription: TextView =
            climbedItemView.findViewById(R.id.tvClimbedDescription)
        private val tvGradeDescription: TextView =
            climbedItemView.findViewById(R.id.tvGradeDescription)
        private var ivClimbed: ImageView = climbedItemView.findViewById(R.id.ivClimbed)

        fun bind(item: ClimbedEntryEntity) {
            tvClimbedDescription.text = "${item.mountain}, ${item.routeName}, ${item.routeHeight}"
            ivClimbed.setImageResource(R.drawable.purple_mountain)//set picture if it is in database
            //how to check for orientation here?
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//what is ViewGroup?
        return ViewHolder(
            climbedItemView = LayoutInflater.from(parent.context)
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
        setAnimation(holder.itemView, position);
    }
    private var lastPosition = -1

    private fun setAnimation(itemView: View, position: Int) {

        if (position > lastPosition) {
            itemView.applyAnimation(R.anim.right_to_left)
            lastPosition = position
        }
    }

    override fun getItemCount() = items.size

}