package com.suncode.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSpiner()

    }

    fun createSpiner(){
        val JenisKelamin : Spinner = findViewById(R.id.SpinJenisKelamin)
        ArrayAdapter.createFromResource(this,R.array.jenis_kelamin,android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            JenisKelamin.adapter = adapter
        }
    }
}
