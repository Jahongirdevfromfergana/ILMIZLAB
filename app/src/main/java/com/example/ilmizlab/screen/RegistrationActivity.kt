package com.example.ilmizlab.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ilmizlab.R
import com.example.ilmizlab.databinding.ActivityRegstrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegstrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegstrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}