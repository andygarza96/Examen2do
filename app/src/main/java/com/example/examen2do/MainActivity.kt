package com.example.examen2do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_about.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.wrong_pass.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMLogIn.setOnClickListener {
            if(etxtMUser.text.toString() == "segundoparcial" && etxtMPassword.text.toString() == "1"){

                val intent = Intent(this, Home::class.java)
                startActivity(intent)

            } else {

                val wrong = layoutInflater.inflate(R.layout.wrong_pass,null)
                val myBuilder = AlertDialog.Builder(this).setView(wrong).setTitle("Login Form").show()

                wrong.btnWClose.setOnClickListener {

                    myBuilder.dismiss()

                }
        }
        }
    }
}
