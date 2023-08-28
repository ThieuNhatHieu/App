package com.example.app.SharePreferences

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.app.R
import com.example.app.setOnSingleClick

class SharePre : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_pre)

        val tvName = findViewById<TextView>(R.id.tvName)
        val edtName = findViewById<EditText>(R.id.edtName)
        val btnSave = findViewById<Button>(R.id.btnSave)

        tvName.text = SharePreferenceUtils.getName(this)
        btnSave.setOnSingleClick {
            val name = edtName.text.toString().trim()
            SharePreferenceUtils.saveName(name, this)

            //Lấy dữ liệu name đc lưu ở local và set vào text view
            tvName.text = SharePreferenceUtils.getName(this)
        }
    }
}