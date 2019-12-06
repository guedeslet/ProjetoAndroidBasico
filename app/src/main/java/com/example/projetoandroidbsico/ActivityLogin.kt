package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetoandroidbsico.Repository.userRepository
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.button_cancel
import kotlinx.android.synthetic.main.activity_login.button_continue
import org.jetbrains.anko.toast

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editText_loginEmail.setText("let@123.com")
        editText_password.setText("123")

        button_continue.setOnClickListener {



            if (!Validator.validatorEmail(editText_loginEmail.text.toString())) {
                editText_loginEmail.error = "Campo de email obrigatório"
            }

            if (!Validator.validatorPassword(editText_password.text.toString())) {
                editText_password.error = "Campo de senha obrigatório"
            }

            if(Validator.validatorPassword(editText_password.text.toString()) && Validator.validatorEmail(
                        editText_loginEmail.text.toString())){
                val mUserRepository =  userRepository.getInstance(this)


                if (mUserRepository.catchUser(editText_loginEmail.text.toString(), editText_password.text.toString())){
                    val intent = Intent(baseContext, ActivityList::class.java)
                    startActivity(intent)
                } else {
                    toast("Usuário não cadastrado")
                }

            }
        }



        button_cancel.setOnClickListener {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


