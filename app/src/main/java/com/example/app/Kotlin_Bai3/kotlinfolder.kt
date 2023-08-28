package com.example.app.Kotlin_Bai3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import androidx.recyclerview.widget.DividerItemDecoration

class kotlinfolder : AppCompatActivity() {
    companion object {
        const val KEY = "KEY"
        const val TYPE_EDIT = "TYPE_EDIT"
        const val TYPE_ADD = "TYPE_ADD"
    }
    private val startForResult1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            val type = result.data?.extras?.getString(KEY)
            if (type == TYPE_ADD){
                val folders2 = result.data?.extras?.get("folders2") as? Folders2
                if (folders2 != null){
                    folderlist2.add(0, folders2)

                }
                folder2Adapter?.notifyDataSetChanged()
            }else if (type == TYPE_EDIT){
                val folders2 = result.data?.extras?.get("folders2") as? Folders2
                if (folders2 != null){
                    for (item in folderlist2){
                        if (item.Id == folders2.Id){
                            item.Name = folders2.Name
                            item.Content = folders2.Content
                            break
                        }
                    }
                    folder2Adapter?.notifyDataSetChanged()
                }
            }
        }
    }
    private var tvInsert: TextView? = null
    private var imgBack: ImageView? = null
    private val folderlist2 : ArrayList<Folders2> = ArrayList()
    private var folder2Adapter: Folder2Adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlinfolder)
        val rcFolder2 = findViewById<RecyclerView>(R.id.rcfolderkotlin)
//        val adapter = Folder2Adapter(CreateListFolder())
        tvInsert = findViewById(R.id.tvInsert)
        imgBack = findViewById(R.id.imgBack)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rcFolder2?.addItemDecoration(dividerItemDecoration)
        folderlist2.add(Folders2(1, "Tổng hợp tin tức thời sự", "tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        folderlist2.add(Folders2(2,  "Do It Your Self", "Sơn Tùng M-TP đẹp trai hát hay"))
        folderlist2.add(Folders2(3,  "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        folderlist2.add(Folders2(4, "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        folderlist2.add(Folders2(5,"Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        folderlist2.add(Folders2(6, "Cảm hứng sáng tạo","tổng hợp tin tức thời sự nóng hổi nhất của tất cả các miền trên dất nước"))
        folder2Adapter = Folder2Adapter(folderlist2)
        rcFolder2?.adapter = folder2Adapter
        tvInsert?.setOnClickListener{
            val intent = Intent(this, Add_Folder::class.java)
            startForResult1.launch(intent)
        }

        folder2Adapter?.OnItemClick = {folders2, position ->
            val intent  = Intent(this, Update_Folder::class.java)
            intent.putExtra("folders2", folders2)
            startForResult1.launch(intent)
        }
    }
}

//private fun CreateListFolder(): List<Folders2> {
//    val folderlist2: MutableList<Folders2> = ArrayList()
//    folderlist2.add(
//        Folders2(
//            1,
//            R.drawable.ic_folder2,
//            "Tổng hợp tin tức thời sự",
//            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."
//        )
//    )
//    folderlist2.add(
//        Folders2(
//            2,
//            R.drawable.ic_folder2,
//            "Do It Your Self",
//            "Sơn tùng MTP quá đẹp trai hát hay"
//        )
//    )
//    folderlist2.add(
//        Folders2(
//            3,
//            R.drawable.ic_folder2,
//            "Cảm hứng sáng tạo",
//            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."
//        )
//    )
//    folderlist2.add(
//        Folders2(
//            4,
//            R.drawable.ic_folder2,
//            "Tổng hợp tin tức thời sự",
//            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."
//        )
//    )
//    folderlist2.add(
//        Folders2(
//            5,
//            R.drawable.ic_folder2,
//            "Do It Your Self",
//            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."
//        )
//    )
//    folderlist2.add(
//        Folders2(
//            6,
//            R.drawable.ic_folder2,
//            "Cảm hứng sáng tạo",
//            "Tổng hợp tin tức thời sự nóng hổi nhất, của tất cả các ..."
//        )
//    )
//    return folderlist2
//}
