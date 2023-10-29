package com.example.uts_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_android.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class home_activity : AppCompatActivity() {
    private var titlesList = mutableListOf<String>()
    private var ratingList = mutableListOf<Int>()
    private var imagaeList = mutableListOf<Int>()
    private var storyList = mutableListOf<String>()
    private var directorList = mutableListOf<String>()

    companion object{
        const val Judul = "judulnya"
        const val NAMA_EXTRA = "nama"
    }

    private lateinit var binding: ActivityHomeBinding
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNav = findViewById(R.id.bottomNavigationView) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeItem -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.settingsItem -> {
                    loadFragment(SettingFragment())
                    true
                }
                R.id.profileItem -> {
                    loadFragment(ProfileFragment())
                    true
                }

                else -> {
                    false}
            }
        }
        if (savedInstanceState == null) {
            val homeFragment = HomeFragment()

            val nama = intent.getStringExtra(MainActivity.NAMA_EXTRA)


            // Example: pass data using arguments
            val bundle = Bundle()
            bundle.putString(NAMA_EXTRA, nama)
            homeFragment.arguments = bundle

            // agar nge load fragment nya
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit()
        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }
    private fun addToList(title: String, rating: Int, image: Int, story: String, director: String){
        titlesList.add(title)
        ratingList.add(rating)
        imagaeList.add(image)
        storyList.add(story)
        directorList.add(director)
    }

    private fun postToList(){
            addToList("Suzume no Tojimari", 4, R.drawable.suzume_no_tojimari, "Pintu Bencana terbuka di seantero Jepang, membawa ketidakberuntungan. Suzume yang berusia 17 tahun hidup dalam kota yang tenang di wilayah Kyushu di Jepang,\" begitu awal sinopsis ini. \n" +
                    "\n" + "Dilanjutkan, \"Cerita dimulai saat ia bertemu dengan seorang pria muda dalam perjalanan untuk menemukan semua pintunya. Ia mengikutinya, dan menemukan sebuah pintu tua dalam bangunan terbengkalai di gunung.", "Makoto Shinkai")
            addToList("Jujutsu Kaisen : Zero", 4, R.drawable.jujutsu_kaisen, "Jujutsu Kaisen Zero mengambil latar waktu sebelum peristiwa utama dalam Jujutsu Kaisen. Cerita ini fokus pada karakter utama, Yuta Okkotsu, yang memiliki kemampuan penglihatan roh dan menjadi terlibat dengan dunia kutukan setelah kejadian tragis yang melibatkan teman sekelasnya. \n" +
                    "\n" +
                    "Yuta berusaha mengendalikan kekuatannya yang mengerikan, tetapi kehidupannya menjadi semakin rumit ketika dia bertemu dengan Satoru Gojo, seorang pengajar di Tokyo Metropolitan Jujutsu Technical High School. Gojo memperkenalkan Yuta pada dunia jujutsu dan mengajaknya untuk bergabung dengan sekolah khusus ini yang melatih siswa untuk melawan makhluk kutukan" , "Gege Akutami")
            addToList("I Want to Eat Your Pancreas", 2, R.drawable.kimi_no_suizo_wo_tabetai, "Film ini menceritakan kisah seorang siswa SMA yang tidak memiliki banyak teman dan cenderung menjalani kehidupan yang soliter. Suatu hari, ia secara tak sengaja menemukan buku harian seorang teman sekelas yang bernama Sakura Yamauchi. Untuk kejutannya, buku harian tersebut berjudul Hidup Dengan Kematian.\n" +
                    "\n" +
                    "Ternyata, Sakura mengidap penyakit parah yang tak bisa disembuhkan, yaitu kanker pankreas. Meskipun menyadari bahwa hidupnya akan singkat, Sakura memiliki kepribadian yang ceria dan optimis. Meskipun awalnya terkejut dan enggan, teman sekelasnya kemudian terlibat lebih dalam dalam kehidupan Sakura.", " Shô Tsukikawa")
            addToList("Weathering With You", 3, R.drawable.weathering_with_you, "Film ini mengisahkan tentang seorang pemuda bernama Hodaka Morishima yang pindah dari rumahnya di pulau terpencil ke kota Tokyo yang besar dan sibuk. Hodaka menghadapi berbagai kesulitan dalam menyesuaikan diri dengan kehidupan kota besar, dan dalam perjalanan tersebut, dia bertemu dengan seorang gadis misterius bernama Hina Amano.\n" +
                    "\n" +
                    "Ternyata, Hina memiliki kemampuan istimewa untuk mengendalikan cuaca. Dia dapat membuat cerah hari-hari hujan dan memberikan cahaya matahari ketika diperlukan. Hodaka dan Hina membentuk hubungan yang erat, dan Hodaka memutuskan untuk membantu Hina menggunakan kekuatannya untuk membantu orang lain.", "Makoto Shinkai")
            addToList("A Silent Voice The Movie", 5, R.drawable.koe_no_katachi, "Film ini berkisah tentang seorang siswa sekolah menengah bernama Shoya Ishida yang awalnya menjadi pengganggu terhadap seorang siswa tunarungu bernama Shoko Nishimiya. Shoko adalah siswa pindahan yang berusaha untuk berintegrasi ke dalam kelas, tetapi karena ketidakpahaman dan intoleransi teman-temannya, dia sering menjadi sasaran pelecehan.\n" +
                    "\n" +
                    "Shoya, yang menjadi pemimpin pelecehan terhadap Shoko, tiba-tiba menemukan dirinya menjadi korban bullying setelah dinilai oleh teman-temannya. Akibat perubahan ini, Shoya tumbuh menjadi remaja yang terasing dan depresi. ", "Maoko Yamada")
            addToList("Josee, the Fish and Tiger", 1, R.drawable.josee_the_fish_and_tiger, "Josee, fish and the tiger adalah film animasi Jepang yang dirilis pada tahun 2020. Film ini adalah adaptasi dari novel dengan judul yang sama karya Seiko Tanabe. Ceritanya berkisah tentang seorang pemuda bernama Tsuneo Suzukawa yang bekerja paruh waktu di sebuah perpustakaan. Tsuneo bertemu dengan seorang wanita muda yang bernama Josee, seorang penyandang disabilitas yang memiliki mimpi dan imajinasi yang luar biasa.\n" +
                    "\n" +
                    "Josee, yang terbatas dalam mobilitasnya, sering ditemani oleh seekor harimau mainan. Keduanya membentuk ikatan yang khusus, dan cerita berkembang saat Tsuneo membantu Josee mengalami dunia di luar batasan yang dihadapinya. Selama perjalanan ini, keduanya mengejar impian masing-masing dan belajar lebih banyak tentang diri mereka sendiri.", "Seiko Tanabe")
    }

}