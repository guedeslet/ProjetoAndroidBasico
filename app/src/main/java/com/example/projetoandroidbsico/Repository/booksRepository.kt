package com.example.projetoandroidbsico.Repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.projetoandroidbsico.User
import java.lang.Exception


class booksRepository private constructor(context: Context) {
    private var mDatabase = Database(context)

    companion object {
        fun getInstance(context: Context): booksRepository {

            if (INSTANCE == null) {
                INSTANCE = booksRepository(context)
            }
            return INSTANCE as booksRepository

        }

        private var INSTANCE: booksRepository? = null
    }

    fun insertBook(nome: String, autor : String) {

        val actiondb = mDatabase.writableDatabase
        val insertValues = ContentValues()
        insertValues.put("nome", nome)
        insertValues.put("autor", autor)
        actiondb.insert("books", null, insertValues)
    }

    fun catchBook() : MutableList<User>{

        var listBooks = mutableListOf<User>()
        try {


            val actiondb = mDatabase.readableDatabase
            val cursor: Cursor
            cursor = actiondb.rawQuery("SELECT * FROM books", null)

            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val nameBook = cursor.getString(cursor.getColumnIndex("nome"))
                    val autorBook = cursor.getString(cursor.getColumnIndex("autor"))

                    listBooks.add(User(nameBook, autorBook))

                }
            }
            cursor.close()
        }catch (e: Exception){
            return listBooks
        }
        return listBooks
    }
}