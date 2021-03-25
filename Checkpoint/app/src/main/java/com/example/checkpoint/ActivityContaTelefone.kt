package com.example.checkpoint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conta_telefone.*
import java.text.DecimalFormat

class ActivityContaTelefone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val decDecimal = DecimalFormat("0.00")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefone)

        btnCalcular.setOnClickListener {
            var assinatura = txtAssinatura.text.toString().toDouble()
            var chamadaLocal = txtMinutosLocal.text.toString().toDouble()*0.04
            var chamadaCelular = txtMinutosCelular.text.toString().toDouble()*0.20

//
//            var intentAssinatura = Intent(this, ResultadoAssinatura::class.java)
//            intentAssinatura.putExtra("assinatura", assinatura)
//            startActivity(intentAssinatura)
//////
//            var intentChamadaLocal = Intent(this, ResultadoAssinatura::class.java)
//            intentAssinatura.putExtra("Minutos chamada local", chamadaLocal)
//            startActivity(intentChamadaLocal)

            var mensagem = """Assinatura: ${assinatura}
                            |Minutos chamada Local: ${decDecimal.format(chamadaLocal)}
                            |Minutos chamada celular: ${decDecimal.format(chamadaCelular)}
                            |Total: ${decDecimal.format(chamadaLocal+ chamadaCelular + assinatura)}""".trimMargin("|")

            var intentGeral = Intent(this, ResultadoAssinatura::class.java)
            intentGeral.putExtra("mensagem", mensagem)
            startActivity(intentGeral)

            fun validaCampoVazio() : Boolean {
                var mensagem = ""
                if (txtAssinatura.text.trim().isEmpty() || txtMinutosCelular.text.trim().isEmpty() || txtMinutosLocal.text.trim().isEmpty()) {
                    mensagem = "Preencha TODOS os campos"
                }
                Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show()
                return false
            }
        }
    }
}
