package com.example.projetoandroidbsico

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main_list.*
import org.jetbrains.anko.*

class MainActivityList : AppCompatActivity() {

    var books = ArrayList<User>()
    lateinit var editText_title: EditText
    lateinit var editText_subtitle: EditText


    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)
""

        val username = intent.getStringExtra("username")
        actionBar.title = ("Bem vindo, ${username}")


        recyclerView = findViewById<RecyclerView>(R.id.recycleView_Layout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(books, this)
        recyclerView.adapter = adapter


        button_fab.setOnClickListener {

            alert {
                title = "Inserir Livro"

                customView {
                    linearLayout {

                        this.orientation = LinearLayout.VERTICAL
                        editText_title = editText {
                            hint = "Título do Livro"

                        }.lparams(width = matchParent, height = wrapContent) {
                            bottomMargin = dip(10)

                        }
                        editText_subtitle = editText {
                            hint = " Nome do autor do livro"
                        }.lparams(width = matchParent, height = wrapContent) {
                            bottomMargin = dip(10)
                        }

                        padding = dip(10)


                    }
                }

                positiveButton("Cadastrar") {
                    adapter.addUser(
                        User(
                            editText_title.text.toString(),
                            editText_subtitle.text.toString()
                        )
                    )
                }

            }.show()

        }


    }


}








