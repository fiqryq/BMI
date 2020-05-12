package com.suncode.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = Intent(getIntent())
        datUmur.text = ": " + intent.getStringExtra("UMUR")
        datBB.text = ": " + intent.getStringExtra("BB") + " kg"
        datTB.text = ": " + intent.getStringExtra("TB") + " m"
        datKEL.text = ": " + intent.getStringExtra("JK")
        datBMI.text = ": " + intent.getStringExtra("BMINUM")
        datHasil.text = ": " + intent.getStringExtra("BMIRES")

    }
}
