package com.edward.smsotp.model

import com.google.gson.annotations.SerializedName

data class SmsVerifyResponse(
    @field:SerializedName("status")
    var status: String,
    @field:SerializedName("message")
    var Token: String,
    @field:SerializedName("token")
    var message: String)