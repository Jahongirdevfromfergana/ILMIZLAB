package com.example.ilmizlab.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ilmizlab.databinding.ActivityLoginActtivityBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginActtivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginActtivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}