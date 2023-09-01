package com.example.app.Kotlin_Bai4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

class Students : AppCompatActivity() {

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val name : String? = result.data?.extras?.getString("name")
            val address : String? = result.data?.extras?.getString("address")
            val phone : String? = result.data?.extras?.getString("phone")
            val student = Student(
                id = System.currentTimeMillis(),
                name = name ?: "",
                address = address ?: "",
                phone = phone ?:""
            )
            studentDao?.insert(student)
            updateData()
        }
    }
    private var studentDao: StudentDao? = null
    private var imgAdd: ImageView? = null
    private var img_remove: ImageView? = null
    private var studentlist : ArrayList<Student> = ArrayList()
    private var studentAdapter: StudentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        val rcStudent = findViewById<RecyclerView>(R.id.rcStudent)
        imgAdd = findViewById(R.id.imgAdd)
        img_remove = findViewById(R.id.img_remove)
        studentDao = AppRoomDatabase.getDatabase(this).studentDao()
        studentlist = (studentDao?.getAllStudent() as? ArrayList<Student>) ?: ArrayList()
        studentAdapter = StudentAdapter(studentlist)
        rcStudent?.adapter = studentAdapter

        val startForResult1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val student : Student = result.data?.extras?.get("student") as Student
                for(item in studentlist){
                    if(item.id == student.id){
                        item.name = student.name
                        item.address = student.address
                        item.phone = student.phone
                        break
                    }
                }
                studentAdapter?.notifyDataSetChanged()
            }
        }
        imgAdd?.setOnClickListener {
            val intent = Intent(this, Add_Student::class.java)
            startForResult.launch(intent)
        }

        img_remove?.setOnClickListener {
            // Thực hiện xử lý xóa sinh viên đã chọn tại đây
            val selectedStudent = studentAdapter?.getSelectedStudent() // Lấy sinh viên đã chọn từ adapter

            if (selectedStudent != null) {
                studentDao?.deleteStudent(studentId = selectedStudent.id) // Xóa sinh viên từ cơ sở dữ liệu
                studentlist.remove(selectedStudent) // Xóa sinh viên khỏi danh sách hiển thị
                studentAdapter?.clearSelectedStudent() // Xóa thông tin sinh viên đã chọn trong adapter
                studentAdapter?.notifyDataSetChanged() // Cập nhật giao diện
            }
        }



        studentAdapter?.OnItemClick = {student, position ->
            val intent  = Intent(this, Edit_Student::class.java)
            intent.putExtra("student", student)
            startForResult1.launch(intent)
        }
    }

    private fun updateData() {
        studentlist = studentDao?.getAllStudent() as ArrayList<Student>
        studentAdapter?.setArrayList(studentlist)
        studentAdapter?.notifyDataSetChanged()
    }
}