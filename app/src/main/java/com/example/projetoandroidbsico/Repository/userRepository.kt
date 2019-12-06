package com.example.projetoandroidbsico.Repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor


class userRepository private constructor(context: Context) {

    private var mDatabase = Database(context)

    companion object {
        fun getInstance(context: Context): userRepository {

            if (INSTANCE == null) {
                INSTANCE = userRepository(context)
            }
            return INSTANCE as userRepository

        }

        private var INSTANCE: userRepository? = null
    }

    fun insertUser(nome: String, cpf: String, email: String, senha: String) {

        val actiondb = mDatabase.writableDatabase
        val insertValues = ContentValues()
        insertValues.put("nome", nome)
        insertValues.put("cpf", cpf)
        insertValues.put("email", email)
        insertValues.put("senha", senha)
        actiondb.insert("users", null, insertValues)
    }
    fun catchUser(email : String, senha : String) : Boolean{
        val actiondb = mDatabase.readableDatabase
        val cursor : Cursor
        val columns = arrayOf("id","nome", "cpf", "email", "senha")
        val condition = "email = ? AND senha = ?"
        val params = arrayOf(email, senha)
        cursor = actiondb.query("users", columns, condition, params, null, null, null )


         return cursor.count > 0

    }


}
