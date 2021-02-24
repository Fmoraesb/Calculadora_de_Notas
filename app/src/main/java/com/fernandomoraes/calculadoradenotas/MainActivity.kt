package com.fernandomoraes.calculadoradenotas

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtNota1 = findViewById<TextView>(R.id.txtNota1)
        val txtNota2 = findViewById<TextView>(R.id.txtNota2)
        val txtFalta = findViewById<TextView>(R.id.txtFaltas)

        btCalcular.setOnClickListener {
            val nota1 = parseInt(txtNota1.text.toString())
            val nota2 = parseInt(txtNota2.text.toString())
            val media = (nota1 + nota2)/2
            val faltas = parseInt(txtFalta.text.toString())

            if ((media >= 6.0) && (faltas <= 10)) {
                txtResultado.setText("Aluno foi aprovado" + "\n"
                + "Nota Final: " + media + "\n"
                + "Faltas: " + faltas)
                txtResultado.setTextColor(Color.GREEN)
            }else {
                txtResultado.setText("Aluno foi reprovado" + "\n"
                        + "Nota Final: " + media + "\n"
                        + "Faltas: " + faltas)
                txtResultado.setTextColor(Color.RED)
            }
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(it.windowToken,0)
        }
    }
}