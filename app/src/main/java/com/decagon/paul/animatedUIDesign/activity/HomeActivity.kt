package com.decagon.paul.animatedUIDesign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.decagon.paul.animatedUIDesign.adapters.PartnersAdapter
import com.decagon.paul.animatedUIDesign.model.PartnersModel
import com.decagon.paul.animatedUIDesign.R
import com.decagon.paul.animatedUIDesign.adapters.DebitCardViewAdapter
import com.decagon.paul.animatedUIDesign.model.AccountData
import com.decagon.paul.animatedUIDesign.naviagationFragments.HistoryFragment
import com.decagon.paul.animatedUIDesign.naviagationFragments.PaymentFragment
import com.decagon.paul.animatedUIDesign.naviagationFragments.ProductFragment
import com.decagon.paul.animatedUIDesign.naviagationFragments.SupportFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.relex.circleindicator.CircleIndicator3


class HomeActivity : AppCompatActivity() {
    private val allData: List<PartnersModel> = listOf(
        PartnersModel(
            R.drawable.ic_shopping_bag_1,
            "AliExpress",
            "from 4%",
            "Cloth and shoes"

        ),
        PartnersModel(
            R.drawable.ic_shopping_bag_1__blue,
            "Aviasales",
            "from 4.4%",
            "Tickets and travels"
        ),
        PartnersModel(
            R.drawable.ic_shopping_bag_1__blue,
            "Jumia",
            "from 12%",
            "Groceries"
        )
    )

    private val accounts:List<AccountData> = listOf(AccountData(R.color.blue, "Abdulrazaq","20,3300,45"),
    AccountData(R.color.teal_700,"Mubarak", "40,2443,13"),
    AccountData(R.color.purple_700,"Olalekun","99,393,924")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomViewNav = findViewById<BottomNavigationView>(R.id.bottom_navigationView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val indicator3 = findViewById<CircleIndicator3>(R.id.indicator)
        indicator3.setViewPager(viewPager2)
        viewPager2.adapter = DebitCardViewAdapter(accounts)
        recyclerView.adapter = PartnersAdapter(allData)


        //recyclerView.hasFixedSize()
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val productFragment = ProductFragment()
        val paymentFragment = PaymentFragment()
        val historyFragment = HistoryFragment()
        val supportFragment = SupportFragment()


        getCurrentFragment(productFragment)
        bottomViewNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bn_product -> getCurrentFragment(productFragment)
                R.id.payment -> getCurrentFragment(paymentFragment)
                R.id.bn_history -> getCurrentFragment(historyFragment)
                R.id.bnsupport -> getCurrentFragment(supportFragment)
            }
            true
        }
    }
   private fun  getCurrentFragment(fragment:Fragment) =
       supportFragmentManager.beginTransaction().apply{
        replace(R.id.fl_fragment, fragment)
           commit()


       }
}


