package com.example.uts_android

import android.app.Activity
import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import com.example.uts_android.MoviesAdapter.Companion.JUDUL_EXTRA
import com.example.uts_android.databinding.ActivityDetailMovieBinding
import com.example.uts_android.databinding.ActivityPaymentBinding
import java.util.Calendar

class Payment : AppCompatActivity() {
    private lateinit var spinnerSeat: Spinner
    private lateinit var textView: TextView
    private lateinit var price: TextView
    private lateinit var RealPrice: TextView
    companion object{
        const val BANK_EXTRA = "3"
    }
    private lateinit var binding: ActivityPaymentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  // untuk memaksa light mode

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        spinnerSeat = findViewById(R.id.spinnerSeat)
        textView = findViewById(R.id.RegSeat)
        price = findViewById(R.id.Price) // ini buat nampilin harga
        RealPrice = findViewById(R.id.RealPrice) // total harga

        with(binding) {
            spinnerSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View?,
                    position: Int,
                    id: Long
                )
                {
                    // Ambil teks yang dipilih dari Spinner
                    val selectedItem = spinnerSeat.selectedItem.toString()
                    if (selectedItem == "Regular") {
                        price.text = "Rp. 25.000"
                        RealPrice.text = "Rp. 25.000"
                    } else if (selectedItem == "Starium") {
                        price.text = "Rp. 35.000"
                        RealPrice.text = "Rp. 35.000"
                    } else if (selectedItem == "Gold Class") {
                        price.text = "Rp. 45.000"
                        RealPrice.text = "Rp. 45.000"
                    } else if (selectedItem == "Velvet Class") {
                        price.text = "Rp. 60.000"
                        RealPrice.text = "Rp. 60.000"
                    }
                    // tampilkan teks yang dipilih ke TextView
                    textView.text = selectedItem

                }
                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // ini kosong cuma buat nglengkapin onItemSelected
                }

            }
            fun openActivity2() {
                val resultIntent = Intent(this@Payment, Summary::class.java)
                val judul: String? = intent.getStringExtra(JUDUL_EXTRA)
                val dir: String? = intent.getStringExtra(MoviesAdapter.DIREC_EXTRA)
                val gmbr: Int = intent.getIntExtra(MoviesAdapter.GAMBAR_EXTRA, 0)
                val sinopsis: String? = intent.getStringExtra(MoviesAdapter.STORY_EXTRA)

                // Add the selected data to the intent
                val selectedBioskop = spinnerBioskop.selectedItem.toString()
                val selectedSeat = spinnerSeat.selectedItem.toString()
                val selectedDate = "${datePicker.dayOfMonth}/${datePicker.month}/${datePicker.year}"
                val selectedPayment = payment.selectedItem.toString()

                resultIntent.putExtra(MoviesAdapter.JUDUL_EXTRA, judul)
                resultIntent.putExtra(MoviesAdapter.DIREC_EXTRA, dir)
                resultIntent.putExtra(MoviesAdapter.GAMBAR_EXTRA, gmbr)
                resultIntent.putExtra(MoviesAdapter.STORY_EXTRA, sinopsis)
                resultIntent.putExtra(MoviesAdapter.STORY_EXTRA, sinopsis)
                resultIntent.putExtra("SELECTED_BIOSKOP", selectedBioskop)
                resultIntent.putExtra("SELECTED_SEAT", selectedSeat)
                resultIntent.putExtra("SELECTED_DATE", selectedDate)
                resultIntent.putExtra("SELECTED_PAYMENT", selectedPayment)
                resultIntent.putExtra(Payment.BANK_EXTRA, nomorBank.text.toString())

                setResult(Activity.RESULT_OK, resultIntent)
                startActivity(resultIntent)
            }

            with(binding) {
            btnGetTicket.setOnClickListener {
                openActivity2()
                // mengatur toast
            }

//                Toast.makeText(this@Payment, "$tahun/$bulan/$hari" , Toast.LENGTH_LONG).show()
            }
        }
    }
}