package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val buttonLogin = findViewById<Button>(R.id.button_login)

        buttonLogin.setOnClickListener {
            val intent = Intent(baseContext, MainActivityLogin::class.java)

            startActivity(intent)
        }

        val buttonRegister = findViewById<Button>(R.id.button_register)

        buttonRegister.setOnClickListener {

            val intent = Intent(baseContext, MainActivityRegister::class.java)

            startActivity(intent)


        }

    }

}