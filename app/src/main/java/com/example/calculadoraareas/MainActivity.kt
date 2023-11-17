package com.example.calculadoraareas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.titulo)
        Glide.with(this).asGif().load(R.drawable.titulo).into(imageView)

    }
}