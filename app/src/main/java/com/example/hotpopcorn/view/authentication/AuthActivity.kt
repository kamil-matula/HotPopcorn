package com.example.hotpopcorn.view.authentication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hotpopcorn.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}