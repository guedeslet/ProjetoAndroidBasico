package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class MainActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val editTextLogin = findViewById<EditText>(R.id.editText_login)
        val editTextPassword = findViewById<EditText>(R.id.editText_password)

        val buttonContinue = findViewById<Button>(R.id.button_continue)
        buttonContinue.setOnClickListener {
            val intent = Intent(baseContext, MainActivityViewLogin::class.java)
            intent.putExtra("login", editTextLogin.text.toString())
            intent.putExtra("password", editTextPassword.text.toString())
            startActivity(intent)
        }

        val buttonCancel = findViewById<Button>(R.id.button_cancel)

        buttonCancel.setOnClickListener{
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}


