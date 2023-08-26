package com.example.app.Kotlin_bai2

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class Dog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)
        val rcDogs = findViewById<RecyclerView>(R.id.rcDogs)
        val adapter = DogAdapter(CreateImageDogs())
        adapter.ClickOnItem = {
            Toast.makeText(this, "Đây là chó cảnh", Toast.LENGTH_LONG).show()
        }
        rcDogs.setLayoutManager(GridLayoutManager(this, 3 ))
        rcDogs.addItemDecoration(GridSpacingItemDecoration(8, 3))
        rcDogs.adapter = adapter

    }
    class GridSpacingItemDecoration(private val spacing: Int, private val spanCount: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view) // Get item position
            val column = position % spanCount // Get item column

            outRect.left = spacing - column * spacing / spanCount // Calculate left spacing
            outRect.right = (column + 1) * spacing / spanCount // Calculate right spacing

            if (position >= spanCount) {
                outRect.top = spacing // Add top spacing for items except the first row
            }
        }
    }

    private fun CreateImageDogs(): List<Dogs> {
        val Doglist: MutableList<Dogs> = ArrayList()
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        Doglist.add(Dogs(R.drawable.ic_dog))
        return Doglist
    }
}