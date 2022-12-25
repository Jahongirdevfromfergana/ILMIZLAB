package com.example.ilmizlab.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ilmizlab.R
import com.example.ilmizlab.databinding.ActivityRegstrationBinding
import com.fraggjkee.smsconfirmationview.SmsConfirmationView

class RegistrationActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegstrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegstrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val view = findViewById<SmsConfirmationView>(R.id.sms_code_view)
        view.onChangeListener = SmsConfirmationView.OnChangeListener { code, isComplete ->
            Toast.makeText(this, "value: $code, isComplete: $isComplete", Toast.LENGTH_SHORT)
                .show()
        }

//        view.startListeningForIncomingMessages()
    }
}