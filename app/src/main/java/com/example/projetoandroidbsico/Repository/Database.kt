package com.example.projetoandroidbsico.Repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, databaseName, null, version) {


    // objetos estáticos sao criado com companion object, eles n mudam e podem ser chamados sem instanciar uma classe
    companion object {
        private val databaseName = "banco.db"
        private val version = 1
    }

    // Em SQLITE STRINGS SAO TEXT E INT'S SAO INTEGERS
    private val createTableUsers =
        "CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT, cpf TEXT, email TEXT, senha TEXT);"

    private val createTableBooks =
        "CREATE TABLE books(id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT, autor TEXT);"

    override fun onCreate(SQLITE: SQLiteDatabase?) {
        SQLITE?.execSQL(createTableUsers)
        SQLITE?.execSQL(createTableBooks)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}
