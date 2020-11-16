package com.example.bankasiaapp.model

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface Api {

    @POST("/addUser")
    fun signinInformation(
        @Body params: RequestBody?
    ): Call<ApiResponse>


    @POST("/login")
    fun logininInformation(
        @Body params: RequestBody
    ): Call<ApiResponse>


    @FormUrlEncoded
    @GET("/users/{userId}")
    fun getuser(
        @Field("userId") userId: String?
    ): Call<ApiResponse>

    @FormUrlEncoded
    @PUT("/userupdate}")
    fun userUpdate(
        @Field("userId") userId: String?
    ): Call<ApiResponse>


}