package com.example.app.Kotlin_bai1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class ChatAdapter(val chatlist: List<Chats>) : RecyclerView.Adapter<ChatAdapter.ChatVH>() {
    class ChatVH(view: View) : RecyclerView.ViewHolder(view) {
        private val imgChat = view.findViewById<ImageView>(R.id.imgChat)
        private val name = view.findViewById<TextView>(R.id.name)
        private val content = view.findViewById<TextView>(R.id.content)

        fun setData(chat: Chats) {
            chat.imgChat?.let { imgChat.setImageResource(it) }
            name.text = chat.name
            content.text = chat.content
        }

    }

    var onClickItem: ((Chats) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatVH(view)
    }

    override fun onBindViewHolder(holder: ChatVH, position: Int) {
        holder.setData(chatlist.get(position))
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(chatlist.get(position))
        }
    }

    override fun getItemCount(): Int = if (chatlist.isNotEmpty()) chatlist.size else 0


}