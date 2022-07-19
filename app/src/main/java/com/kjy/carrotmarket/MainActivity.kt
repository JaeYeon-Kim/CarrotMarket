package com.kjy.carrotmarket

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kjy.carrotmarket.databinding.ActivityMainBinding
import com.kjy.carrotmarket.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {

    private val context = this

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        // 액션바를 툴바에 적용(툴바를 사용한다.)
        setSupportActionBar(binding.toolbar)
        // 툴바 기본 타이틀 제거
        supportActionBar?.setDisplayShowTitleEnabled(false)


        // 데이터 생성 코드
        val data: MutableList<Memo> = loadRecyclerData()
        // 어댑터 생성후 데이터 목록 저장
        var adapter = MyAdapter()
        adapter.listData = data

        // 리사이클러뷰 어댑터 지정, 레이아웃 매니저로 수직의 리스트를 만듬.
        binding.RecyclerView.adapter = adapter
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        // 디바이더 아이템 데코레이션 메서드로 리사이클러뷰 각 아이템마다 구분선을 그어준다.
        binding.RecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        // 스피너 사용을 위한 리스트 생성
        var dataList = listOf("방화동", "화곡동", "염창동", "내 동네 설정")

        // 데이터와 스피너를 연결해줄 ArrayAdapter 클래스를 만들어 adapter 변수에 저장.
        // 문자열로 구성했기 때문에 데이터 타입 = String
        // 파라미터 -> (3가지!! 스피너를 그리기 위한 컨텍스트, 목록 하나하나 그려질 레이아웃, 어댑터에서 사용할 데이터)

        var spinnerAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList)
        binding.Spinner.adapter = spinnerAdapter

        // 스피너 클릭 이벤트 구현
        binding.Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // 아이템이 선택되었을 때
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                binding.spinnerText.text = dataList.get(position)
            }

            // 아무것도 선택되지 않았을 경우
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }



        binding.fabButton.setOnClickListener {
            val dialog = CustomDialogMain(this)
            dialog.showMainDialog()
            val intent = Intent(this, BuySellActivity::class.java)
            dialog.setOnClickListener(object: CustomDialogMain.ButtonClickListener{
                override fun onClick(text: String) {
                    startActivity(intent)
                }
            })
        }
    }

    // 메뉴(툴바)를 구성하는 함수
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 툴바 메뉴 선택시 이벤트 처리 함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.search -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.menu -> {
                val intent = Intent(this, CategoryActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.notification -> {
                val intent = Intent(this, NotificationActivity::class.java)
                startActivity(intent)
                finish()
            }


        }

        return super.onOptionsItemSelected(item)
    }


    // 리사이클러뷰 개수 설정
    fun loadRecyclerData(): MutableList<Memo> {
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..50) {
            val mainText = "나이키 스캇 프라그먼트 270\n사이즈 팝니다."
            val subText = "방화제2동 - 끌올 29초 전"
            val priceText = "950,000원"
            val heartText = "1"

            var memo = Memo(mainText, subText, priceText, heartText)
            data.add(memo)
        }
        return data
    }

}