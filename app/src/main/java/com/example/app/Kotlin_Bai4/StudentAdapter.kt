package com.example.app.Kotlin_Bai4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class StudentAdapter(var studentlist: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.StudentVH>() {
    private var selectedStudent: Student? = null
    class StudentVH (view: View): RecyclerView.ViewHolder(view){
        var username = view.findViewById<TextView>(R.id.username)
        var useraddress = view.findViewById<TextView>(R.id.useraddress)
        var userphone = view.findViewById<TextView>(R.id.userphone)

        fun setData (student: Student){
            username.text = student.name
            useraddress.text =student.address
            userphone.text = student.phone.toString()
        }
    }
    var onremove : ((Int) -> Unit)? = null
    fun setArrayList(studentlist: ArrayList<Student>){
        this.studentlist = studentlist
    }
    var OnItemClick: ((Student, Int) -> Unit)? = null

    fun setSelectedStudent(student: Student?) {
        selectedStudent = student
    }
    fun clearSelectedStudent() {
        selectedStudent = null
    }

    fun getSelectedStudent(): Student? {
        return selectedStudent
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent,false)
        return StudentVH(view)
    }

    override fun getItemCount(): Int = if (studentlist.isNotEmpty()) studentlist.size else 0

    override fun onBindViewHolder(holder: StudentVH, position: Int) {
        holder.setData(studentlist.get(position))
        holder.itemView.setOnClickListener{
            OnItemClick?.invoke(studentlist.get(position), position)
            onremove?.invoke(position)
        }

    }
}