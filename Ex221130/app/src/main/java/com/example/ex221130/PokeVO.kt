package com.example.ex221130
//class PokeVO {
//    var img : Int
//    var name : String
//    var type : String
//    var level : String
//
//    constructor(img : Int, name : String, type : String){
//        this.img = img
//        this.name = name
//        this.type = type
//    } 이렇게 해도 가능
class PokeVO(val img : Int,val name : String, val type :String) {




   var level : String

    init{


        //생성 시 가장 먼저 호출되는 부분
        // 초기화시킬 대상들을 넣어준다
        level="1"



    }
}