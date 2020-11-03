package com.example.bankasiaapp.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("add")
    fun signinInformation(
        @Field("name") name: String?,
        @Field("password") password: String?
    ): Call<ApiResponse>


    @GET("/login")
    fun logininInformation(
        @Field("username") email: String?,
        @Field("password") password: String?
    ): Call<ApiResponse>

}