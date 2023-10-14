package com.example.uts_android

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatRatingBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.uts_android.databinding.ActivityDetailMovieBinding
import com.example.uts_android.databinding.ActivityHomeBinding
import com.example.uts_android.databinding.ActivityMainBinding
import com.example.uts_android.databinding.ActivityPaymentBinding
import com.makeramen.roundedimageview.RoundedImageView

class DetailMovie : AppCompatActivity() {
    val JUDUL_EXTRA = "nama"
    val RATING_EXTRA = "2"
    private lateinit var binding: ActivityDetailMovieBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  // untuk memaksa light mode


        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title: TextView = findViewById(R.id.MovieTitle)
        val direc: TextView = findViewById(R.id.MovieDirector)
        val story: TextView = findViewById(R.id.DetailStory)
        val image: ImageView = findViewById(R.id.imageMovie)
        val itemRating: AppCompatRatingBar = findViewById(R.id.ratingBar1)

        val judul: String? = intent.getStringExtra(MoviesAdapter.JUDUL_EXTRA)
        val dir: String? = intent.getStringExtra(MoviesAdapter.DIREC_EXTRA)
        val gmbr: Int = intent.getIntExtra(MoviesAdapter.GAMBAR_EXTRA, 0)
        val sinopsis: String? = intent.getStringExtra(MoviesAdapter.STORY_EXTRA)
        val rating: Int = intent.getIntExtra(RATING_EXTRA, 0)


        title.text = judul
        direc.text = dir
        story.text = sinopsis
        itemRating.rating = rating.toFloat()


        // Gunakan Glide untuk memuat gambar ke RoundedImageView
        Glide.with(this)
            .load(gmbr)
            .into(image)

        with(binding) {
            getTicket.setOnClickListener {
                val intentToPayment =
                    Intent(this@DetailMovie, Payment::class.java)
                intentToPayment.putExtra(MoviesAdapter.JUDUL_EXTRA, judul)
                intentToPayment.putExtra(MoviesAdapter.GAMBAR_EXTRA, gmbr)
                intentToPayment.putExtra(MoviesAdapter.STORY_EXTRA, sinopsis)
                intentToPayment.putExtra(MoviesAdapter.DIREC_EXTRA, dir)
                startActivity(intentToPayment)
            }

        }

    }
}