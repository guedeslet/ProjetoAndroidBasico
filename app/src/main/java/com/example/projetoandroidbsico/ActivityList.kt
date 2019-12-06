package com.example.projetoandroidbsico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.Repository.booksRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_list.*
import org.jetbrains.anko.*

class ActivityList : AppCompatActivity() {
    private lateinit var mBooksRepository: booksRepository

    var books = ArrayList<User>()
    lateinit var editText_title: EditText
    lateinit var editText_subtitle: EditText


    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)





        supportActionBar?.title = ("Bem vinda(o)")
        mBooksRepository = booksRepository.getInstance(this)



        recyclerView = recycleView_Layout
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(mBooksRepository.catchBook(), this)
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


                    if (editText_title.text.isEmpty()) {
                        editText_title.error = "Insira o título do livro"
                    }
                    if (editText_subtitle.text.isEmpty()) {
                        editText_subtitle.error = "Insira o nome do autor do livro"
                    }
                    if (editText_title.text.isNotEmpty() && editText_subtitle.text.isNotEmpty()) {

                        val mbooksRepository = booksRepository.getInstance(this@ActivityList)

                        mbooksRepository.insertBook(
                            editText_title.text.toString(),
                            editText_subtitle.text.toString()

                        )



                        updateList(mBooksRepository.catchBook())

                    }


                }


            }.show()


        }
        navigation.setOnNavigationItemSelectedListener(object  : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId){
                    R.id.map ->{
                       val  intent = Intent(baseContext, ActivityMap::class.java)
                        startActivity(intent)

                    }

                    R.id.news ->{
                        val intent = Intent(baseContext, ActivityNews::class.java)
                        startActivity(intent)

                    }
                }
                return true


            }

        })


    }

    fun updateList(list: MutableList<User>) {

        adapter = MyAdapter(list, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }
}







