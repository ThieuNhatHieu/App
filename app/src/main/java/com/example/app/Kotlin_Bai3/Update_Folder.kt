package com.example.app.Kotlin_Bai3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.app.R
import java.util.jar.Attributes.Name

class Update_Folder : AppCompatActivity() {
    private var Update_edtName: EditText? = null
    private var Update_edtContent: EditText? = null
    private var tvUpdate: TextView? = null
    private var tvCancel_update: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_folder)
        Update_edtName = findViewById(R.id.Update_edtName)
        Update_edtContent = findViewById(R.id.Update_edtContent)
        tvUpdate = findViewById(R.id.tvUpdate)
        tvCancel_update = findViewById(R.id.tvCancel_update)

        val folders2 = intent.extras?.get("folders2") as? Folders2
        if (folders2 != null){
            Update_edtName?.setText(folders2.Name)
            Update_edtContent?.setText(folders2.Content)
        }

        tvUpdate?.setOnClickListener {
            folders2?.Name = Update_edtName?.text?.toString() ?:""
            folders2?.Content = Update_edtContent?.text?.toString() ?:""
            val intent: Intent = Intent()
            intent.putExtra("folders2", folders2)
            intent.putExtra(kotlinfolder.KEY, kotlinfolder.TYPE_EDIT)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}