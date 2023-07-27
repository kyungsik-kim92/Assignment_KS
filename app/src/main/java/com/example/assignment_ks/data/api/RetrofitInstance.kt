package com.example.assignment_ks.data.api

import com.example.assignment_ks.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val okHttpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient) // 로그캣에서 패킷 내용을 확인하기 위해 okhttp 인터셉터를 넘겨 줌
            .baseUrl(BASE_URL)
            .build()
    }

    val api: BookSearchApi by lazy {
        retrofit.create(BookSearchApi::class.java)
    }
}