package com.example.calculadoraareas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.titulo)
        val imageButtonCalcular : ImageButton = findViewById(R.id.btnCalcular)
        val imageButtonBorrar : ImageButton = findViewById(R.id.btnBorrar)
        val imageButtonCero : ImageButton = findViewById(R.id.btnCero)
        val imageButtonUno : ImageButton = findViewById(R.id.btnUno)
        val imageButtonDos : ImageButton = findViewById(R.id.btnDos)
        val imageButtonTres : ImageButton = findViewById(R.id.btnTres)
        val imageButtonCuatro : ImageButton = findViewById(R.id.btnCuatro)
        val imageButtonCinco : ImageButton = findViewById(R.id.btnCinco)
        val imageButtonSeis : ImageButton = findViewById(R.id.btnSeis)
        val imageButtonSiete : ImageButton = findViewById(R.id.btnSiete)
        val imageButtonOcho : ImageButton = findViewById(R.id.btnOcho)
        val imageButtonNueve : ImageButton = findViewById(R.id.btnNueve)
        Glide.with(this).asGif().load(R.drawable.titulo7).into(imageView)
        Glide.with(this).asGif().load(R.drawable.calcular3).into(imageButtonCalcular)
        Glide.with(this).asGif().load(R.drawable.borrar2).into(imageButtonBorrar)
        Glide.with(this).asGif().load(R.drawable.cero3).into(imageButtonCero)
        Glide.with(this).asGif().load(R.drawable.uno2).into(imageButtonUno)
        Glide.with(this).asGif().load(R.drawable.dos2).into(imageButtonDos)
        Glide.with(this).asGif().load(R.drawable.tres2).into(imageButtonTres)
        Glide.with(this).asGif().load(R.drawable.cuatro2).into(imageButtonCuatro)
        Glide.with(this).asGif().load(R.drawable.cinco2).into(imageButtonCinco)
        Glide.with(this).asGif().load(R.drawable.seis2).into(imageButtonSeis)
        Glide.with(this).asGif().load(R.drawable.siete2).into(imageButtonSiete)
        Glide.with(this).asGif().load(R.drawable.ocho2).into(imageButtonOcho)
        Glide.with(this).asGif().load(R.drawable.nueve2).into(imageButtonNueve)


    }
}