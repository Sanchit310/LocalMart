package example.android.localmart.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import example.android.localmart.R
import example.android.localmart.data.model.CategoryOptionModel
import example.android.localmart.data.model.OfferModel
import example.android.localmart.data.model.StoreModel
import example.android.localmart.ui.storeItems.StoreItemActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), StoreAdapter.OnItemClickListener {

    private lateinit var offerAdapter: OfferAdapter
    private lateinit var categoryOptionAdapter: CategoryOptionAdapter
    private lateinit var storeAdapter: StoreAdapter
    private val storeList = arrayListOf<StoreModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        categoryOptionAdapter = CategoryOptionAdapter(this, getCategoryOptionList())
        categoryOptions.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryOptions.adapter = categoryOptionAdapter


        storeAdapter = StoreAdapter( getStoreList(), this)
        allStoresRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        allStoresRecyclerview.adapter = storeAdapter
        allStoresRecyclerview.isNestedScrollingEnabled = false

        offerAdapter = OfferAdapter(this, getOfferList())
        offerViewPager.adapter = offerAdapter
        offerViewPager.clipToPadding = false
        offerViewPager.clipChildren = false
        offerViewPager.offscreenPageLimit = 2

        offerViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val composite = CompositePageTransformer()
        composite.addTransformer(MarginPageTransformer(80))
        offerViewPager.setPageTransformer(composite)

    }


    private fun getOfferList() : ArrayList<OfferModel>{
        val offerList = arrayListOf<OfferModel>()
        offerList.add(OfferModel("h","50"))
        offerList.add(OfferModel("h","40"))
        offerList.add(OfferModel("h","30"))
        offerList.add(OfferModel("h","60"))
        offerList.add(OfferModel("h","70"))
        return offerList
    }

    private fun getCategoryOptionList() : ArrayList<CategoryOptionModel>{
        val categoryOptionList = arrayListOf<CategoryOptionModel>()
        categoryOptionList.add(CategoryOptionModel("h", "Food"))
        categoryOptionList.add(CategoryOptionModel("h", "Carpentry"))
        categoryOptionList.add(CategoryOptionModel("h", "Plumbing"))
        categoryOptionList.add(CategoryOptionModel("h", "Electronics"))
        categoryOptionList.add(CategoryOptionModel("h", "Food"))
        categoryOptionList.add(CategoryOptionModel("h", "Carpentry"))
        categoryOptionList.add(CategoryOptionModel("h", "Plumbing"))
        categoryOptionList.add(CategoryOptionModel("h", "Electronics"))
        return categoryOptionList
    }

    private fun getStoreList() : ArrayList<StoreModel>{

        storeList.add(StoreModel("Jay Confectionary", "Bakery", "3/5", 1, "h"))
        storeList.add(StoreModel("Sonu Electrician", "Electricity", "3/5", 1, "h"))
        storeList.add(StoreModel("Tam Grocery", "Groceries", "3/5", 1, "h"))
        storeList.add(StoreModel("Monu Grocery", "Groceries", "3/5", 1, "h"))
        storeList.add(StoreModel("Singh Dairy", "Dairy", "3/5", 1, "h"))
        storeList.add(StoreModel("Chotu Plumber", "Plumbing", "3/5", 1, "h"))
        storeList.add(StoreModel("Happy Bakers", "Bakery", "3/5", 1, "h"))
        return storeList
    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this, StoreItemActivity::class.java)
        startActivity(intent)
    }
}
