package com.example.examen2do

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cars.*

class cars : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cars)

        val sharedPreferences = getSharedPreferences("Car", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val cars = sharedPreferences.getString("cars", "")


        this.etxtCBrand.setText(cars)

        btnCSave.setOnClickListener {
            editor.putString("cars", etxtCBrand.text.toString())
            editor.commit()

            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

    }
}
