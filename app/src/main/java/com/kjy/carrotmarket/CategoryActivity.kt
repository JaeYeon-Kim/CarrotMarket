package com.kjy.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.kjy.carrotmarket.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityCategoryBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

            binding.backBtn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            binding.digitalButton.setOnClickListener {
                    Toast.makeText(this, "디지털기기 버튼입니다.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
