package com.edward.smsotp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edward.smsotp.R
import com.edward.smsotp.model.PhoneRequest
import com.edward.smsotp.model.SmsVerifyResponse
import com.edward.smsotp.network.ApiClient
import com.edward.smsotp.network.LoginApiService
import kotlinx.android.synthetic.main.activity_get_phone.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPhoneActivity : AppCompatActivity() {
    private var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_phone)

        ccp_next_btn.setOnClickListener {
            if (tiet_ccp_phone.text.toString().isEmpty()) {
                tiet_ccp_phone.error = "Enter Phone"
            } else {
                ccp_next_btn.isClickable = false
                phone= ccp_code.selectedCountryCodeWithPlus + tiet_ccp_phone.text.toString()
                val phoneRequest = PhoneRequest(phone!!)
                sendPhone(phoneRequest)
            }
        }
    }

    private fun sendPhone(phoneRequest: PhoneRequest) {
        val call: Call<SmsVerifyResponse> = ApiClient.getClient.sendPhone(phoneRequest)
        call.enqueue(object : Callback<SmsVerifyResponse> {
            override fun onFailure(call: Call<SmsVerifyResponse>, t: Throwable) {
                Toast.makeText(this@GetPhoneActivity, "Failed to send phone", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<SmsVerifyResponse>, response: Response<SmsVerifyResponse>) {
                if (response.isSuccessful) {
                    val smsVerifyResponse = response.body()
                    Toast.makeText(this@GetPhoneActivity, smsVerifyResponse!!.message, Toast.LENGTH_LONG)
                        .show()
                    val smsIntent = Intent(this@GetPhoneActivity, VerifySmsActivity::class.java)
                    smsIntent.putExtra("user_phone", phone)
                    startActivity(smsIntent)
                }
            }

        })
    }
}
