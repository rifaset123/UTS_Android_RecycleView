package com.example.uts_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.uts_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val NAMA_EXTRA = "nama"
        const val PASSWORD_EXTRA = "password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  // untuk memaksa light mode
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        with(binding) {
            btn.setOnClickListener {
                val intentToHomepage =
                    Intent(this@MainActivity, home_activity::class.java)
                intentToHomepage.putExtra(NAMA_EXTRA, username.text.toString())
                intentToHomepage.putExtra(PASSWORD_EXTRA, pass.text.toString())

                if (username.text.toString() == "Rifa" && pass.text.toString() == "123"){
                    startActivity(intentToHomepage)
                }
                else{
                    Toast.makeText(this@MainActivity, "Username atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
        Log.d(TAG, "onCreate: dipanggil")
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: dipanggil")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: dipanggil")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: dipanggil")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: dipanggil")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: dipanggil")
    }
}