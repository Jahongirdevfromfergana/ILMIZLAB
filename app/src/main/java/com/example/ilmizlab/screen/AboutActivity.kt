package com.example.ilmizlab.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ilmizlab.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvBack.setOnClickListener {
            finish()
        }
    }
}