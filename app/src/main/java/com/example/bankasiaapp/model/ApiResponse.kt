package com.example.bankasiaapp.model

import com.google.gson.annotations.SerializedName

class ApiResponse {

    @SerializedName("outMessage")
    private var outMessage: String? = null

    @SerializedName("outCode")
    private var outCode = 0

    @SerializedName("userId")
    private var userId: String? = null

    fun getoutMessage(): String? {
        return outMessage
    }

    fun setoutMessage(outMessage: String?) {
        this.outMessage = outMessage
    }

    fun getoutCode(): Int {
        return outCode
    }

    fun setoutCode(outCode: Int) {
        this.outCode = outCode
    }

    fun getUserId(): String? {
        return userId
    }

    fun setUserId(userId: String?) {
        this.userId = userId
    }
}
