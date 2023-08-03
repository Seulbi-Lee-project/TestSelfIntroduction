package com.example.testselfintroduction

import android.app.Activity
import android.app.appsearch.GetByDocumentIdRequest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var getId:EditText
    private lateinit var getPassword:EditText
    private lateinit var logIn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setResultNext()

        getId = findViewById<EditText>(R.id.getId)
        getPassword = findViewById<EditText>(R.id.getPassword)
        logIn = findViewById<Button>(R.id.button_login)

        logIn.setOnClickListener {
            var getIdtext = getId.text.toString()
            var getPwtext = getPassword.text.toString()
            if (getIdtext != "" && getPwtext != "") {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("id", getIdtext)
                resultLauncher.launch(intent)
                getId.text.clear()
                getPassword.text.clear()
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        val signUp = findViewById<Button>(R.id.button_signup)
        signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun setResultNext(){
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            // 서브 액티비티로부터 돌아올 때의 결과 값을 받아 올 수 있는 구문
            if (result.resultCode == RESULT_OK){
                val id = result.data?.getStringExtra("id") ?: ""
                val password = result.data?.getStringExtra("password") ?: ""
                getId.setText(id)
                getPassword.setText(password)
            }
        }
    }
}