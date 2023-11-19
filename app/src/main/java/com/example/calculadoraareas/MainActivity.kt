package com.example.calculadoraareas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

import kotlin.math.pow
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    val buttonIds = listOf(R.id.btnTriangulo, R.id.btnCuadrado, R.id.btnCirculo, R.id.btnOctagono,
        R.id.btnHexagono, R.id.btnPentagono)
    val defaultColor: Int by lazy { ContextCompat.getColor(this, R.color.figuras) }
    val clickedColor: Int by lazy { ContextCompat.getColor(this, R.color.white)}
    lateinit var textViewOpcion:TextView
    lateinit var textViewRadioLado:TextView
    lateinit var textViewResultado:TextView
    var numeroParaArea = ""
    var numeroFinal = 0
    var figuraSeleccionada = ""
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


        for (buttonId in buttonIds) {
            val button = findViewById<ImageButton>(buttonId)

            button.setOnClickListener {
                resetButtons()
                button.setColorFilter(clickedColor)

                if(buttonId == R.id.btnTriangulo){
                    initTextView()
                    textViewOpcion.text = "Opción: Triangulo"
                    figuraSeleccionada="triangulo"
                }else if(buttonId == R.id.btnCuadrado){
                    initTextView()
                    textViewOpcion.text = "Opción: Cuadrado"
                    figuraSeleccionada="cuadrado"
                }
                else if(buttonId == R.id.btnCirculo){
                    initTextView()
                    textViewOpcion.text = "Opción: Circulo"
                    textViewRadioLado.text = "Radio: "
                    figuraSeleccionada="circulo"
                }
                else if(buttonId == R.id.btnOctagono){
                    initTextView()
                    textViewOpcion.text = "Opción: Octagono"
                    figuraSeleccionada="octagono"
                }
                else if(buttonId == R.id.btnHexagono){
                    initTextView()
                    textViewOpcion.text = "Opción: Hexagono"
                    figuraSeleccionada="hexagono"
                }
                else if(buttonId == R.id.btnPentagono){
                    initTextView()
                    textViewOpcion.text = "Opción: Pentagono"
                    figuraSeleccionada="pentagono"
                }
            }
        }

    }
    fun initTextView(){
        textViewOpcion = findViewById(R.id.textViewOpcion)
        textViewRadioLado = findViewById(R.id.textViewLadoRadio)
        textViewResultado = findViewById(R.id.textViewResultado)
        textViewRadioLado.text = "Lado: "
        textViewResultado.text = "Resultado: "
        numeroFinal = 0
        numeroParaArea = ""
    }
    fun onBorrar(view:View){
        textViewOpcion = findViewById(R.id.textViewOpcion)
        textViewRadioLado = findViewById(R.id.textViewLadoRadio)
        textViewResultado = findViewById(R.id.textViewResultado)
        textViewOpcion.text = "Opción: "
        textViewRadioLado.text = "Lado: "
        textViewResultado.text = "Resultado: "
        numeroFinal=0
        numeroParaArea=""
    }
    fun agregarNumero(view: View) {
        textViewRadioLado = findViewById(R.id.textViewLadoRadio)
        val botonPresionado = view as ImageButton
        val numero = botonPresionado.contentDescription?.toString() ?: ""
        numeroParaArea +=numero
        // Obtener el texto actual del TextView
        val textoActual = textViewRadioLado.text.toString()

        if(textoActual.length < 11) {
            // Concatenar el número al texto actual
            textViewRadioLado.text = "$textoActual$numero"
            numeroFinal = numeroParaArea.toInt()
        }


    }
    fun onCero(view: View){
        agregarNumero(view)
    }
    fun onUno(view: View){
        agregarNumero(view)
    }
    fun onDos(view: View){
        agregarNumero(view)
    }
    fun onTres(view: View){
        agregarNumero(view)
    }
    fun onCuatro(view: View){
        agregarNumero(view)
    }
    fun onCinco(view: View){
        agregarNumero(view)
    }
    fun onSeis(view: View){
        agregarNumero(view)
    }
    fun onSiete(view: View){
        agregarNumero(view)
    }fun onOcho(view: View){
        agregarNumero(view)
    }
    fun onNueve(view: View){
        agregarNumero(view)
    }
    fun round(numero: Double, decimales: Int): Double {
        val factor = 10.0.pow(decimales.toDouble())
        return kotlin.math.round(numero * factor) / factor
    }
    fun onCalcular (view: View){
        textViewResultado = findViewById(R.id.textViewResultado)
        var resultado :Double
        when (figuraSeleccionada.toLowerCase()) {
            "triangulo" -> {
                // Fórmula para el área de un triángulo
                // A = (base * altura) / 2
                resultado = (kotlin.math.sqrt(3.0) / 4) * numeroFinal.toDouble().pow(2)
            }
            "cuadrado" -> {
                // Fórmula para el área de un cuadrado
                // A = lado^2
                 // Reemplaza con tu valor real
                resultado = numeroFinal.toDouble().pow(2)
            }
            "circulo" -> {
                // Fórmula para el área de un círculo
                // A = π * radio^2
                resultado = Math.PI * numeroFinal.toDouble().pow(2)
            }
            "octagono" -> {
                // A = 2 * (1 + sqrt(2)) * lado^2
                resultado = 2 * (1 + kotlin.math.sqrt(2.0)) * numeroFinal.toDouble().pow(2)
            }
            "hexagono" -> {
                // A = (3 * sqrt(3) / 2) * lado^2
                resultado = (3 * kotlin.math.sqrt(3.0) / 2) * numeroFinal.toDouble().pow(2)
            }
            "pentagono" -> {
                // A = (1/4) * sqrt(5 * (5 + 2 * sqrt(5))) * lado^2
                resultado = (1.0 / 4) * kotlin.math.sqrt(5 * (5 + 2 * kotlin.math.sqrt(5.0))) * numeroFinal.toDouble().pow(2)
            }
            // Agrega más casos para otras figuras si es necesario
            else -> {
                // Valor por defecto o manejo de errores
                resultado = 0.0
            }
        }
        resultado=round(resultado,3)
        textViewResultado.text = textViewResultado.text.toString() + resultado.toString()
    }
    // Función para restablecer todos los botones al color predeterminado
    private fun resetButtons() {
        for (buttonId in buttonIds) {
            val button = findViewById<ImageButton>(buttonId)
            button.setColorFilter(defaultColor)
        }
    }
}