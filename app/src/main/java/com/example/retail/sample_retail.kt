package com.example.retail

import android.os.Bundle
import android.widget.*
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
        val drink_spinner: Spinner = findViewById(R.id.drink_spin)
        val size_spinner: Spinner = findViewById(R.id.size_spin)
        val compute_btn = findViewById<Button>(R.id.btn_compute)
        val show_total = findViewById<TextView>(R.id.show_total)

        /*Simple_Retail flow
        Select Drink (mango, milk tea, Choco)
        Size (small, medium , large)
        subtotal
        payment
        Final total/change*/

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
        size_spinner.adapter = size_adapter

        // Price handling
            // Values for drinks
        data class Drinks(val name: String, val price: Double)
            val Fruit1 = Drinks("Mango Juice", 20.00)
            val Tea1 = Drinks("Milk Tea", 30.00)
            val Milk1 = Drinks("Milkshake", 40.00)

            var drink_price: Double

            compute_btn.setOnClickListener{

                    val choice_drink = drink_spinner.getSelectedItem()
                    val choice_size = size_spinner.getSelectedItem()

                    when (choice_size) {
                        "Small" -> when (choice_drink) {
                            "Mango Juice" -> drink_price = Fruit1.price * 1
                            "Milk Tea" -> drink_price = Tea1.price * 1
                            "Milkshake" -> drink_price = Milk1.price * 1
                        }
                        "Medium" -> when (choice_drink) {
                            "Mango Juice" -> drink_price = Fruit1.price * .25
                            "Milk Tea" -> drink_price = Tea1.price * .25
                            "Milkshake" -> drink_price = Milk1.price * .25
                        }
                        "Large" -> when (choice_drink) {
                            "Mango Juice" -> drink_price = Fruit1.price * .5
                            "Milk Tea" -> drink_price = Tea1.price * .5
                            "Milkshake" -> drink_price = Milk1.price * .5
                        }
                }
                    show_total.text = drink_price
             }
        }
    }