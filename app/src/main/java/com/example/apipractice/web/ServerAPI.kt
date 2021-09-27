package com.example.apipractice.web

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

    companion object {

//        서버 주소
        val hostURL = "http://apis.data.go.kr/1470000/FoodNtrIrdntInfoService/"

//        Retrofit 형태의 변수가 ==> OkhttpClient처럼 실제 호출 담당
//        레트로핏 객체는 -> 하나만 만들어두고 -> 여러 화면에서 공유해서 사용
//        객체를 하나로 유지하자 => SingleTon 패턴 사용

        private var retrofit : Retrofit? = null

        fun getRetrofit(context: Context) : Retrofit {

            if (retrofit == null) {

                val interceptor = Interceptor {
                    with(it) {

                        val newRequest = request().newBuilder()
                            .build()

                        proceed(newRequest)

                    }
                }

                retrofit = Retrofit.Builder()
                    .baseUrl(hostURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


            return retrofit!!

        }

    }



}