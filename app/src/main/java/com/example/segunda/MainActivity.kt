package com.example.segunda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcViewLand.layoutManager = GridLayoutManager(this, 2)
        val itemsShop = (0..20).map {
            ItemLanding("Titulo $it","Descripcion $it", 200.00 + it)
        }

        val adapter = AdapterLanding(itemsShop)

        rcViewLand.adapter= adapter


    }
}
