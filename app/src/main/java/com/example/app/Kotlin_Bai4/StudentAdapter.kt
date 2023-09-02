package com.example.app.Kotlin_Bai4

import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class StudentAdapter(var studentlist: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.StudentVH>() {
    private var actionDelete: ((Student) -> Unit)? = null

    class StudentVH (view: View): RecyclerView.ViewHolder(view){
        var username = view.findViewById<TextView>(R.id.username)
        var useraddress = view.findViewById<TextView>(R.id.useraddress)
        var userphone = view.findViewById<TextView>(R.id.userphone)
        var img_remove = view.findViewById<ImageView>(R.id.img_remove)
        var img_avartar = view.findViewById<ImageView>(R.id.img_avt)
        fun setData (student: Student){
            username.text = student.name
            useraddress.text =student.address
            userphone.text = student.phone.toString()
        }
    }
    fun setArrayList(studentlist: ArrayList<Student>){
        this.studentlist = studentlist
    }
    var OnItemClick: ((Student, Int) -> Unit)? = null

    fun setActioDelete(callback: (Student) -> Unit){
        this.actionDelete = callback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent,false)
        return StudentVH(view)
    }

    override fun getItemCount(): Int = if (studentlist.isNotEmpty()) studentlist.size else 0

    override fun onBindViewHolder(holder: StudentVH, position: Int) {
        holder.setData(studentlist.get(position))
        holder.img_avartar.setOnClickListener{
            OnItemClick?.invoke(studentlist.get(position), position)
        }
        holder.img_remove.setOnClickListener {
            actionDelete?.invoke(studentlist.get(position))
        }

    }
}