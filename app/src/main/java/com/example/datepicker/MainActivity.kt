package com.example.datepicker

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var  etDate:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etDate = findViewById(R.id.etDate)
        etDate.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year->OnDataSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun OnDataSelected(day: Int, month: Int, year: Int) {
        etDate.setText("has seleccionado el dia  $day del mes ${month+1} del año $year")
    }
}