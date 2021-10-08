package com.example.apipractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apipractice.json.Body
import com.example.apipractice.json.Item
import com.example.apipractice.json.Library
import com.example.apipractice.web.NetWorkInterface
import com.example.apipractice.web.ServerAPI
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {


    val key = "ZttZgKaWHUnvsLX%2FB8UWGVI9d3Uj6PqProTiP2Dnq78CyAgcSK6%2B%2F1r%2FdtmJoWXOTNDBb2G1PxVYeB32Iq6teA%3D%3D"

    private lateinit var retrofit: Retrofit
    lateinit var apiService : NetWorkInterface


    lateinit var button : Button
    lateinit var RecyclerView : RecyclerView


    val mItemList = ArrayList<Item>()

    lateinit var mRecyclerAdapter : RecyclerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retrofit = ServerAPI.getRetrofit(this)
        apiService = retrofit.create(NetWorkInterface::class.java)

        button = findViewById(R.id.button)
        RecyclerView = findViewById(R.id.RecyclerView)

        mRecyclerAdapter = RecyclerAdapter(this, mItemList)
        RecyclerView.adapter = mRecyclerAdapter

        RecyclerView.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            aa()
        }

    }


    fun aa() {

        apiService.getRequestAppointmentList(key).enqueue(object : Callback<Library>{
            override fun onResponse(call: Call<Library>, response: Response<Library>) {
                if (response.isSuccessful) {

                    Log.d("응답 성공",response.body()!!.toString())
                    val basicResponse = response.body()!!
                    mItemList.clear()
                    mItemList.addAll(basicResponse.body.items)

                    mRecyclerAdapter.notifyDataSetChanged()
                }
                else {
                    val jsonObj = JSONObject(response.errorBody()!!.string())

                    Log.d("응답 실패", jsonObj.toString())
                    Log.d("응답 실패", jsonObj.toString())
                }

            }

            override fun onFailure(call: Call<Library>, t: Throwable) {
                Log.d("연결 실패", call.toString())
            }
        })
    }




}