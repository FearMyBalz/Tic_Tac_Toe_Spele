package com.example.tic_tac_toe_spele

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi

class MainMenuActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val secondActivityBtn1: Button = findViewById (R.id.second_act_btn)
        secondActivityBtn1.setOnClickListener {
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }

        val thirdActivityBtn1: Button = findViewById (R.id.third_act_btn)
        thirdActivityBtn1.setOnClickListener {
            val Intent1 = Intent(this,MainActivity2::class.java)
            startActivity(Intent1)
        }

        }
    }