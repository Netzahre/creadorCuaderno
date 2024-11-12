package com.example.cuaderno

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class hoja : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja)
        val fondo = Lienzo(this);
    }

    class Lienzo(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas) {
            canvas.drawRGB(255, 255, 0)
            val ancho = getWidth()
            val pincel1 = Paint()
            pincel1.setARGB(255, 255, 0, 0)
            canvas.drawLine(0f, 30f, ancho.toFloat(), 30f, pincel1)
            pincel1.setStrokeWidth(4f)
            canvas.drawLine(0f, 60f, ancho.toFloat(), 60f, pincel1)
            for (posicion in 0..10)
                canvas.drawLine(0f, (posicion* 30).toFloat(), ancho.toFloat(), (posicion * 30).toFloat(), pincel1)
        }
    }

}

