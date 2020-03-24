package com.example.segunda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_descr.*
import org.jetbrains.anko.db.insert

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val db = DBAcces.getInstance(this)

        intent?.extras?.let {
            val title = it.getString("title")
            val descr = it.getString("desc")
            val price = it.getDouble("price")

            txtDetailT.text = title
            txtDetailD.text = descr
            txtDetailP.text = "$ ${String.format("%.2f", price)}"

            btnDetailBuy.setOnClickListener {
                db?.use {
                    val namePr = "name" to title
                    val descPr = "desc" to descr
                    val pricePr = "price" to price

                    insert("Productos",namePr,descPr,pricePr)
                }



            }

        }

    }
}
