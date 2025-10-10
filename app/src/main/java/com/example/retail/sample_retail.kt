package com.example.retail

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class sample_retail : AppCompatActivity() {

    /*Simple_Retail flow

    Select Drink (mango, milktea, Choco)
    ↓
    Size (small, medium , large)
    ↓
    subtotal
    ↓
    payment
    ↓
    Final total/change*/

    var drinks = arrayOf("Mango", "Milk Tea", "Praf")

    var drink_Size= arrayOf("Small","Medium","Large")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sample_retail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner: Spinner=findViewById<Spinner>(R.id.drink_spin)
        //for arrayadapter
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, drinks)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //to attach
        spinner.adapter = adapter

        // for size
        val size_spinner: Spinner=findViewById<Spinner>(R.id.size_spin)
        val ad = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, drink_Size)
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        size_spinner.adapter = ad;

    }






}