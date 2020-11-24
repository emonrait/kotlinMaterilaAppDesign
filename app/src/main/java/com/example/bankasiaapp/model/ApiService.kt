package com.example.bankasiaapp.model

import com.google.gson.GsonBuilder
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiService {
    private val BASE_URL = "http://10.11.200.4:8080/"


    var gson = GsonBuilder().setLenient().create()

    var client = OkHttpClient()

    private val apiinstance1 = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)


    val apiinstance: Api by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun createUser(params: RequestBody): Call<ApiResponse> {
        return apiinstance.signinInformation(params)
    }

    fun login(params: RequestBody): Call<UserResponse> {
        return apiinstance.logininInformation(params)
    }

    fun getUser(): Single<List<ApiResponse>> {
        return apiinstance.getuser()
    }

    fun updateUser(params: RequestBody): Call<ApiResponse> {
        return apiinstance.userUpdate(params)
    }


}