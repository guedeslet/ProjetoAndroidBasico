package com.example.projetoandroidbsico.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.R
import com.example.projetoandroidbsico.Models.User
import com.example.projetoandroidbsico.ViewHolders.MyViewHolderBooks
import org.jetbrains.anko.*

class MyAdapterBooks(private var users: MutableList<User>, private val context: Context) :
    RecyclerView.Adapter<MyViewHolderBooks>() {
    lateinit var editText_title: EditText
    lateinit var editText_subtitle: EditText


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderBooks {
        return MyViewHolderBooks(
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
    override fun onBindViewHolder(holder: MyViewHolderBooks, position: Int) {
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