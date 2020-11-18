package com.example.bankasiaapp.model

import io.reactivex.Single
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

    @GET("/users")
    fun getuser(): Single<List<ApiResponse>>

    @GET("/users/{userId}")
    fun getuserbyid(
        @Field("userId") userId: String?
    ): Call<ApiResponse>

    @FormUrlEncoded
    @PUT("/userupdate}")
    fun userUpdate(
        @Field("userId") userId: String?
    ): Call<ApiResponse>


}