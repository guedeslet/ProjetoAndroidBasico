package com.example.projetoandroidbsico

import android.widget.TextView

class Validator {
    companion object {
        fun validatorEmail(email: String): Boolean =
            email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        fun validatorRegister(registro: String): Boolean = registro.isNotEmpty()
        fun validatorCpf(cpf: String): Boolean = cpf.isNotEmpty()
        fun validatorPassword(password: String): Boolean = password.isNotEmpty()





    }


}


fun TextView.validateEmail() =
    this.text.toString().isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()

fun TextView.showMessageError() {
    this.error = " Campo de email obrigatório"
}