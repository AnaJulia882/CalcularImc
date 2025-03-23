package com.example.calculaimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcularIMC = findViewById<Button>(R.id.btnCalcular)
        btnCalcularIMC.setOnClickListener {
            val lblResultado = findViewById<TextView>(R.id.lblResultado)

            val edtAltura = findViewById<EditText>(R.id.edtAltura)
            val edtPeso = findViewById<EditText>(R.id.edtPeso)

            val altura = edtAltura.text.toString().toDoubleOrNull()
            val peso = edtPeso.text.toString().toDoubleOrNull()

            if (altura != null && peso != null && altura > 0) {
                val imc = peso / (altura * altura)

                // Exibir o IMC e a classificação
                lblResultado.text = "IMC: %.2f".format(imc)

            } else {
                lblResultado.text = "Por favor, insira valores válidos."
            }
        }

        val btnClassificacao = findViewById<Button>(R.id.btnClassificação)
        btnClassificacao.setOnClickListener {
            setContentView(R.layout.activity_resultado)

            val btnVoltar = findViewById<Button>(R.id.btnVoltar)
            btnVoltar.setOnClickListener {
                setContentView(R.layout.activity_main)

                val btnClassificacao = findViewById<Button>(R.id.btnClassificação)
                btnClassificacao.setOnClickListener {
                    setContentView(R.layout.activity_main)
                }
            }
        }
    }
}
