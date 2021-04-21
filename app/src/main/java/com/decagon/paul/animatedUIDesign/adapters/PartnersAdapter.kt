package com.decagon.paul.animatedUIDesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decagon.paul.animatedUIDesign.model.PartnersModel
import com.decagon.paul.animatedUIDesign.R

class PartnersAdapter(val data : List<PartnersModel>):RecyclerView.Adapter<PartnersAdapter.DebitCardViewHolder>() {


    inner class DebitCardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var name: TextView = itemView.findViewById(R.id.company_name)
        private var discount: TextView = itemView.findViewById(R.id.discount)
        private  var productType:TextView = itemView.findViewById(R.id.product_type)
        private  var shoppingLogo:ImageView = itemView.findViewById(R.id.shoping_logo)

        fun bind(partnersModel: PartnersModel) {
            var  context = shoppingLogo.context
            name.text = partnersModel.name
            discount.text = partnersModel.discaount
            productType.text = partnersModel.products
        //shoppingLogo.setImageDrawable(getResources().getDrawable(R.drawable.image_name))
            shoppingLogo.setImageDrawable(ContextCompat.getDrawable(context,partnersModel.image))
        // setImageDrawable(getResources().getDrawable(R.drawable.image_name))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebitCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return DebitCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DebitCardViewHolder, position: Int) {
        holder.bind(data[position])
    }


}