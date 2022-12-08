package com.example.ex221130

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout

class ExamActivity : AppCompatActivity() {

    //전역변수로 올리기
    lateinit var clExam :ConstraintLayout
    //색상을 누르면 바로 적용 될수 있게 하기
    override fun onRestart() {
        super.onRestart()
    val sharedPreferences=getSharedPreferences("sp1",Context.MODE_PRIVATE)
    val color= sharedPreferences.getString("bgColor","white")

       clExam.setBackgroundColor(Color.parseColor(color))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)

        // 로그인 기능 !!
        // 자동 로그인
        // Application을 종료해도
        // 정보가 저장될 필요성이 있다
        // DB
        // -RDB(Relational DataBase)
        // -RDBMS
        // -> OracleDB
        // -> MySQL
        // -> MariaDB
        // SQL > 쿼리문 작성
        // NoSQL > (Key, Value)

        //SQLite -> 실제 데이터베이스 안드로이드 내장
        // SharedPreFerence -> 환경설정정보들을 공유하기 위해!!
        // NoSQL -> Key, Value
        // 버튼 -> 그리드 -> 리니어 -> 그리드



        val btnRed=findViewById<Button>(R.id.btnRed)
        val btnPink=findViewById<Button>(R.id.btnPink)
        val btnBlack=findViewById<Button>(R.id.btnBlack)
        val btnOther=findViewById<Button>(R.id.btnOther)

         clExam=findViewById<ConstraintLayout>(R.id.clExam)

        //  tvResult :변수
        // PI 3.141592 : 상수
        //                                                콘텍스트 안에 들어있는 상수 전부 대문자는 상수이다
        val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)

        // MODE_PRIVATE : application 내에서만 공유가능
        // MODE_WORLD_READABLE : 다른 application 에서 읽을 수 있음
        // MODE_WORLD_WRITABLE :다른 application 에서 읽고 쓸 수 있음
        val bgColor : String?=sharedPreferences.getString("bgColor","white")
        clExam.setBackgroundColor(Color.parseColor(bgColor))

        btnRed.setOnClickListener {
            val editor = sharedPreferences.edit()
            val bgColor:String="red"
           editor.putString("bgColor",bgColor)
            editor.commit()

            clExam.setBackgroundColor(Color.parseColor(bgColor))
        }
        btnPink.setOnClickListener {
            val editor= sharedPreferences.edit()
            val bgColor="blue"
            editor.putString("bgColor",bgColor)
            editor.commit()

            clExam.setBackgroundColor(Color.parseColor(bgColor))
        }
        btnBlack.setOnClickListener {
            val editor= sharedPreferences.edit()
            val bgColor="black"
            editor.putString("bgColor",bgColor)
            editor.commit()

            clExam.setBackgroundColor(Color.parseColor(bgColor))
        }
        btnOther.setOnClickListener {
            val intent= Intent(this,ColorActivity::class.java)
            startActivity(intent)
        }
    }
}