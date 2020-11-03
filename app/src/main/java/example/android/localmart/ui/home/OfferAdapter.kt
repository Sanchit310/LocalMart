package example.android.localmart.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.android.localmart.R
import example.android.localmart.data.model.OfferModel
import kotlinx.android.synthetic.main.offer_item.view.*

class OfferAdapter(val context: Context, val offerList : ArrayList<OfferModel>): RecyclerView.Adapter<OfferAdapter.OfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_item, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        var offer = offerList[position]
        holder.offerNamee.text = offer.offerName

    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offerImage = itemView.offerImage
        val offerNamee = itemView.offerName

    }
}