package com.example.ex221130

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        //1. Container 설정
        val rvColor = findViewById<RecyclerView>(R.id.rvColor)

        //2. Template 결정
        //color_list.xml

        //3. Item 결정
        val colorList = ArrayList<ColorVO>()
        var color:String
        //"#" +red(16) +green(16) + blue(16)
        for (i in 0..255 step 32) {
            var red: String = Integer.toHexString(i)

            for (j  in 255 downTo 0 step 32) {
                var green: String = Integer.toHexString(j)

                for (k in 0..255 step 32) {
                    var blue: String = Integer.toHexString(k)

                    if(red.length == 1){red = "0" + red}
                    if(green.length == 1){green = "0" + green}
                    if(blue.length == 1){blue = "0" + blue}

                    color = "#$red$green$blue"
                    colorList.add(ColorVO(color))
                }

            }

        }

//        colorList.add(ColorVO("#FF0000"))
//        colorList.add(ColorVO("#00FF00"))
//        colorList.add(ColorVO("#0000FF"))
//        colorList.add(ColorVO("#FFFFFF"))
//        colorList.add(ColorVO("#000000"))

        //4. Adapter 설정
        val adapter = ColorAdapter(this, colorList)

        //5. Container에 Adapter 부착
        rvColor.adapter = adapter
        rvColor.layoutManager = GridLayoutManager(this, 40)
//        rvColor.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)



    }
}