package com.edward.smsotp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
val getClient: LoginApiService
    get() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://passwordlessdrf.pythonanywhere.com/accounts/api/v1/")
            .build()

        return retrofit.create(LoginApiService::class.java)
    }
}