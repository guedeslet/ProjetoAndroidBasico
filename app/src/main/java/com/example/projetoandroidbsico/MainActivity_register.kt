package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivityRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextUsername = findViewById<EditText>(R.id.editText_register)
        val editTextCpf = findViewById<EditText>(R.id.editText_cpf)


        val buttonContinue = findViewById<Button>(R.id.button_continue)
        buttonContinue.setOnClickListener {
            val intent = Intent(baseContext, MainActivityViewRegister::class.java)
            intent.putExtra("username", editTextUsername.text.toString())
            intent.putExtra("cpf", editTextCpf.text.toString())
            startActivity(intent)
        }


        val buttonCancel = findViewById<Button>(R.id.button_cancel)

        buttonCancel.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        }


    }


}

