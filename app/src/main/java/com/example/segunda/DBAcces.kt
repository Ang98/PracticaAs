package com.example.segunda

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBAcces(ctx: Context): ManagedSQLiteOpenHelper(ctx,"angel", null, 1){

    companion object{

        private var instace : DBAcces? = null
        fun getInstance(ctx:Context): DBAcces? = if (instace==null){
            instace= DBAcces(ctx)
            instace
        }else{
            instace
        }

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val id = "id" to INTEGER  + PRIMARY_KEY
        val name = "name" to TEXT
        val desc = "desc" to TEXT
        val price = "price" to REAL

        db?.createTable("Productos",true,id,name,desc,price)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("Productos",true)
    }

    val Context.database: DBAcces?
        get() = getInstance(applicationContext)

}