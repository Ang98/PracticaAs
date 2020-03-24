package com.example.segunda

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_landing.view.*

class AdapterLanding(val data : List<ItemLanding>): RecyclerView.Adapter<AdapterLanding.Holder>(){

    class Holder (itemView : View): RecyclerView.ViewHolder(itemView){
        fun binView(itemLanding: ItemLanding){
            with(itemLanding){
                itemView.txtTitleItem.text= titulo
                itemView.txtDescItem.text= desc
                itemView.txtPriceItem.text = "$ ${String.format("%.2f",precio)}"

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("title",titulo)
                    intent.putExtra("desc",titulo)
                    intent.putExtra("price",titulo)

                    val p1:Pair<View,String> = Pair.create(itemView.imgItemHeader,"transitionHeader")
                    val p2:Pair<View,String> = Pair.create(itemView.txtTitleItem,"transitionHeader")
                    val p3:Pair<View,String> = Pair.create(itemView.txtDescItem,"transitionHeader")
                    val p4:Pair<View,String> = Pair.create(itemView.txtPriceItem,"transitionHeader")

                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1,p2,p3,p4)
                    itemView.context.startActivity(intent,options.toBundle())

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(parent.inflate(R.layout.item_landing))

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binView(data[position])
    }

}