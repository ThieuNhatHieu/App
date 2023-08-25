package com.example.app.Kotlin_bai1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class Chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        val rcChat = findViewById<RecyclerView>(R.id.rcChat)
        val adapter = ChatAdapter(CreateChatList())
        adapter.onClickItem = {
            Toast.makeText(this, "${it.imgChat}_${it.name}_${it.content}", Toast.LENGTH_LONG).show()
        }
        rcChat.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        rcChat.adapter = adapter
    }


    private fun CreateChatList(): List<Chats> {
        val chatlist: MutableList<Chats> = ArrayList()
        chatlist.add(Chats(R.drawable.ic_chat, "James", "Thank you! That was very helpful!"))
        chatlist.add(
            Chats(
                R.drawable.ic_chat1,
                "Will Kenny",
                "I know... I’m trying to get the funds."
            )
        )
        chatlist.add(
            Chats(
                R.drawable.ic_chat2,
                "Beth Williams",
                "I’m looking for tips around capturing the milky way. I have a 6D with a 24-100mm..."
            )
        )
        chatlist.add(
            Chats(
                R.drawable.ic_chat3,
                "Rev Shawn",
                "Wanted to ask if you’re available for a portrait shoot next week."
            )
        )
        return chatlist
    }

}