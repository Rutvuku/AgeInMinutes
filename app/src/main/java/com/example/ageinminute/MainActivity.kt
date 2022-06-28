package com.example.ageinminute

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Btnpick = findViewById<Button>(R.id.Btnpicker)
        Btnpick.setOnClickListener { view ->
            clickDatePicker(view)
        }



    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view: View?) {val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->  Toast.makeText(this,"The chosen years is $selectedYear, month is ${selectedMonth+1} , day is $selectedDayOfMonth", Toast.LENGTH_LONG  ).show()
                         val selectdate =   "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                val selecteddatetext = findViewById<TextView>(R.id.TvSelectedDate)
                selecteddatetext.setText(selectdate)
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectdate)

                val selectedDateInMinutes = theDate!!.time/60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateToMinutes = currentDate!!.time/60000
                val difference = currentDateToMinutes - selectedDateInMinutes
                val final = findViewById<TextView>(R.id.TvSelectedDateInMinute)
                final.setText(difference.toString())

                                               },
            year,
            month,
            day
        )
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }

    }

