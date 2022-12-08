package com.example.ex20221124

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ImageActivity : AppCompatActivity() {

    val imgArray= intArrayOf(R.drawable.pink,R.drawable.black,R.drawable.blue,
        R.drawable.yellow,R.drawable.red)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val img= findViewById<ImageView>(R.id.img)
        val btnPre=findViewById<Button>(R.id.btnPre)
        val btnNext=findViewById<Button>(R.id.btnNext)

//        img.setImageResource(R.drawable.pink)

        //1.pre버튼을 눌렀을때!(setOnClickListener)
        var index=0
        btnPre.setOnClickListener {
            //1-1. index -1감소
            // 해당 index 에 있는 img의 id르 ㄹ가져와서
            // ImageView에 set 하자!
            // index의 조건 : 0보다 작으면 다시 마지막이미지로 돌아가자 index값을 size-1으로 돌리자
           index--
            if(index<0){
            index=imgArray.size -1


            }
            img.setImageResource(imgArray[index])
        }
        btnNext.setOnClickListener {
            //2. Next버튼을 눌렀을때
            //2-1 index+1 증가
            // 해당 index에 있는 img의 id를 가져와서
            // ImageView를 set하자
            // index의 조건 : size -1보다 크면 다시 index값을 0으로
            index++
            if(index>imgArray.size-1){
                index=0

            }
            img.setImageResource(imgArray[index])
        }






    }
}