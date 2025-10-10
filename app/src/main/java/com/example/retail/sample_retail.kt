package com.example.retail

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sample_retail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sample_retail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get IDs
        val drink_spinner: Spinner=findViewById<Spinner>(R.id.drink_spin)
        val size_spinner: Spinner=findViewById<Spinner>(R.id.size_spin)

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

        // Values for drinks
        data class Drinks(val name: String, val price: Double)
        val drinkArray = arrayOf(
            Drinks("Mango Juice", 20.00),
            Drinks("Milk Tea", 30.00),
            Drinks("Milkshake", 40.00)
        )

            // convert to String
                val choice_drink = getItemAtPosition(.toString()

        // switch cases for prices
        // assign an id for each size
        // Small = S, Medium = M, Large = L

        // For Display
        val display_drink = arrayOf("Mango", "Milk Tea", "Milkshake")
        val display_size = arrayOf("Small","Medium","Large")
            // ArrayAdapter code to display arrays as options
                // for drinks
        val drink_adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, display_drink)
        drink_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                // for sizes
        val size_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, display_size)
        size_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                // to attach
        drink_spinner.adapter = drink_adapter
        size_spinner.adapter = size_adapter;
    }
}