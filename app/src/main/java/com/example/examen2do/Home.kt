package com.example.examen2do

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_about.view.*
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnHAbout.setOnClickListener {
            val about = layoutInflater.inflate(R.layout.activity_about,null)
            val myBuilder = AlertDialog.Builder(this).setView(about).setTitle("Login Form").show()

            about.btnAClose.setOnClickListener {

                myBuilder.dismiss()

            }

            about.btnAGit.setOnClickListener {
                val url = "https://github.com/andygarza96"
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            }
        }

        btnHCars.setOnClickListener {
            val intent = Intent(this, cars::class.java)
            startActivity(intent)

        }

        btnHReadLicense.setOnClickListener {
            val intent = Intent(this, readQR::class.java)
            startActivity(intent)
        }

        btnHLogOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}
