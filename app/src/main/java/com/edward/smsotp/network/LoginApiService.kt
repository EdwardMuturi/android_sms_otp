package com.edward.smsotp.network

import com.edward.smsotp.model.PhoneRequest
import com.edward.smsotp.model.SmsVerifyResponse
import com.edward.smsotp.model.VerifySmsRequest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApiService {
    @Headers("Content-Type: application/json")
    @POST("/accounts/authenticate/")
    fun sendPhone(@Body phoneRequest: PhoneRequest): Call<SmsVerifyResponse>

    @Headers("Content-Type: application/json")
    @POST("/accounts/confirm/")
    fun verifyCode(@Body verifySmsRequest: VerifySmsRequest): Call<SmsVerifyResponse>
}