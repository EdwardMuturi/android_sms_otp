package com.edward.smsotp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edward.smsotp.view.VerifySmsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ccp_next_btn.setOnClickListener{
            val smsIntent= Intent(this@MainActivity, VerifySmsActivity::class.java)
            startActivity(smsIntent)
        }
    }
}
