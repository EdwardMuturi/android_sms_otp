package com.edward.smsotp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.edward.smsotp.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val builder: AlertDialog.Builder? = this?.let{
            AlertDialog.Builder(it)
        }

        builder?.setMessage("Logged in Successfully")
            ?.setTitle("Success")

        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }
}
