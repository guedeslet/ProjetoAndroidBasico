package com.example.projetoandroidbsico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main_list.*

class MainActivityList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)


        recyclerView = findViewById<RecyclerView>(R.id.recycleView_Layout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(mutableListOf<User>())
        recyclerView.adapter = adapter


        button_fab.setOnClickListener {

            val user = User("Título do livro")
            adapter.addUser(user)

        }


        }


    }





