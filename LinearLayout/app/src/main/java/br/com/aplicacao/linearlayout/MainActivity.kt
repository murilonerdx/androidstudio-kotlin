package br.com.aplicacao.linearlayout

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cliqueBotao(view: View){
        if(txtNome.text.trim().isEmpty()){
            Toast.makeText(this,"Informe um nome: ",Toast.LENGTH_LONG).show()
        }else{
            val msg = "Olá ${txtNome.text}!"
            exibirMensagem("Saudação", msg)
        }

    }

    fun exibirMensagem(titulo: String, mensagem: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
            .setMessage(mensagem)
            .setPositiveButton("OK", null)
        builder.create().show()
    }
}