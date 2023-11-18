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

// Lista de ImageButton y sus correspondientes recursos
        val imageButtons: List<Pair<ImageButton, Int>> = listOf(
            Pair(findViewById(R.id.btnCalcular), R.drawable.calcular3),
            Pair(findViewById(R.id.btnBorrar), R.drawable.borrar2),
            Pair(findViewById(R.id.btnCero), R.drawable.cero3),
            Pair(findViewById(R.id.btnUno), R.drawable.uno2),
            Pair(findViewById(R.id.btnDos), R.drawable.dos2),
            Pair(findViewById(R.id.btnTres), R.drawable.tres2),
            Pair(findViewById(R.id.btnCuatro), R.drawable.cuatro2),
            Pair(findViewById(R.id.btnCinco), R.drawable.cinco2),
            Pair(findViewById(R.id.btnSeis), R.drawable.seis2),
            Pair(findViewById(R.id.btnSiete), R.drawable.siete2),
            Pair(findViewById(R.id.btnOcho), R.drawable.ocho2),
            Pair(findViewById(R.id.btnNueve), R.drawable.nueve2)
        )

// Cargar la imagen del título
        Glide.with(this).asGif().load(R.drawable.titulo7).into(imageView)

// Cargar imágenes en los ImageButtons usando un bucle
        for ((button, resource) in imageButtons) {
            Glide.with(this).asGif().load(resource).into(button)
        }


    }
}