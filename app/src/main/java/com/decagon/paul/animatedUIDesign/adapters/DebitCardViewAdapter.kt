package com.decagon.paul.animatedUIDesign.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decagon.paul.animatedUIDesign.R
import com.decagon.paul.animatedUIDesign.model.AccountData

class DebitCardViewAdapter( val data: List<AccountData>):RecyclerView.Adapter<DebitCardViewAdapter.DebitCardViewHolder>() {
   inner class DebitCardViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       val accountname: TextView = itemView.findViewById(R.id.tv_accountname)
       var accountbalance: TextView = itemView.findViewById(R.id.tv_accountbalance)
       val cardviewcolor: CardView = itemView.findViewById(R.id.viewpager_cv)

       init {

       }

       fun bind(data: AccountData){
           var context = cardviewcolor.context
//           var color = context.resources.getColor(R.color.blue)
           var color2 = ContextCompat.getColor(context, data.color)
           accountname.text=data.accounname
           accountbalance.text=data.accountbalance
           cardviewcolor.setCardBackgroundColor(color2)
       }
   }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DebitCardViewAdapter.DebitCardViewHolder {
        return DebitCardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewpager2layout, parent, false))

    }

    override fun getItemCount(): Int {
return data.size
    }

    override fun onBindViewHolder(holder: DebitCardViewAdapter.DebitCardViewHolder, position: Int) {
        var dataItem = data[position]
//        if(position%2 == 0){
//            dataItem.color = R.color.blue
//        }
        holder.bind(dataItem)

    }
}