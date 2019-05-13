package com.edward.smsotp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edward.smsotp.R
import kotlinx.android.synthetic.main.activity_get_phone.*

class GetPhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_phone)

        ccp_next_btn.setOnClickListener{
            val smsIntent= Intent(this@GetPhoneActivity, VerifySmsActivity::class.java)
            startActivity(smsIntent)
        }
    }
}
