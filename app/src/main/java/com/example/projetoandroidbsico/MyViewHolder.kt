package com.example.projetoandroidbsico

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    var title : TextView = itemView.findViewById(R.id.textView_Title)
    var subtitle : TextView = itemView.findViewById(R.id.textView_Subtitle)
    var delete : ImageButton = itemView.findViewById(R.id.ImageButton_Delete)
    var edit : ImageButton = itemView.findViewById(R.id.ImageButton_Edit)
}