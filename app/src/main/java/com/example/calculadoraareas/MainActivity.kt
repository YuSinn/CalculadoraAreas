package com.example.calculadoraareas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import java.util.Locale

import kotlin.math.pow
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    val buttonIds = listOf(R.id.btnTriangulo, R.id.btnCuadrado, R.id.btnCirculo, R.id.btnOctagono,
        R.id.btnHexagono, R.id.btnPentagono)
    var defaultColor: Int = 0
    var clickedColor: Int = 0
    lateinit var textViewOpcion:TextView
    lateinit var textViewRadioLado:TextView
    lateinit var textViewResultado:TextView
    lateinit var radioGroupTriangulo:RadioGroup
    lateinit var radioButtonLado: RadioButton
    lateinit var radioButtonAltura: RadioButton
    var numeroParaArea = ""
    var numeroFinal = 0
    var figuraSeleccionada = ""
    var numeroAltura = 0
    var alturaParaArea=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.titulo)
        defaultColor =   ContextCompat.getColor(this, R.color.figuras)
        clickedColor =   ContextCompat.getColor(this, R.color.white)
        textViewOpcion = findViewById(R.id.textViewOpcion)
        textViewRadioLado = findViewById(R.id.textViewLadoRadio)
        textViewResultado = findViewById(R.id.textViewResultado)
        radioGroupTriangulo = findViewById(R.id.radioGroupTriangulo)
        radioButtonLado = findViewById(R.id.radioButtonLado)
        radioButtonAltura = findViewById(R.id.radioButtonAltura)



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

                if(buttonId == R.id.btnCirculo){
                    initTextView()
                    textViewOpcion.text = "Opción: Circulo"
                    textViewRadioLado.text = "Radio: "
                    figuraSeleccionada="circulo"
                    radioGroupTriangulo.setVisibility(View.INVISIBLE)
                    }else {
                    initTextView()
                    textViewOpcion.text = "Opción: " + button.contentDescription?.toString()
                    figuraSeleccionada =
                        button.contentDescription.toString().lowercase(Locale.getDefault())
                    if(figuraSeleccionada.equals("triangulo")) radioGroupTriangulo.setVisibility(View.VISIBLE)
                    else radioGroupTriangulo.setVisibility(View.INVISIBLE)
                }
            }
        }




    }
    fun initTextView(){
        textViewRadioLado.text = "Lado: "
        textViewResultado.text = "Resultado: "
        numeroFinal = 0
        numeroParaArea = ""
        alturaParaArea=""
    }
    fun onBorrar(view:View){
        textViewOpcion.text = "Opción: "
        textViewRadioLado.text = "Lado: "
        textViewResultado.text = "Resultado: "
        numeroFinal=0
        numeroParaArea=""
        numeroAltura = 0
        alturaParaArea=""
        radioGroupTriangulo.setVisibility(View.INVISIBLE)
        resetButtons()
    }
    fun agregarNumero(view: View) {

        val botonPresionado = view as ImageButton
        val numero = botonPresionado.contentDescription?.toString() ?: ""

        if(radioButtonLado.isChecked) {
            numeroParaArea += numero
            // Obtener el texto actual del TextView
            val textoActual = textViewRadioLado.text.toString()

            if (textoActual.length < 11) {
                // Concatenar el número al texto actual
                textViewRadioLado.text = "$textoActual$numero"
                numeroFinal = numeroParaArea.toInt()
            }
        }else{
            alturaParaArea += numero
            // Obtener el texto actual del TextView
            val textoActual = textViewRadioLado.text.toString()

            if (textoActual.length < 11) {
                // Concatenar el número al texto actual
                textViewRadioLado.text = "$textoActual$numero"
                numeroAltura = alturaParaArea.toInt()
            }
        }


    }
    fun onNumero(view: View) {
        agregarNumero(view)
    }
    fun round(numero: Double, decimales: Int): Double {
        val factor = 10.0.pow(decimales.toDouble())
        return kotlin.math.round(numero * factor) / factor
    }

    fun onAltura(view: View){
        textViewRadioLado.text = "Altura: "
    }
    fun onLado(view: View){
        textViewRadioLado.text = "Lado: "
    }
    fun onCalcular (view: View){
        var resultado :Double
        when (figuraSeleccionada.lowercase(Locale.getDefault())) {
            "triangulo" -> {
                // Fórmula para el área de un triángulo
                // A = (base * altura) / 2
                resultado = ((numeroFinal*numeroAltura)/2).toDouble()
                radioButtonLado.isChecked = true

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