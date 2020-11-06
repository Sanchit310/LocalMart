package example.android.localmart.ui.storeItems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import example.android.localmart.R
import example.android.localmart.data.model.StoreItemModel
import kotlinx.android.synthetic.main.activity_store_item.*

class StoreItemActivity : AppCompatActivity(), StoreItemAdapter.OnItemClickListener {

    private lateinit var storeItemAdapter: StoreItemAdapter
    private val itemList = arrayListOf<StoreItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_item)

        storeItemAdapter = StoreItemAdapter(getItemList(), this)
        storeItemRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        storeItemRecyclerview.adapter = storeItemAdapter

    }

    private fun getItemList() : ArrayList<StoreItemModel>{

        itemList.add(StoreItemModel("a","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("b","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("c","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("d","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("e","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("f","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("g","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("h","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("i","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("j","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("k","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("l","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("m","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("n","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("o","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("p","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("q","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("r","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("s","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("t","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("u","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("v","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("w","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("x","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("y","h",70, "500 ml", 10, 0, false))
        itemList.add(StoreItemModel("z","h",70, "500 ml", 10, 0, false))
        return itemList

    }

    override fun onItemClick(position: Int) {
        itemList[position].isInCart = true
        storeItemAdapter.notifyItemChanged(position)

    }

    override fun onAddClick(position: Int) {
        itemList[position].itemQuantitySelected = itemList[position].itemQuantitySelected + 1
        storeItemAdapter.notifyItemChanged(position)
    }

    override fun onRemoveClick(position: Int) {
        itemList[position].itemQuantitySelected = itemList[position].itemQuantitySelected - 1
        storeItemAdapter.notifyItemChanged(position)
    }
}
