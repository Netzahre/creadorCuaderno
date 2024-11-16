package com.example.cuaderno

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner = findViewById<android.widget.Spinner>(R.id.grosorH)
        val spinner2 = findViewById<android.widget.Spinner>(R.id.grosorV)
        val spinner3 = findViewById<android.widget.Spinner>(R.id.colorH)
        val spinner4 = findViewById<android.widget.Spinner>(R.id.colorV)
        val crearCuaderno = findViewById<Button>(R.id.crear)

        val lista = arrayOf("normal", "fino", "grueso")
        val adaptador1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)
        spinner.adapter = adaptador1

        val lista2 = arrayOf("normal", "fino", "grueso")
        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista2)
        spinner2.adapter = adaptador2

        val lista3 = arrayOf("clasico", "floral", "fresco")
        val adaptador3 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista3)
        spinner3.adapter = adaptador3

        val lista4 = arrayOf("clasico", "floral", "fresco")
        val adaptador4 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista4)
        spinner4.adapter = adaptador4

        val cuaderno = Intent(this, hoja::class.java)

        crearCuaderno.setOnClickListener {
            cuaderno.putExtra("grosorH", calcularGrosor(spinner))
            cuaderno.putExtra("grosorV", calcularGrosor(spinner2))
            cuaderno.putExtra("colorH", stringRGBHorizontal(spinner3.selectedItem.toString()))
            cuaderno.putExtra("colorV", stringRGBVertical(spinner4.selectedItem.toString()))

            startActivity(cuaderno)
        }
    }

    fun calcularGrosor(spinner: Spinner): Float {
        return when (spinner.selectedItem.toString()) {
            "normal" -> 4f
            "fino" -> 2f
            "grueso" -> 8f
            else -> 4f
        }
    }

    fun stringRGBHorizontal(color: String): String {
        return when (color) {
            "clasico" -> "255,23,26,33"
            "floral" -> "255,249,92,154"
            "fresco" -> "255,33,145,251"
            else -> "255,255,87,159"
        }
    }

    fun stringRGBVertical(color: String): String {
        return when (color) {
            "clasico" -> "255,162,44,41"
            "floral" -> "255,108,174,117"
            "fresco" -> "255,141,106,159"
            else -> "255,255,87,159"
        }
    }
}