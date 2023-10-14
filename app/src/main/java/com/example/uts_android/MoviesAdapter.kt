package com.example.uts_android

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter ( private val MoviesName : List<String>, private var rating: List<Int>, private var images:List<Int>,
                      private val story: List<String>, private val director: List<String>)
    : RecyclerView.Adapter<MoviesAdapter.ViewHolder>(){
    companion object{
        const val JUDUL_EXTRA = "nama"
        const val RATING_EXTRA = "2"
        const val GAMBAR_EXTRA = "1"
        const val STORY_EXTRA = "story"
        const val DIREC_EXTRA = ""
    }
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val itemTitle: TextView = itemView.findViewById(R.id.MovieName)
            val itemRating: AppCompatRatingBar = itemView.findViewById(R.id.ratingBar)
            val itemImage: ImageView = itemView.findViewById(R.id.imageMovie)

            init {
                itemView.setOnClickListener { v: View ->
//                    Toast.makeText(itemView.context, "${MoviesName[position]} ", Toast.LENGTH_SHORT).show()
                    val intent = Intent(itemView.context, DetailMovie::class.java)
                    intent.putExtra(JUDUL_EXTRA, MoviesName[position])
                    intent.putExtra(RATING_EXTRA, rating[position])
                    intent.putExtra(GAMBAR_EXTRA, images[position])
                    intent.putExtra(STORY_EXTRA, story[position])
                    intent.putExtra(DIREC_EXTRA, director[position])
                    itemView.context.startActivity(intent)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_countainer_movie, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MoviesName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = MoviesName[position].toString()
        holder.itemRating.rating = rating[position].toFloat()
        holder.itemImage.setImageResource(images[position])
    }
}