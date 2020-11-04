package example.android.localmart.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.android.localmart.R
import example.android.localmart.data.model.CategoryOptionModel
import kotlinx.android.synthetic.main.category_option_item.view.*

class CategoryOptionAdapter(val context: Context, val categoryOptionList : ArrayList<CategoryOptionModel>) : RecyclerView.Adapter<CategoryOptionAdapter.CategoryOptionsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryOptionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_option_item, parent, false)
        return CategoryOptionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryOptionsViewHolder, position: Int) {
        val categoryOption = categoryOptionList[position]
        holder.categoryName.text = categoryOption.categoryName
    }

    override fun getItemCount(): Int {
        return categoryOptionList.size
    }

    class CategoryOptionsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val categoryIcon = itemView.categoryIcon
        val categoryName = itemView.categoryName
    }


}