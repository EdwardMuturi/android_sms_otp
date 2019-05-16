package com.edward.smsotp.model

import com.google.gson.annotations.SerializedName

data class VerifySmsRequest(
    @field:SerializedName("verification_code")
    var code: String,
    @field:SerializedName("phone_number")
    var phoneNumber: String )