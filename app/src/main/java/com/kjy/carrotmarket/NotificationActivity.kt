package com.kjy.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.tabs.TabLayoutMediator
import com.kjy.carrotmarket.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityNotificationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 액션바를 툴바에 적용(툴바를 사용한다.)
        setSupportActionBar(binding.toolbar)
        // 툴바 기본 타이틀 제거
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // 백버튼 클릭시 뒤로 이동
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 뷰페이저 구현
        val textList = listOf("활동 알림 페이지", "키워드 알림")

        // 어댑터 클래스 변수 설정
        val customAdapter = CustomPageAdapter()

        customAdapter.textList = textList

        binding.viewPager.adapter = customAdapter

        // 탭 레이아웃 제목을 설정하고 TabLayoutMediator로 뷰페이저와 연동 해줌.
        val tabTitles = listOf("활동 알림", "키워드 알림")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()      // 호출 메서드

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}