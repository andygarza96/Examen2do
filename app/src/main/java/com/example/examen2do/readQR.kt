package com.example.examen2do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_read_qr.*
import com.google.zxing.integration.android.IntentIntegrator

import org.json.JSONException
import org.json.JSONObject


class readQR : AppCompatActivity() {

    internal var qrScanIntegrator: IntentIntegrator? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_qr)

        btnQClose.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        qrScanIntegrator = IntentIntegrator(this)

        btnQScan.setOnClickListener {performAction()

        }
    }

    private fun performAction() {
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this,("Not found"), Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    // Show values in UI.
                    txtQBrand?.text = obj.getString("brand")
                    txtQModel?.text = obj.getString("model")
                    txtQYear?.text = obj.getString("year")
                    txtQDebt?.text = obj.getString("debt")

                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}



