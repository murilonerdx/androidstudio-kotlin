package com.example.listviewedit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tarefas = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tarefas)
        lstTarefas.adapter = adapter

        fab.setOnClickListener(){
            adicionarTarefa()
        }
        lstTarefas.setOnItemClickListener(){parent, view, position, id ->
            var tarefa = parent.adapter.getItem(position).toString()
            atualizarTarefa(tarefa, position)
        }


    }

    fun adicionarTarefa(){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Nova tarefa")
        val entrada = EditText(this)
        builder.setView(entrada)
        builder.setPositiveButton("ADICIONAR"){
            dialog, wich ->
            tarefas.add(entrada.text.toString())
            adapter?.notifyDataSetChanged()
        }
        builder.setNegativeButton("CANCELAR", null)
        builder.create().show()
    }

    fun atualizarTarefa(tarefa: String, posicao:Int){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Atualizar Tarefa")
        val entrada = EditText(this)
        entrada.setText(tarefa, TextView.BufferType.EDITABLE)
        builder.setView(entrada)
        builder.setPositiveButton("OK"){
            dialog, wich ->
            tarefas[posicao] = entrada.text.toString()
            adapter?.notifyDataSetChanged()

        }
        builder.setNegativeButton("CANCELAR", null)
        builder.setNeutralButton("Excluir"){dialog, which ->  
            tarefas.removeAt(posicao)
            adapter?.notifyDataSetChanged()
        }
        builder.create().show()
    }
}