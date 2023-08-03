package com.example.testselfintroduction

import android.graphics.Bitmap
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList
import java.util.Random

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textId = findViewById<TextView>(R.id.textId)
        val homeImage = findViewById<ImageView>(R.id.homeImage)

        var imageSet = intArrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5)
        var randowInt = (0..4).random()

        homeImage.setImageResource(imageSet[randowInt])

        if(intent.hasExtra("id")){
            textId.text = "ID : " + intent.getStringExtra("id")
        }

        val finishBtn = findViewById<Button>(R.id.finishBtn)
        finishBtn.setOnClickListener {
            finish()
        }
    }
}