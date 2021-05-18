package com.fedegiorno.primerparcial.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.fedegiorno.primerparcial.R

class SplashActivity : AppCompatActivity() {

    private val SPLASHTIMEOUT:Long = 2000 // 2 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(

            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            , SPLASHTIMEOUT)
    }
}