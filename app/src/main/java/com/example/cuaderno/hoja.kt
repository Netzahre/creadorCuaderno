package com.example.cuaderno

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class hoja : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bundle = intent.extras
        val grosorH = bundle?.getFloat("grosorH") ?: 4f
        val grosorV = bundle?.getFloat("grosorV") ?: 4f
        val colorH = (bundle?.getString("colorH")?.split(",") ?: listOf("0", "255", "0"))
        val colorV = (bundle?.getString("colorV")?.split(",") ?: listOf("255", "0", "0"))

        val cuaderno = findViewById<FrameLayout>(R.id.fondo)
        val fondo = Lienzo(this, colorH, colorV, grosorH, grosorV);
        cuaderno.addView(fondo, 0)
    }

    inner class Lienzo(context: Context, val colorH : List<String>, val colorV : List<String>, val grosorH : Float, val grosorV : Float) : View(context) {
        override fun onDraw(canvas: Canvas) {
            //Horizontal
            canvas.drawRGB(244, 240, 232)
            val ancho = getWidth()
            val pincel1 = Paint()

            //Dato "gracioso", no puedes pasar el alfa en crudo y el resto por variable. Explota.
            pincel1.setARGB(colorH[0].toInt(), colorH[1].toInt(), colorH[2].toInt(), colorH[3].toInt())

            pincel1.setStrokeWidth(grosorH)
            for (posicion in 2..500)
                canvas.drawLine(
                    0f,
                    (posicion * 80).toFloat(),
                    ancho.toFloat(),
                    (posicion * 80).toFloat(),
                    pincel1
                )

            //Vertical
            val alto = getHeight()
            val pincel2 = Paint()
            pincel2.setARGB(colorV[0].toInt(), colorV[1].toInt(), colorV[2].toInt(), colorV[3].toInt())
            pincel2.setStrokeWidth(grosorV) 
            for (posicion in 7..8)
                canvas.drawLine(
                    (posicion * 20).toFloat(),
                    0f,
                    (posicion * 20).toFloat(),
                    alto.toFloat(),
                    pincel2
                )
        }
    }

}

