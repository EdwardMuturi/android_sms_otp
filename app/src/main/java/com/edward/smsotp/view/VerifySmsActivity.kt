package com.edward.smsotp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edward.smsotp.R
import com.edward.smsotp.model.SmsVerifyResponse
import com.edward.smsotp.model.VerifySmsRequest
import com.edward.smsotp.network.ApiClient
import com.edward.smsotp.network.LoginApiService
import kotlinx.android.synthetic.main.activity_verify_sms.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifySmsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_sms)

        sms_verify_btn.setOnClickListener {
            if (!checkEmpty())
                tiet_verification_code.error = "Enter Code"
            else {
                val code = tiet_verification_code.text.toString()
                val phone = intent.extras!!.getString("user_phone")
                val verifySmsRequest = VerifySmsRequest(code, phone!!)

                verifySms(verifySmsRequest)
            }

        }


    }

    private fun checkEmpty(): Boolean {
        return tiet_verification_code.text.toString().isNotEmpty()
    }

    private fun verifySms(verifySmsRequest: VerifySmsRequest) {
        val call = ApiClient.getClient.verifyCode(verifySmsRequest)
        call.enqueue(object : Callback<SmsVerifyResponse> {
            override fun onFailure(call: Call<SmsVerifyResponse>, t: Throwable) {
                Toast.makeText(this@VerifySmsActivity, "Failed to send phone", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<SmsVerifyResponse>, response: Response<SmsVerifyResponse>) {
                if (response.isSuccessful) {
                    startActivity(Intent(this@VerifySmsActivity, MainActivity::class.java))
                }
            }

        })
    }
}
