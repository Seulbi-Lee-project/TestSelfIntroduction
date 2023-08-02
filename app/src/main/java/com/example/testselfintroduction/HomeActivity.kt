package com.example.testselfintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textId = findViewById<TextView>(R.id.textId)

        if(intent.hasExtra("id")){
            textId.text = "ID : " + intent.getStringExtra("id")
        }

        val finishBtn = findViewById<Button>(R.id.finishBtn)
        finishBtn.setOnClickListener {
            finish()
        }
    }
}