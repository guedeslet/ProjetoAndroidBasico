package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.button_cancel
import kotlinx.android.synthetic.main.activity_login.button_continue
import kotlinx.android.synthetic.main.activity_register.*

class MainActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        button_continue.setOnClickListener {
            val intent = Intent(baseContext, MainActivityList::class.java)

            intent.putExtra("username",editText_login.text.toString() )

            startActivity(intent)
        }


        button_cancel.setOnClickListener{
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}


