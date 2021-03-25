package com.example.checkpoint

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadora.*


class ActivityCalculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        btCalcular.setOnClickListener{
            var v1 = txtValor1.text.toString().toDouble()
            var v2 = txtValor2.text.toString().toDouble()
            var selecionado = when (radioGroup.checkedRadioButtonId){
                R.id.rbSoma -> somar(v1, v2)
                R.id.rbSubtracao -> subtrair(v1, v2)
                R.id.rbMultiplicacao -> multiplicar(v1, v2)
                R.id.rbDivisao -> dividir(v1, v2)
                else -> 0
            }
            Toast.makeText(this, "Resultado: ${selecionado}", Toast.LENGTH_SHORT).show()
        }
    }

    fun somar(valor1: Double, valor2: Double) : Double{
        return valor1 + valor2
    }

    fun subtrair(valor1: Double, valor2: Double) : Double{
        return valor1 - valor2
    }

    fun multiplicar(valor1: Double, valor2: Double) : Double{
        return valor1 * valor2
    }

    fun dividir(valor1: Double, valor2: Double) : Double{
        return valor1 / valor2
    }
}