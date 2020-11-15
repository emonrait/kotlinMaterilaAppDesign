package com.example.bankasiaapp.model

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {
    private val BASE_URL = "http://192.168.0.6:8080/"


    var gson = GsonBuilder().setLenient().create()

    var client = OkHttpClient()

    private val apiinstance1 = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)


    val apiinstance: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun createUser( params: RequestBody): Call<ApiResponse> {
        return apiinstance.signinInformation(params)
    }

    fun login(mobile: String?, password: String?): Call<ApiResponse> {
        return apiinstance.logininInformation(mobile, password)
    }


}