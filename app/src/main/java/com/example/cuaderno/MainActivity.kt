package com.example.cuaderno

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val spinner = findViewById<android.widget.Spinner>(R.id.grosorH)
        val spinner2 = findViewById<android.widget.Spinner>(R.id.grosorV)
        val spinner3 = findViewById<android.widget.Spinner>(R.id.colorH)
        val spinner4 = findViewById<android.widget.Spinner>(R.id.colorV)

        val lista = arrayOf("sumar", "restar", "multiplicar")
        val adaptador1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)

        spinner.adapter = adaptador1

    }
}