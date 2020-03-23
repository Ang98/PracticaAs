package com.example.segunda

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_landing.view.*

class AdapterLanding(val data : List<ItemLanding>): RecyclerView.Adapter<AdapterLanding.Holder>(){

    class Holder (itemView : View): RecyclerView.ViewHolder(itemView){
        fun binView(itemLanding: ItemLanding){
            with(itemLanding){
                itemView.txtTitleI.text= titulo
                itemView.txtDescI.text= desc
                itemView.txtPriceI.text = "$ ${String.format("%.2f",precio)}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(parent.inflate(R.layout.item_landing))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binView(data[position])
    }

}