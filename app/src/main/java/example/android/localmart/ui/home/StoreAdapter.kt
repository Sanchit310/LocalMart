package example.android.localmart.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import example.android.localmart.R
import example.android.localmart.data.model.StoreModel
import kotlinx.android.synthetic.main.store_item.view.*

class StoreAdapter(val storeList : ArrayList<StoreModel>, private val listener : OnItemClickListener) : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_item, parent, false)
        return StoreViewHolder(view)
    }


    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val currentStore = storeList[position]
        holder.storeName.text = currentStore.storeName
        holder.storeCategory.text = currentStore.storeType
        holder.storeRating.text = currentStore.storeRating
    }

    override fun getItemCount(): Int {
        return storeList.size
    }


    inner class StoreViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val storeName = itemView.storeName
        val storeImage = itemView.storeImage
        val storeCategory = itemView.storeCategory
        val storeRating = itemView.storeRating

        init {
            itemView.setOnClickListener(View.OnClickListener {

                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position)
                    }

            })
        }

    }
}