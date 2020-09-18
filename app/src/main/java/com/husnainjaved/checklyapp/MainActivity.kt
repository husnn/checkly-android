package com.husnainjaved.checklyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.husnainjaved.checkly.ChecklySelectionListener
import com.husnainjaved.checkly.ChecklyOption
import com.husnainjaved.checkly.ChecklyView

class MainActivity : AppCompatActivity() {

    var selectedInterests = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkly = findViewById<ChecklyView>(R.id.checkly)

        checkly.setLabels(choices)

        checkly.selectionListener = object : ChecklySelectionListener {
            override fun onOptionToggled(option: ChecklyOption) {
                val selectedText = if (option.selected) "selected" else "unselected"
                Toast.makeText(applicationContext, "${option.name} was $selectedText", Toast.LENGTH_SHORT).show()
            }

            override fun onOptionsUpdated(options: List<ChecklyOption>) {
                selectedInterests = options.filter { it.selected }.map { it.name }
            }
        }
    }

    private val choices = listOf(
        "Business",
        "Entertainment",
        "Finance",
        "Marketing",
        "Technology",
        "Sports"
    )
}