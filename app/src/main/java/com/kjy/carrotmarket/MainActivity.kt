package com.kjy.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kjy.carrotmarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 액션바를 툴바에 적용
        setSupportActionBar(binding.toolbar)
        // 툴바 타이틀 제거
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // 데이터 생성 코드
        val data:MutableList<Memo> = loadRecyclerData()
        // 어댑터 생성후 데이터 목록 저장
        var adapter = MyAdapter()
        adapter.listData = data

        binding.RecyclerView.adapter = adapter

        binding.RecyclerView.layoutManager = LinearLayoutManager(this)

        binding.RecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    }

    // 메뉴(툴바)를 구성하는 함수
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 툴바 메뉴 선택시 이벤트 처리 함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean  {
        return super.onOptionsItemSelected(item)
    }

    // 플로팅 액션 버튼 이벤트
    private fun fabButtonEvent() {
        binding.fabButton.setOnClickListener {

        }
    }

    // 리사이클러뷰 개수 설정
    fun loadRecyclerData(): MutableList<Memo> {
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..50) {
            val mainText = "나이키 스캇 프라그먼트 270\n사이즈 팝니다."
            val subText = "방화제2동 - 끌올 29초 전"
            val priceText = "180,000,0원"
            val heartText = "1"

            var memo = Memo(mainText, subText, priceText, heartText)
            data.add(memo)
        }
        return data
    }
}