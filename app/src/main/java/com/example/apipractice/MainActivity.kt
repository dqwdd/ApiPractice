package com.example.apipractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.apipractice.json.Library
import com.example.apipractice.web.NetWorkInterface
import com.example.apipractice.web.ServerAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {


    val key = "ZttZgKaWHUnvsLX%2FB8UWGVI9d3Uj6PqProTiP2Dnq78CyAgcSK6%2B%2F1r%2FdtmJoWXOTNDBb2G1PxVYeB32Iq6teA%3D%3D\n"

    private lateinit var retrofit: Retrofit
    lateinit var apiService : NetWorkInterface


    lateinit var mContext: Context


    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = ServerAPI.getRetrofit(this)
        apiService = retrofit.create(NetWorkInterface::class.java)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            aa()
        }

    }


    fun aa() {
        apiService.getRequestAppointmentList(key).enqueue(object : Callback<Library>{
            override fun onResponse(call: Call<Library>, response: Response<Library>) {
                if (response.isSuccessful) {
                    Log.d("응답 성공","")
                }

            }

            override fun onFailure(call: Call<Library>, t: Throwable) {
                Log.d("응답 실패", "")
            }
        })
    }




}