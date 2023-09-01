package com.example.app.Kotlin_Bai4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.app.R

class Add_Student : AppCompatActivity() {
    private var edtNameStudent: EditText? = null
    private var edtAddressStudent: EditText? = null
    private var edtPhoneStudent: EditText? = null
    private var btnAdd: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        edtNameStudent = findViewById(R.id.edtNameStudent)
        edtAddressStudent = findViewById(R.id.edtAddressStudent)
        edtPhoneStudent = findViewById(R.id.edtPhoneStudent)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd?.setOnClickListener {
            val addname : String = edtNameStudent?.text.toString()
            val addaddress : String = edtAddressStudent?.text.toString()
            val addphone : String = edtPhoneStudent?.text.toString()
            val intent = Intent()
            intent.putExtra("name", addname)
            intent.putExtra("address", addaddress)
            intent.putExtra("phone", addphone)
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}