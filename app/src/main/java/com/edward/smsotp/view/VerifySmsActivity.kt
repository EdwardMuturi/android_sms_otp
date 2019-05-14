package com.edward.smsotp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edward.smsotp.R
import com.edward.smsotp.network.LoginApiService
import kotlinx.android.synthetic.main.activity_verify_sms.*

class VerifySmsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_sms)

        sms_verify_btn.setOnClickListener {
            if (!checkEmpty())
                tiet_verification_code.error= "Enter Code"
            else
                startActivity(Intent(this@VerifySmsActivity, MainActivity::class.java))
        }


    }

    private fun checkEmpty():Boolean{
        return tiet_verification_code.text.toString().isNotEmpty()
    }
}
