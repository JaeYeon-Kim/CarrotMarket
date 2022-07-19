package com.kjy.carrotmarket

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.kjy.carrotmarket.databinding.ActivityBuySellBinding


class BuySellActivity : AppCompatActivity() {
    private val context = this

    val binding by lazy {
        ActivityBuySellBinding.inflate(layoutInflater)
    }

    // 갤러리 사용을 위한 galleryLauncher 프로퍼티를 추가
    lateinit var galleryLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("생명주기", "onCreate 호출!!")

        // galleryLauncher 할당
        galleryLauncher = registerForActivityResult(ActivityResultContracts.
            GetContent()) { uri ->
            binding.galleryImage.setImageURI(uri)
            binding.galleryImageView.visibility = View.VISIBLE
        }

        // 사고 팔기 페이지에서 다이얼로그를 띄워줌
        binding.categorySelectButton.setOnClickListener {
            val dialog = CustomDialogBuy(this)
            dialog.showDialog()
            dialog.setOnClickListener(object: CustomDialogBuy.ButtonClickListener{
                override fun onClick(text: String) {
                    binding.categorySelectText.text = text
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("생명주기", "onStart 호출!!")

        // 뒤로가는 메소드
        backBtn()
    }

    override fun onResume() {
        super.onResume()
        Log.d("생명주기", "onResume 호출!!")

        // 갤러리 호출
        setViews()
    }

    override fun onPause() {
        super.onPause()
        Log.d("생명주기", "onPause 호출!!")

    }

    override fun onStop() {
        super.onStop()
        Log.d("생명주기", "onStop 호출!!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("생명주기", "onRestart 호출!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("생명주기", "onDestory 호출!!")
    }

    // 갤러리 버튼 클릭시 가져오는 메소드
    private fun setViews() {
        binding.galleryButton.setOnClickListener {
            openGallery()
        }
    }

    // 갤러리 오픈 메소드
    private fun openGallery() {
        galleryLauncher.launch("image/*")
    }

    // 뒤로 가는 메소드
    private fun backBtn() {
        binding.buySellBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}
