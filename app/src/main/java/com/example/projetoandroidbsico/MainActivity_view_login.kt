package com.example.projetoandroidbsico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivityViewLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_login)

        val login = intent.getStringExtra("login")
        val password = intent.getStringExtra("password")

        val textViewLogin = findViewById<TextView>(R.id.textLogin)
        val textViewPassword = findViewById<TextView>(R.id.textPassword)

        textViewLogin.text = login
        textViewPassword.text = password
    }
}
