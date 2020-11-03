package com.example.bankasiaapp.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("insertuser")
    fun signinInformation(
        @Field("userId") userId: String?,
        @Field("password") password: String?
    ): Call<ApiResponse>


    @GET("/login")
    fun logininInformation(
        @Field("userId") userId: String?,
        @Field("password") password: String?
    ): Call<ApiResponse>

}