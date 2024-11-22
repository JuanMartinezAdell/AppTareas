package com.example.apptareas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptareas.TaskApplication.Companion.prefs
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    lateinit var btnAddTask: Button
    //recoger el valor
    lateinit var etTask: EditText
    lateinit var rvTasks: RecyclerView

    lateinit var adapter:TaskAdapter

    //Listado
    var tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        initView()
        initListeners()
        initRecyclerView()
    }

    //Configura el RecyclerView para añadir el adapter, conectarlo y pasar las tareas
    private fun initRecyclerView() {
        tasks = prefs.getTasks()
        rvTasks.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter(tasks) {deleteTask(it)}
        rvTasks.adapter = adapter
    }

    private fun deleteTask(position:Int) {
        tasks.removeAt(position)
        adapter.notifyDataSetChanged()
        prefs.saveTasks(tasks)
    }

    private fun initListeners() {
        btnAddTask.setOnClickListener { addTask() }
    }

    //Funcion añadir tareas
    private fun addTask() {
        val taskToAdd:String = etTask.text.toString()
        //Cada vez que se añada una tarea coge el objeto listado y lo sustituye entero por el nuevo
        tasks.add(taskToAdd)
        adapter.notifyDataSetChanged()
        etTask.setText("")
        prefs.saveTasks(tasks)
    }

    private fun initView() {
        btnAddTask = findViewById(R.id.btnAddTask)
        etTask = findViewById(R.id.etTask)
        rvTasks = findViewById(R.id.rvTasks)
    }
}