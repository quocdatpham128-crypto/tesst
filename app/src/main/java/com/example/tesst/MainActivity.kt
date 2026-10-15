package com.example.tesst

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tesst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnXacNhan205.setOnClickListener {
            val tenSanPham = binding.edtTenSanPham205.text.toString().trim()
            binding.txtHienThi205.text = tenSanPham
        }
    }
}