package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivityViewRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_register)

        val username = intent.getStringExtra("username")
        val cpf = intent.getStringExtra("cpf")

        val textViewUsername = findViewById<TextView>(R.id.textUsername)
        val textViewCpf = findViewById<TextView>(R.id.textCpf)

        textViewUsername.text = username
        textViewCpf.text = cpf

    }
}


