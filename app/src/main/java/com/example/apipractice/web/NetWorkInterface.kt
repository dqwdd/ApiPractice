package com.example.apipractice.web

import com.example.apipractice.json.Library
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap


interface NetWorkInterface {


    @GET("getFoodNtrItdntList?ServiceKey=ZttZgKaWHUnvsLX%2FB8UWGVI9d3Uj6PqProTiP2Dnq78CyAgcSK6%2B%2F1r%2FdtmJoWXOTNDBb2G1PxVYeB32Iq6teA%3D%3D&numOfRows=3&pageNo=1&type=json") //시도별 실시간 측정정보 조회 주소
    fun getRequestAppointmentList(@Path("ServiceKey") type: String) : Call<Library>

}