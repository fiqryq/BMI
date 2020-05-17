package com.suncode.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = getString(R.string.admob_app_id)
        ads()

        val intent = Intent(getIntent())
        datUmur.text = intent.getStringExtra("UMUR")
        datBB.text = intent.getStringExtra("BB") + " kg"
        datTB.text = intent.getStringExtra("TB") + " m"
        datKEL.text = intent.getStringExtra("JK")
        datBMI.text = intent.getStringExtra("BMINUM")
        datHasil.text = intent.getStringExtra("BMIRES")

    }

    fun ads() {
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}
