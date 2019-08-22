package com.example.lab4ui

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.icu.text.DateFormat
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener{

    private lateinit var calendar: Calendar

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

// Initialize a calendar instance
// Get the system current date
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
// Initialize a new date picker dialog and return it
        return DatePickerDialog(activity!!,this,year,month+1,day)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {

        activity!!.findViewById<TextView>(R.id.text_date).text = "${month+1} / $day / $year"
    }

    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"please select a date.",Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }


    }
