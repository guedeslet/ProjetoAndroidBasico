package com.example.projetoandroidbsico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.Models.BitcoinsNews
import com.example.projetoandroidbsico.R
import com.example.projetoandroidbsico.ViewHolders.MyViewHolderBitcoins
import com.squareup.picasso.Picasso


class MyadapterBitcoins(private var bitcoinsNews: BitcoinsNews, private val context: Context) :
    RecyclerView.Adapter<MyViewHolderBitcoins>() {
    lateinit var editText_title: EditText
    lateinit var editText_description: EditText
    lateinit var imageView: ImageView


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderBitcoins {
        return MyViewHolderBitcoins(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listnews,
                parent,
                false
            )
        )
    }

    // geItemCount vai saber quantos itens estão vindo na lista
    override fun getItemCount(): Int {
        return bitcoinsNews.articles.size

    }

    // Ele faz a cola entre o que está no adapter e cada item dentro do viewHolder
    override fun onBindViewHolder(holder: MyViewHolderBitcoins, position: Int) {
        holder.title.text = bitcoinsNews.articles[position].title
        holder.description.text = bitcoinsNews.articles[position].description
        Picasso.get().load(bitcoinsNews.articles[position].urlToImage).centerCrop().resize(
            1000, 1000).into(holder.imageView)
    }

}
