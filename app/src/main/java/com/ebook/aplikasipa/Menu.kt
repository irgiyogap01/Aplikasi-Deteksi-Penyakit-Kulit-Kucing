package com.ebook.aplikasipa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnDeteksi: Button = findViewById(R.id.deteksi)
        val btnTentang: Button = findViewById(R.id.tentang)


        btnDeteksi.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnTentang.setOnClickListener {
            val intent = Intent(this, Tentang::class.java)
            startActivity(intent)
        }
    }
}