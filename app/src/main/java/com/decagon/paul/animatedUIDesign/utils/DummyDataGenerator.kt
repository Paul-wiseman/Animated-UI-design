package com.decagon.paul.animatedUIDesign.utils

import android.graphics.Color
import com.decagon.paul.animatedUIDesign.R
import com.decagon.paul.animatedUIDesign.model.AccountData
import com.decagon.paul.animatedUIDesign.model.PartnersModel

object DummyDataGenerator {

    fun allData(): List<PartnersModel> {
        return listOf(
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

    }


    fun accounts(): List<AccountData> {
        return listOf(
            AccountData(
                R.color.blue, "Abdulrazaq", "$120,3300,45"
            ),
            AccountData(
                Color.BLUE, "Mubarak", "$40,2443,13"
            ),
            AccountData(
                Color.RED, "Olalekun", "$99,393,924"
            ),
            AccountData(
                R.color.teal_700, "Oladakpo", "$12386595"
            ),
            AccountData(R.color.purple_700, "Emeka", "$123,568,909,876.3")

        )

    }
}