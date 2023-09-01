package com.example.app.Kotlin_Bai4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.app.Kotlin_Bai3.Folders2
import com.example.app.Kotlin_Bai3.kotlinfolder
import com.example.app.R

class Edit_Student : AppCompatActivity() {
    private var edtNameStudent1: EditText? = null
    private var edtAddressStudent1: EditText? = null
    private var edtPhoneStudent1: EditText? = null
    private var btnEdit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)
        edtNameStudent1 = findViewById(R.id.edtNameStudent1)
        edtAddressStudent1 = findViewById(R.id.edtAddressStudent1)
        edtPhoneStudent1 = findViewById(R.id.edtPhoneStudent1)
        btnEdit = findViewById(R.id.btnEdit)

        val student = intent.extras?.get("student") as? Student
        if (student != null){
            edtNameStudent1?.setText(student.name)
            edtAddressStudent1?.setText(student.address)
            edtPhoneStudent1?.setText(student.phone)
        }

        btnEdit?.setOnClickListener {
            student?.name = edtNameStudent1?.text?.toString() ?:""
            student?.address = edtAddressStudent1?.text?.toString() ?:""
            student?.phone = edtPhoneStudent1?.text?.toString() ?:""

            val intent: Intent = Intent()
            intent.putExtra("student", student)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}