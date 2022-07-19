package com.kjy.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.kjy.carrotmarket.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityChatBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

}