package example.android.localmart.ui.storeItems

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import example.android.localmart.R
import example.android.localmart.data.model.StoreItemModel
import kotlinx.android.synthetic.main.item_layout.view.*

class StoreItemAdapter(val storeItemList : ArrayList<StoreItemModel>, val listener : OnItemClickListener) : RecyclerView.Adapter<StoreItemAdapter.StoreItemViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
        fun onAddClick(position: Int)
        fun onRemoveClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return StoreItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: StoreItemViewHolder, position: Int) {
        val currentItem = storeItemList[position]
        holder.itemName.text = currentItem.itemName
        holder.itemPrice.text = currentItem.itemPrice.toString()
        holder.itemQty.text = currentItem.itemQty
        holder.itemQtySelected.text = currentItem.itemQuantitySelected.toString()

        if(currentItem.isInCart){
            holder.addBtn.visibility = View.GONE
            holder.quantityLayout.visibility = View.VISIBLE
        }else{
            holder.addBtn.visibility = View.VISIBLE
            holder.quantityLayout.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return storeItemList.size
    }


    inner class StoreItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val itemName =  itemView.itemName
        val itemPrice = itemView.itemPrice
        val itemQty = itemView.itemQty
        //val itemQtyAvl = itemView.itemQ
        val itemQtySelected = itemView.itemQuantitySelected
        val itemImage =  itemView.itemImage
        val addBtn = itemView.addBtn
        val itemAddBtn = itemView.addItemBtn
        val itemRemoveBtn = itemView.removeItemBtn
        val quantityLayout = itemView.quantityLayout

        init {
            addBtn.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    listener.onItemClick(position)
                }
            })

            itemAddBtn.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    listener.onAddClick(position)
                }
            })

            itemRemoveBtn.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    listener.onRemoveClick(position)
                }
            })
        }

    }


}