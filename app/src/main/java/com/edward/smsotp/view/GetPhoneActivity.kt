package com.edward.smsotp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edward.smsotp.R
import kotlinx.android.synthetic.main.activity_main.*

class GetPhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ccp_next_btn.setOnClickListener{
            val smsIntent= Intent(this@GetPhoneActivity, VerifySmsActivity::class.java)
            startActivity(smsIntent)
        }
    }
}
