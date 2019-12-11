package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetoandroidbsico.Repository.userRepository
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.button_cancel
import kotlinx.android.synthetic.main.activity_register.button_continue

class ActivityRegister : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        button_continue.setOnClickListener {




           // if (!editText_email.text.toString().validateEmail())

            if (editText_email.validateEmail()){
                editText_email.showMessageError()
            }



            if (!Validator.validatorCpf(editText_cpf.text.toString())) {
                editText_cpf.error = "Campo de CPF obrigatório"
            }

            if (!Validator.validatorPassword(editText_passwordRegister.text.toString())) {
                editText_passwordRegister.error = "Campo de senha obrigatório"
            }

            if (!Validator.validatorRegister(editText_register.text.toString())) {
                editText_register.error = "Campo obrigatório"
            }

            if (Validator.validatorRegister(editText_register.text.toString()) && Validator.validatorPassword(
                    editText_passwordRegister.text.toString()
                )
                && Validator.validatorCpf(editText_cpf.text.toString()) && Validator.validatorEmail(
                    editText_email.text.toString()
                )
            ) {

                val databaseInstance = userRepository.getInstance(this)
                databaseInstance.insertUser(
                    editText_register.text.toString(), editText_cpf.text.toString(),
                    editText_email.text.toString(), editText_passwordRegister.text.toString()
                )

                val intent = Intent(baseContext, ActivityList::class.java)

                startActivity(intent)



            }



            button_cancel.setOnClickListener {
                val intent = Intent(baseContext, MainActivity::class.java)
                startActivity(intent)

                finish()
            }

        }



    }


}

