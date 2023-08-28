package com.example.app.Kotlin_Bai3

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.app.R
import com.example.app.Recycle3.Folder

class Add_Folder : AppCompatActivity() {

    private var tvSave: TextView? = null
    private var tvCancel: TextView? = null
    private var Add_edtName: EditText? = null
    private var Add_edtContent: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_folder)
        tvSave = findViewById(R.id.tvSave)
        tvCancel = findViewById(R.id.tvCancel)
        Add_edtName = findViewById(R.id.Add_edtName)
        Add_edtContent = findViewById(R.id.Add_edtContent)

        tvSave?.setOnClickListener {
            val folders2 = Folders2(
                Id = System.currentTimeMillis().toInt(),
                Name = Add_edtName?.text.toString(),
                Content = Add_edtContent?.text.toString()
            )
            val intent = Intent()
            intent.putExtra("folders2", folders2)
            intent.putExtra(kotlinfolder.KEY, kotlinfolder.TYPE_ADD)
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}