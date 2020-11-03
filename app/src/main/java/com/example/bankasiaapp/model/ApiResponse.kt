package com.example.bankasiaapp.model

import com.google.gson.annotations.SerializedName

class ApiResponse {

    @SerializedName("outMessage")
    private var outMessage: String? = null

    @SerializedName("outCode")
    private var outCode = 0

    @SerializedName("name")
    private var name: String? = null

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

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }
}
