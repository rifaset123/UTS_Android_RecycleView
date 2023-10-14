package com.example.uts_android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.example.uts_android.databinding.ActivitySummaryBinding

class Summary : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val judul: String? = intent.getStringExtra(MoviesAdapter.JUDUL_EXTRA)
        val gmbr: Int = intent.getIntExtra(MoviesAdapter.GAMBAR_EXTRA, 0)
        val selectedBioskop: String? = intent.getStringExtra("SELECTED_BIOSKOP")
        val selectedSeat: String? = intent.getStringExtra("SELECTED_SEAT")
        val selectedDate: String? = intent.getStringExtra("SELECTED_DATE")
        val selectedPayment: String? = intent.getStringExtra("SELECTED_PAYMENT")

        val rek = intent.getStringExtra(Payment.BANK_EXTRA)
        binding.angkaRandom.text = "21607 $rek"



        binding.MovieTitleSummary.text = judul
        binding.BioskopSummary.text = selectedBioskop
        binding.TanggalSummary.text = selectedDate
        binding.seat.text = selectedSeat
        binding.RegularSeat.text = selectedSeat
        if (selectedSeat == "Regular") {
            binding.Money.text = "Rp. 25.000"
            binding.paySeat.text = "Rp. 25.00"
        } else if (selectedSeat == "Starium") {
            binding.Money.text = "Rp. 35.000"
            binding.paySeat.text = "Rp. 35.000"
        } else if (selectedSeat == "Gold Class") {
            binding.Money.text = "Rp. 45.000"
            binding.paySeat.text = "Rp. 45.000"
        } else if (selectedSeat == "Velvet Class") {
            binding.Money.text = "Rp. 60.000"
            binding.paySeat.text = "Rp. 60.000"
        }
        binding.PayMeth.text = selectedPayment

        Glide.with(this)
            .load(gmbr)
            .into(binding.imageMovieSummary)
    }
}