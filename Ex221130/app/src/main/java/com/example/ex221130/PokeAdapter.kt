package com.example.ex221130

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PokeAdapter(val context: Context,val PokeList : ArrayList<PokeVO>) : BaseAdapter() {
    override fun getCount(): Int {
        // itemView(항목 뷰)가 몇 번 만들어져야 하는 지
        return PokeList.size
    }

    override fun getItem(p0: Int): Any {
        return PokeList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    // ★★★★★
    // p0 : position
    // p1 : itemView
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

    // 0. xml -> Kotlin : inflator
        val layoutInflater=LayoutInflater.from(context)
        //1. poke_list.xml -> 코드로 접근할 수 있게
        var view = layoutInflater.inflate(R.layout.poke_list,null)
        var holder= ViewHolder()

        if(p1==null){
            // 항목 뷰 (itemView)가 안 만들어졌을 때!
            // 각 component들을 초기화 시켜주자!!
            Log.d("호출","1")
            holder.imgPoke=view.findViewById<ImageView>(R.id.imgPoke)
            holder.tvPokeLevel=view.findViewById<TextView>(R.id.tvPokeLevel)
            holder.tvPokeName=view.findViewById<TextView>(R.id.tvPokeName)
            holder.tvPokeType=view.findViewById<TextView>(R.id.tvPokeType)

            view.tag=holder

        }else{
            Log.d("호출","2")
            holder = p1.tag as ViewHolder
            view= p1
        }

        // 데이터를 너무 많이 잡아먹어 위에 처럼 하기
//        val imgPoke=view.findViewById<ImageView>(R.id.imgPoke)
//        val tvPokeLevel=view.findViewById<TextView>(R.id.tvPokeLevel)
//        val tvPokeName=view.findViewById<TextView>(R.id.tvPokeName)
//        val tvPokeType=view.findViewById<TextView>(R.id.tvPokeType)

        holder.imgPoke?.setImageResource(PokeList.get(p0).img)
        holder.tvPokeLevel?.setText("레벨 : "+PokeList.get(p0).level)
        holder.tvPokeName?.setText(PokeList.get(p0).name)
        holder.tvPokeType?.setText(PokeList.get(p0).type)

        return view
    }
    // inner Class
    // 클래스 안에 클래스를 만드는 이유???
    // 1.부모 클래스의 변수들을 다 사용할 수 있다!!
    // 2. 외부에서  이 inner Class를 사용할 이유가 없을 때!!

    //Design Pattern
    //MVC

    //ViewHolder Pattern
    // getView의 findViewByID로 접근한 정보들을
    // 저장하고 있는 class ViewHolder를 만들어서
    //메모리의 성능을 향상시키자

    class ViewHolder(){
        var imgPoke : ImageView? =null
        var tvPokeLevel : TextView?=null
        var tvPokeName : TextView?=null
        var tvPokeType : TextView?=null
    }
}