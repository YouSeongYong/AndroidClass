package com.example.ex20221202

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_1, container, false)

        //WebView 찾아오기

        val spf= requireActivity().getSharedPreferences(
            "mySPF",Context.MODE_PRIVATE
        )


        //1. 주소 준비
        val wv=view.findViewById<WebView>(R.id.wv)
        val url=spf.getString("url","http://www.google.com")
        //2. 설정 변경 (javascript 사용 가능하도록 '허용')
        val ws=wv.settings
        ws.javaScriptEnabled=true
        //3.  WebView에 Client 설정
        wv.webViewClient= WebViewClient()
        //4.  웹 뷰에 주소 적용
        // default Value가 있음
        wv.loadUrl(url!!)


        return view
    }


}