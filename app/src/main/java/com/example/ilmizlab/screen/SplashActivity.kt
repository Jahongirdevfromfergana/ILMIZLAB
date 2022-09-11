package com.example.ilmizlab.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ilmizlab.databinding.ActivitySplashAvtivityBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashAvtivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashAvtivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appName.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 0)
    }
}