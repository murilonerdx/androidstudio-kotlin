package com.example.checkpoint

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnIntegrantes = findViewById<Button>(R.id.btnIntegrantes)
        var btnCalculadora = findViewById<Button>(R.id.btnCalculadora)
        var btnContaTelefonica = findViewById<Button>(R.id.btnContaTelefonica)

        if (btnIntegrantes.isEnabled) {
            btnIntegrantes.setOnClickListener { view: View ->
                caixaDialogoIntegrantes()
            }
        }

        if (btnCalculadora.isEnabled) {
            btnCalculadora.setOnClickListener { view: View ->
                val intent = Intent(this, ActivityCalculadora::class.java)
                startActivity(intent)
            }
        }

        if (btnContaTelefonica.isEnabled) {
            btnContaTelefonica.setOnClickListener { view: View ->
                val intent = Intent(this, ActivityContaTelefone::class.java)
                startActivity(intent)
            }

        }

    }

    fun caixaDialogoIntegrantes() {
        val builder = AlertDialog.Builder(this);
        builder.setTitle("Desenvolvido por")
        builder.setMessage(
            "Murilo Pereira Silva - RM84319\n" +
                    "Gustavo Dalla - RM85743"
        )
        //builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(
                applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT
            ).show()
        }

        builder.show()
    }

}