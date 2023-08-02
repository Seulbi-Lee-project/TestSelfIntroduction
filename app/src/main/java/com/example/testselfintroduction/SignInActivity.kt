package com.example.testselfintroduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getId = findViewById<EditText>(R.id.getId)
        val getPassword = findViewById<EditText>(R.id.getPassword)
        val logIn = findViewById<Button>(R.id.button_login)

        logIn.setOnClickListener {
            var getIdtext = getId.text.toString()
            var getPwtext = getPassword.text.toString()
            if (getIdtext != "" && getPwtext != "") {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id",getIdtext)
                getId.text.clear()
                getPassword.text.clear()
                startActivity(intent)
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        val signUp = findViewById<Button>(R.id.button_signup)
        signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}