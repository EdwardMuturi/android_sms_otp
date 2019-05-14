package com.edward.smsotp.model

data class VerifySmsRequest(var code: String, var phoneNumber: String )