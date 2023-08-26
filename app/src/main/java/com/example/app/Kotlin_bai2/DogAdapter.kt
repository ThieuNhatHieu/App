package com.example.app.Kotlin_bai2

import android.view.LayoutInflater
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class DogAdapter(val Doglist: List<Dogs>): RecyclerView.Adapter<DogAdapter.DogVH>() {
    class DogVH(view: View): RecyclerView.ViewHolder(view){
        private val imageDogs = view.findViewById<ImageView>(R.id.imageDogs)

         fun setData(dogs: Dogs){
            dogs.ImageDogs?.let { imageDogs.setImageResource(it) }
        }
    }

    var ClickOnItem: ((Dogs) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dogs,parent,false)
        return DogVH(view)
    }

    override fun getItemCount(): Int = if (Doglist.isNotEmpty()) Doglist.size else 0


    override fun onBindViewHolder(holder: DogVH, position: Int) {
        holder.setData(Doglist[position])
        holder.itemView.setOnClickListener{
            ClickOnItem?.invoke(Doglist[position])
        }
    }

}