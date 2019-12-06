package com.example.projetoandroidbsico

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.*

class MyAdapter(private var users: MutableList<User>, private val context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {
    lateinit var editText_title: EditText
    lateinit var editText_subtitle: EditText


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
        holder.subtitle.text = users[position].lastName
        holder.delete.setOnClickListener {

            users.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, users.size)

        }
        holder.edit.setOnClickListener {
            context.alert {
                title = "Editar"

                customView {
                    linearLayout {

                        this.orientation = LinearLayout.VERTICAL
                        editText_title = editText {
                            setText(users[position].name)

                        }.lparams(width = matchParent, height = wrapContent) {
                            bottomMargin = dip(10)

                        }
                        editText_subtitle = editText {
                            setText(users[position].lastName)
                        }.lparams(width = matchParent, height = wrapContent) {
                            bottomMargin = dip(10)
                        }

                        padding = dip(10)


                    }
                }

                positiveButton("Atualizar") {
                    users[position].name = editText_title.text.toString()
                    users[position].lastName = editText_subtitle.text.toString()
                    notifyItemChanged(position)

                }

            }.show()
        }

    }

    fun addUser(user: User) {
        users.add(user)
        notifyItemInserted(itemCount)
    }
}