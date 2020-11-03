package example.android.localmart.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import example.android.localmart.R
import example.android.localmart.data.model.OfferModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var offerAdapter: OfferAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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

    public fun getOfferList() : ArrayList<OfferModel>{
        val offerList = arrayListOf<OfferModel>()
        offerList.add(OfferModel("h","50"))
        offerList.add(OfferModel("h","40"))
        offerList.add(OfferModel("h","30"))
        offerList.add(OfferModel("h","60"))
        offerList.add(OfferModel("h","70"))
        return offerList
    }
}
