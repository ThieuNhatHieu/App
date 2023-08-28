package com.example.app

import android.view.View

fun View.setOnSingleClick (onClick: ((View?) -> Unit)){
    setOnClickListener(object : SingleClickListenerJava(){
        override fun onClick(v: View?) {
            super.onClick(v)
            onClick.invoke(v)
        }
    })
}