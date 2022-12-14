package com.example.ex20221201

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MovieActivity : AppCompatActivity() {
    //Volley에 필요한 객체 2개
    var queue : RequestQueue?=null// 요청을 가지고 서버로 이동하는 객체
    lateinit var request : StringRequest // 요청 /응답이 들어가는 객체
    var movies= ArrayList<MovieVO>() //영화 정보들이 담길 배열

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        // Volley를 통한 네트워크 통신 4단계
        // 1. Volley 설정
        // -Volley 라이브러리 추가
        // -Manifest 에 Permission 추가!! -> Internet
        // 2. RequestQueue 생성
        // 3. Request 생성
        // 4. RequestQueue 에 생명주기



        // 1) Container 결정
        val rc= findViewById<RecyclerView>(R.id.rc)
        val btnMovie= findViewById<Button>(R.id.btnMovie)
        val etInput = findViewById<EditText>(R.id.etInput)
        // 버튼을 클릭하거나, 에뮬레이터를 작동,  OnCreate가 실행될때마다
        // request가들어갈 장소를 만들고 있음


        // 2) Template 결정
        // movielist.xml

        //3) Item 결정
        // movies : ArrayList<MovieVO>

        //4) Adapter 결정
        val adapter = MovieAdapter(this,movies)


        //5) Container에 Adapter 부착
        rc.adapter=adapter
        rc.layoutManager=LinearLayoutManager(this)


        if(queue==null){

        queue = Volley.newRequestQueue(this@MovieActivity)
        }
        //btnMovie를 클릭했을 때 영화정보를 (response) Log로 확인해보자
        btnMovie.setOnClickListener {
           //버튼 눌렀을때 실행 될수 있게
            val date= etInput.text.toString()
            val url="https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=$date"

            request = StringRequest(
            // 1. get/post

             Request.Method.GET,
                url,

            // 3. 응답 성공시 Listener
            {response->
                movies.clear()
                //응답 받아온 response :String
                val json1= JSONObject(response)
                val json2=json1.getJSONObject("boxOfficeResult")
                Log.d("json2",json2.toString())
                val json3=json2.getJSONArray("dailyBoxOfficeList")
                Log.d("json3",json3.toString())

//                val movie = json3.getJSONObject(0)
//                val rank=movie.getString("rank")
//                Log.d("rank",rank)

                //JsonArray에 순차적으로 접근해서 영화 정보 꺼내오기기
                for(i in 0 until 10){
                    val movie=json3.getJSONObject(i)
                var rank=movie.getString("rank")
                var rankOldAndNew= movie.getString("rankOldAndNew")
                var movieNm=movie.getString("movieNm")
                    Log.d("영화",movieNm)
                var openDt= movie.getString("openDt")
                var audiAcc= movie.getString("audiAcc")

                // rank, rankOldAndNew , movieNm , openDt, audiAcc
                    //하나의 자료형 MovieVO 를 ArrayList에 저장
                    movies.add(MovieVO(rank, rankOldAndNew,movieNm,openDt,audiAcc))
                }
                adapter.notifyDataSetChanged()

            },
           //4. 응답 실패시
                { error->}
            )
    queue?.add(request)
        }
    }
}