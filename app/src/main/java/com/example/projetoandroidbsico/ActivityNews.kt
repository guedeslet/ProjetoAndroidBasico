package com.example.projetoandroidbsico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.Adapters.MyadapterBitcoins
import com.example.projetoandroidbsico.Connection.RetrofitRepositories
import com.example.projetoandroidbsico.Models.BitcoinsNews
import kotlinx.android.synthetic.main.activity_news.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityNews : AppCompatActivity() {

    lateinit var adapterBitcoins : MyadapterBitcoins
    lateinit var recycleViewBitcoins : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        recycleViewBitcoins = recycleBitcoins

        var requestNews = RetrofitRepositories().BitcoinsRequest()
        requestNews.getNews().enqueue(object:Callback<BitcoinsNews>{
            override fun onFailure(call: Call<BitcoinsNews>, t: Throwable) {
                toast("Erro: ${t.message}")
            }

            override fun onResponse(call: Call<BitcoinsNews>, response: Response<BitcoinsNews>) {
                response.body()?.let { confAdapter(it) }

            }

        })

    }

    fun confAdapter (jsonBitcoins : BitcoinsNews){
        adapterBitcoins = MyadapterBitcoins(jsonBitcoins, this )
        recycleViewBitcoins.adapter = adapterBitcoins
        recycleViewBitcoins.layoutManager = LinearLayoutManager(this)
        adapterBitcoins.notifyDataSetChanged()

    }
}
