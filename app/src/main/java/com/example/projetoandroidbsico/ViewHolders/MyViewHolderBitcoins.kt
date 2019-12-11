package com.example.projetoandroidbsico.ViewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.R

class MyViewHolderBitcoins(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: TextView = itemView.findViewById(R.id.textView_TitleNews)
    var description: TextView = itemView.findViewById(R.id.textView_Description)
    var imageView: ImageView = itemView.findViewById(R.id.imageView)
}