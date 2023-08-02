package com.example.testselfintroduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUp = findViewById<Button>(R.id.button_signup)
        signUp.setOnClickListener {
            var signupName = findViewById<EditText>(R.id.signupName).text.toString()
            var signupId = findViewById<EditText>(R.id.signupId).text.toString()
            var signupPassword = findViewById<EditText>(R.id.signupPassword).text.toString()
            if (signupId != "" && signupPassword != "" && signupName != "") {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}