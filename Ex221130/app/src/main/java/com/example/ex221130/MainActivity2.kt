package com.example.ex221130

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // - RecyclerView
        // - ListView의 개선판:  이유 --> ViewHolder를 강제!!

        // -> LayoutManager : 유연하다
        // -> Linear
        // -> Grid
        // -> StraggleGrid

        // AdapterView 6단계
        // 1) Container 결정
        val rvPoke=findViewById<RecyclerView>(R.id.rvPoke)

        // 2) Template 결정
        // poke_list.xml

        // 3) Item결정
        val pokeList=ArrayList<PokeVO>()
        pokeList.add(PokeVO(R.drawable.p1,"피카츄","전기"))
        pokeList.add(PokeVO(R.drawable.p2,"꼬부기","물"))
        pokeList.add(PokeVO(R.drawable.p3,"파이리","불"))
        pokeList.add(PokeVO(R.drawable.p4,"이상해씨","풀"))
        pokeList.add(PokeVO(R.drawable.p5,"버터플","벌레"))
        pokeList.add(PokeVO(R.drawable.p6,"구구","비행"))
        pokeList.add(PokeVO(R.drawable.p1,"피카츄","전기"))
        pokeList.add(PokeVO(R.drawable.p2,"꼬부기","물"))
        pokeList.add(PokeVO(R.drawable.p3,"파이리","불"))
        pokeList.add(PokeVO(R.drawable.p4,"이상해씨","풀"))
        pokeList.add(PokeVO(R.drawable.p5,"버터플","벌레"))
        pokeList.add(PokeVO(R.drawable.p6,"구구","비행"))

        //4) Adapter 결정

        val adapter =PokeAdapter2(this@MainActivity2,pokeList)

        // 5) Container에 Adapter 부착
        rvPoke.adapter=adapter
        // 5-2) 내가 구현하고자하는 모양에 맞는
        // LayoutManger 를 결정!!
        // 수직으로 쌓는 형태
        rvPoke.layoutManager=LinearLayoutManager(this)
       //수평으로 쌓는형태
//        rvPoke.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)

        //Grid 쌓기
//        rvPoke.layoutManager=StaggeredGridLayoutManager(2,2)
    }
}