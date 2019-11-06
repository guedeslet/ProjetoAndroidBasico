package com.example.projetoandroidbsico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetoandroidbsico.Adapter.Adapter
import kotlinx.android.synthetic.main.activity_main_list.*

class MainActivityList : AppCompatActivity()
{
    var mListBooks = ListItem(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        val adapter = Adapter(this, mListBooks)

        var layoutManager = LinearLayoutManager(this)
        var recycleView = recycleView_Layout
        recycleView.layoutManager = layoutManager
        recycleView.adapter = adapter


        button_fab.setOnClickListener{
            
        }



    }


}
