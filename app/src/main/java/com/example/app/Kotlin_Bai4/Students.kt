package com.example.app.Kotlin_Bai4

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import kotlinx.coroutines.launch

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
    private var img_avartar: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        val rcStudent = findViewById<RecyclerView>(R.id.rcStudent)
        img_avartar = findViewById(R.id.img_avt)
        imgAdd = findViewById(R.id.imgAdd)
        img_remove = findViewById(R.id.img_remove)
        studentDao = AppRoomDatabase.getDatabase(this).studentDao()
        studentlist = (studentDao?.getAllStudent() as? ArrayList<Student>) ?: ArrayList()
        studentAdapter = StudentAdapter(studentlist)
        rcStudent?.adapter = studentAdapter

        if (img_remove == null) {
            Log.e("MyActivity", "imgRemove is null") // Log lỗi nếu imgRemove bị null
        }

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


        studentAdapter?.OnItemClick = { student, position ->
            // Thực hiện xử lý chuyển đến trang Edit_Student ở đây
            // Nhưng kiểm tra nếu position tương ứng với img_remove thì không chuyển trang
                val intent = Intent(this, Edit_Student::class.java)
                intent.putExtra("student", student)
                startForResult1.launch(intent)
        }


        studentAdapter?.setActioDelete {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("bạn có chắc chắn xóa không")
            builder.setPositiveButton("YES"){p0, p1 ->
                lifecycleScope.launch{
                       studentDao?.deleteStudent(it)
                        updateData()
                    }
                    p0.dismiss()
                }
                builder.setNegativeButton("NO"){p0, p1->
                    p0.dismiss()
                }
                val  dialog = builder.create()
                dialog.show()
            }


        }


    private fun updateData() {
        studentlist = studentDao?.getAllStudent() as ArrayList<Student>
        studentAdapter?.setArrayList(studentlist)
        studentAdapter?.notifyDataSetChanged()
    }
}