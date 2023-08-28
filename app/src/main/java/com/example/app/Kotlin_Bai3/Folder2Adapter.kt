package com.example.app.Kotlin_Bai3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class Folder2Adapter(val folderlist2: List<Folders2>) : RecyclerView.Adapter<Folder2Adapter.FolderVH>() {
    class FolderVH (view: View): RecyclerView.ViewHolder(view){
        private val imgFolder = view.findViewById<ImageView>(R.id.imgFolder)
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvContent = view.findViewById<TextView>(R.id.tvContent)

        fun setData(folders2: Folders2){
//            folders2.imgFolder2?.let { imgFolder.setImageResource(it) }
            tvName.text = folders2.Name
            tvContent.text = folders2.Content
        }
    }

    var OnItemClick: ((Folders2, Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderVH {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_kotlin_folder,parent,false)
        return FolderVH(view)
    }

    override fun getItemCount(): Int = if (folderlist2.isNotEmpty()) folderlist2.size else 0

    override fun onBindViewHolder(holder: FolderVH, position: Int) {
        holder.setData(folderlist2.get(position))
        holder.itemView.setOnClickListener{
            OnItemClick?.invoke(folderlist2.get(position), position)
        }
    }
}