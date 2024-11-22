package com.example.apptareas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(private val tasks:List<String>, private val onItemDone: (Int) -> Unit):RecyclerView.Adapter<TaskViewHolder>() {
    //Crea el ViewHolder,
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        //carga los xml para trabajar con ellos 'Layaoutflater'
        val layoutInflater = LayoutInflater.from(parent.context)
        // retornamos el ViewHolder
        return TaskViewHolder(layoutInflater.inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount() = tasks.size

    //Esta funcion al hacer scroll, va introduciendo las posiciones nuevas
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position], onItemDone)
    }


}