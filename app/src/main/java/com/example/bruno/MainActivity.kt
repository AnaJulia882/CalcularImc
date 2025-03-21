package com.example.bruno

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lblResultado = findViewById<TextView>(R.id.lblResultado)
        val btnCalcularIMC = findViewById<Button>(R.id.btnCalcular)
        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)

        /*Método para criar ação dentro do botão*/
        btnCalcularIMC.setOnClickListener {
            val peso = edtPeso.text.toString().toDoubleOrNull()
            val altura = edtAltura.text.toString().toDoubleOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)
                lblResultado.text = "IMC: %.2f".format(imc)
            } else {
                lblResultado.text = "Apresente valores válidos"
            }
        }
    }
}
