package com.example.directapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd=findViewById<Button>(R.id.btnAdd)
        val lv=findViewById<ListView>(R.id.lv)

        //1.btnAdd(추가)를 누르면 AddActivity(Sub)로 이동
        // 단 , 받아올 데이터 값이 있음 : 양방향 데이터
        btnAdd.setOnClickListener {
            val intent=Intent(this@MainActivity,AddActivity::class.java)
        //양방향 만들어주기위해 런쳐 사용
        //런쳐(콜백 함수)
            launcher.launch(intent)
        }

        // 2. AddActivity 에서 btnSend(Button)를 누르면,
        // EditText에 적혀있는 title, url값을 가지고 MainActivity로 이동
        // (finish())

        //3. AddActivity에서 보낸 값 (intent 안에 들어있는)을 받아주자
        //런쳐 사용하기

        //4. ListView만들기
        //4-1. ListView 위치 정해주기
        //4-2. ListView 한 칸에 들어갈 디자인(템플릿 -> xml)
        //4-3 AddActivity 에서 받아온 결과 값으로 ListView에 들어갈 데이터
        // (title, url ---> 하나의 자료형으로 묶어주세요 (DirectVO))

        //4-4. Adapter 만들기
        // 4-5. Adatper ListView 적용
    }

    // AddActivity로 부터 받아온 데이터를 꺼내주자
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        // it: resultCode, intent(title,url)
        if(it.resultCode== RESULT_OK){
            val title=it.data?.getStringExtra("title")
            val url=it.data?.getStringExtra("url")
        }
    }

}