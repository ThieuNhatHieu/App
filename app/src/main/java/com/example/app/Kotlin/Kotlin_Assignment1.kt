package com.example.app.Kotlin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.app.R
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter
import javax.xml.datatype.DatatypeConstants
import javax.xml.datatype.DatatypeConstants.MONTHS

class Kotlin_Assignment1 : AppCompatActivity() {
    private var edtName1: TextInputEditText? = null
    private var edtNgaySinh1: TextInputEditText? = null
    private var edtSDT1: TextInputEditText? = null
    private var edtEmail1: TextInputEditText? = null
    private var edtCmt1: TextInputEditText? = null
    private var btnConfirm: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_assignment1)

        edtName1 = findViewById(R.id.edtName1)
        edtNgaySinh1 = findViewById(R.id.edtNgaySinh1)
        edtSDT1 = findViewById(R.id.edtSDT1)
        edtEmail1 = findViewById(R.id.edtEmail1)
        edtCmt1 = findViewById(R.id.edtCmt1)
        btnConfirm = findViewById(R.id.btnConfirm)

        edtName1?.addTextChangedListener {
            setEnableButton()
        }
        edtSDT1?.addTextChangedListener {
            setEnableButton()
        }
        edtCmt1?.addTextChangedListener {
            setEnableButton()
        }
        edtEmail1?.addTextChangedListener {
            setEnableButton()
        }
        edtNgaySinh1?.setOnClickListener {
            onpenCalendar()
        }
        setEnableButton()
    }


    private fun onpenCalendar() {
        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }
        DatePickerDialog(
            this,
            datePicker,
            myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale("vi", "VN"))
        edtNgaySinh1?.setText(sdf.format(myCalendar.time))
        setEnableButton()
    }

    private fun setEnableButton() {
        btnConfirm?.isEnabled = isEnableButtonConfirm()
        if (isEnableButtonConfirm()) {
            btnConfirm?.background = ContextCompat.getDrawable(this, R.drawable.bg_button_enable)
            btnConfirm?.setTextColor(ContextCompat.getColor(this, R.color.white))
        } else {
            btnConfirm?.background = ContextCompat.getDrawable(this, R.drawable.bg_button_disable)
            btnConfirm?.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    private fun isEnableButtonConfirm(): Boolean {
        return edtName1?.text.toString().trim().isNotEmpty() &&
                edtNgaySinh1?.text.toString().trim().isNotEmpty() &&
                edtSDT1?.text.toString().trim().isNotEmpty() &&
                edtEmail1?.text.toString().trim().isNotEmpty() &&
                edtCmt1?.text.toString().trim().isNotEmpty()

    }
}




