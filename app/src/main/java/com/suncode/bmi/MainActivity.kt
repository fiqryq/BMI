package com.suncode.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Global Variable
    var spinJenisKelamin = ""

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
            val bb = etBB.text.toString().toFloat()
            val tinggi = etTinggi.text.toString().toFloat() / 100
            val hasil = bb / (tinggi * tinggi)
            hasilBMI.text = hasil.toString()
        }
    }
}
