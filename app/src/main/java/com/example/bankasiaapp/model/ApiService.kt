package com.example.bankasiaapp.model

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {
    private val BASE_URL = "http://192.168.0.3:8080/"


    var gson = GsonBuilder().setLenient().create()

    var client = OkHttpClient()

    val apiinstance: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Api::class.java)
    }

    fun createUser(userId: String?, password: String?): Call<ApiResponse>{
       return apiinstance.signinInformation(userId, password)
    }

    fun login(userId: String?, password: String?): Call<ApiResponse>{
        return apiinstance.logininInformation(userId, password)
    }


}