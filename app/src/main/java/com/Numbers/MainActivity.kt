package com.Numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    var puntos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GeneradorNumeroRandom()
    }

    fun btn1(view: View) {
        RevisarRespuesta(btnizquierdo = true)
    }

    fun btn2(view: View) {
        RevisarRespuesta(false)
    }

    fun RevisarRespuesta(btnizquierdo: Boolean){
        val btn1izq = findViewById<Button>(R.id.btn1izq)
        val btn2der = findViewById<Button>(R.id.btn2der)

        val convertirbtn1 = btn1izq.text.toString().toInt()
        val convertirbtn2 = btn2der.text.toString().toInt()

        if (btnizquierdo && convertirbtn1 > convertirbtn2 || !btnizquierdo && convertirbtn1 < convertirbtn2){
            //Ganar puntos
            puntos++
        }
        else {
            //perder puntos
            puntos--
        }
        findViewById<TextView>(R.id.puntos).text = "Puntos: $puntos"
        GeneradorNumeroRandom()
    }

    fun GeneradorNumeroRandom (){
        val btn1izq = findViewById<Button>(R.id.btn1izq)
        val btn2der = findViewById<Button>(R.id.btn2der)

        var numrandom = Random()
        var btnNum1 = numrandom.nextInt(10)
        btn1izq.text = "$btnNum1"

        var btnNum2 = numrandom.nextInt(10)
        btn2der.text = "$btnNum2"

        if (btnNum1 == btnNum2){
            GeneradorNumeroRandom()
        }
    }
}