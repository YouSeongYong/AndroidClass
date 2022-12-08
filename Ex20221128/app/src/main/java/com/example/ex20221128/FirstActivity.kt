package com.example.ex20221128

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ListView

class FirstActivity : AppCompatActivity() {

    var color: String = "white" //배경 색상을 저장해 Second Activity로 보내자


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnNext = findViewById<Button>(R.id.btnNext)
        val lv = findViewById<ListView>(R.id.lv)

        //안쪽에 오버라이딩된 메서드를 4개 가지고 있다
//        lv.setOnItemClickListener { adapterView, view, i, l ->  }

        lv.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


                //p2 : postion
                // p0가 null이면 어떡할래?

//                if(p0==null){
//                color= p0.adapter.getItem(p2).toString()
//
//                }

                color = p0!!.adapter.getItem(p2).toString()
//               if(p2==0){
//                   color="purple"
//               }else if(p2==1){
//                   color="yellow"
//               }else if(p2==2){
//                   color="pink"
//               }
                Log.d("찍어보자", color)
                //p3 : id

            }
        })


        // 버튼 클릭을 감지하는 리스너를 장착
        // setOnClickListener

        // inner class
        // 익명 클래스 anonymous class

//        btnNext.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                TODO("Not yet implemented")
//            }
//        })
//
//        btnNext.setOnClickListener { v ->
//
//            //버튼 클릭을 감지하는 리스너를 장착
//        }


        // Android 4대 구성요소
        // Activity 화면을 구성
        // Service (Background에서 동작) Activity에서 화면만 뺀거
        // BR(Broadcast Receiver)
        // CP(Content Provider)
        // 카카오톡에서 다른사람에게 연락처를 전송하고 할 때
        // 연락처 어플리케이션에서 연락처 정보를
        // 카톡으로 넘김

        //4대 구성요소간 정보를 매개하는
        //Intent

        //명시적, 묵시적
        //explicit, implicit

        //Activity 로 이동하는 Intent (명시적 인텐드)
        //(시작Activity, 도착Activity)
        //(this, java class)
        btnNext.setOnClickListener {

            var intent = Intent(
                this,
                // Kclass로 만들어진 Activity를 java calss 로 바꿔줘야한다
                // 액티비티명 :: class.java ---> java class로 바뀜
                //자바 클래스로 변환
                SecondActivity::class.java
            )
            intent.putExtra("color", color)
            //단방향 호출
            startActivity(intent)
            // 실행!!!!
        }
        //Ctrl + o (overriding)
        // 혹은 우클릭 -> generate -> override methods


    }

    override fun onStart() {
        super.onStart()
        Log.d("생명주기", "OnStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("생명주기", "OnStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d("생명주기", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("생명주기", "OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("생명주기", "OnRestart")
    }


}