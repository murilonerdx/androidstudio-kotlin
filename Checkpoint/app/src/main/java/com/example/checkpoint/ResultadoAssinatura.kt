package com.example.checkpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_assinatura.*

class ResultadoAssinatura : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_assinatura)
        txtResultado.text = intent.getStringExtra("mensagem")
    }
}