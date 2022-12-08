package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //1. View 들의 id 값을 찾아오자 ( findViewbyId)

        //2. Button에 Event 달아주기 (SetonClickListener
        //2-1. EditText 에 적혀있는 email, password값을 가져오기

        // (email, pw : 변수)----> 문자열로 형변환

        //2-2 가져온 email, pw가 smhrd@smhrd.or.kr,qwer1234가 맞는지 판단 (조건식)
        // 맞다면 Toast로 "로그인 성공" 틀리면 "로그인 실패" 를 띄워주기

        val etEmail=findViewById<EditText>(R.id.etEmail)
        val etPw=findViewById<EditText>(R.id.etPw)
        val btnLogin=findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            var Email=etEmail.text.toString()
            var Pw=etPw.text.toString()

            if(Email=="smhrd@smhrd.or.kr"&&Pw=="qwer1234"){
                Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"로그인 실패",Toast.LENGTH_SHORT).show()

            }
        }
    }
}