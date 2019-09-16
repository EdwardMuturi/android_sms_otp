package com.edward.smsotp.model

import com.google.gson.annotations.SerializedName

data class PhoneRequest(
    @field:SerializedName("phone_number")
    var phone: String)