package com.edward.smsotp.model

import com.google.gson.annotations.SerializedName

data class Error(
    @field:SerializedName("error")
    var errorString: String
)