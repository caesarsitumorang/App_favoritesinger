package com.example.penyanyifavorit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DetailActivity : AppCompatActivity() {
    companion object {
        const val key_penyanyi = "Penyanyi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataPenyanyi = intent.getParcelableExtra<Penyanyi>(key_penyanyi)

        val tvDetailNamaPenyanyi: TextView = findViewById(R.id.namapenyanyi)
        val tvDetailDescriptionPenyanyi: TextView = findViewById(R.id.deskripsifoto)
        val imgDetailPenyanyi: ImageView = findViewById(R.id.imgPhoto)

        tvDetailNamaPenyanyi.text = dataPenyanyi?.name
        tvDetailDescriptionPenyanyi.text = dataPenyanyi?.description
        imgDetailPenyanyi.setImageResource(dataPenyanyi?.photo ?: 0)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
