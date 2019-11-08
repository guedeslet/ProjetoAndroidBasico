package com.example.projetoandroidbsico

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val users: MutableList<User>) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.listview,
                parent,
                false
            )
        )
    }

    // geItemCount vai saber quantos itens estão vindo na lista
    override fun getItemCount(): Int {
        return users.size

    }

    // Ele faz a cola entre o que está no adapter e cada item dentro do viewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = users[position].name
        holder.delete.setOnClickListener {

            users.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, users.size)

        }


    }

    fun addUser(user: User) {
        users.add(user)
        notifyItemInserted(itemCount)
    }
}