package com.suncode.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Global Variable
    var spinJenisKelamin = ""
    var hasilBMI = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val JenisKelamin: Spinner = findViewById(R.id.SpinJenisKelamin)
        ArrayAdapter.createFromResource(
            this,
            R.array.jenis_kelamin,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            JenisKelamin.adapter = adapter
        }

        JenisKelamin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Reassign
                spinJenisKelamin = parent?.getItemAtPosition(position).toString()
            }
        }

        btHitung.setOnClickListener {
            val umur = etUmur.text.toString()
            val bb = etBB.text.toString().toFloat()
            val tinggi = etTinggi.text.toString().toFloat() / 100
            val hasil = bb / (tinggi * tinggi)

            if (hasil < 17) {
                hasilBMI = "Kurus, Kekurangan berat badan berat"
            } else if (hasil >= 17 && hasil <= 18.0) {
                hasilBMI = "Kurus, Kekurangan berat badan ringan"
            } else if (hasil >= 18.5 && hasil <= 25.0) {
                hasilBMI = "Normal"
            } else if (hasil >= 25.1 && hasil <= 27.0) {
                hasilBMI = "Gemuk, Kelebihan berat badan tingkat ringan"
            } else if (hasil > 27) {
                hasilBMI = "Gemuk, Kelebihan berat badan tingkat berat"
            }

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("UMUR", umur)
            intent.putExtra("BB", bb.toString())
            intent.putExtra("TB", tinggi.toString())
            intent.putExtra("JK", spinJenisKelamin)
            intent.putExtra("BMINUM", hasil.toString())
            intent.putExtra("BMIRES", hasilBMI)
            startActivity(intent)
        }
    }
}
