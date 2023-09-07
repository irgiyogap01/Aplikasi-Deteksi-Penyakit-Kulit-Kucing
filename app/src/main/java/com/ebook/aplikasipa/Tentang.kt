package com.ebook.aplikasipa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Tentang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val tentang: TextView = findViewById(R.id.isiTentang)
        val cara: TextView = findViewById(R.id.isiCara)

        tentang.text = "Aplikasi safety cat ini merupakan aplikasi yang dapat mendeteksi penyakit kulit pada kucing. Ada empat penyakit yang" +
                "yang dapat dideteksi, yaitu jamur atau ringworm, jerawat kucing, scabies, dan tungau telinga. Aplikasi ini juga akan memberikan ciri-ciri dan cara" +
                "memberikan pertolongan pertama pada hasil penyakit yang dideteksi."

        cara.text = "Cara mendeteksi penyakit kulit pada kucing pada aplikasi ini adalah" +
                "\n1. Pada menu utama pilih menu deteksi" +
                "\n2. Pada halaman deteksi akan diberikan 2 cara mendeteksi penyakit, yaitu dengan menggunakan kamera dan gambar dari gallery" +
                "\n3. Jika menggunakan kamera, maka akan muncul tampilan kamera dan silahkan foto atau tangkap gambar penyakit kulit pada kucing yang akan dideteksi" +
                "\n4. Untuk gallery kita akan diarahkan ke halaman gallery hp kita dan pilih foto penyakit yang akan dideteksi" +
                "\n5. Setelah gambar yang akan dideteksi didapatkan, silahkan klik tombol Deteksi Penyakit. Maka akan diarahkan kehalaman hasil dateksi"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}