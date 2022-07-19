package com.kjy.carrotmarket

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button

// 커스텀 다이얼로그 클래스(사고 팔기 글쓰기 페이지)
// Dialog를 호출하는 액티비티의 Context를 전달 받음.
// context = 어플리케이션 관련 리소스와 클래스를 제공해주는 추상 클래스
class CustomDialogBuy(context: Context) {
    private val dialog = Dialog(context)

    private lateinit var onClickListener: ButtonClickListener

    // 다이얼로그를 선언하고 수정(크기, 터치)등을 수정해줌. 수정후에는 show()로 띄워줌.
    fun showDialog() {
        // setContentView()로 클래스와 레이아웃을 연결해줌
        dialog.setContentView(R.layout.custom_dialog)
        // 다이얼로그 크기를 조정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                    WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

        // 각 버튼 변수 구현
        val customDialog_btn_1 = dialog.findViewById<Button>(R.id.customDialog_btn1)
        val customDialog_btn_2 = dialog.findViewById<Button>(R.id.customDialog_btn2)
        val customDialog_btn_3 = dialog.findViewById<Button>(R.id.customDialog_btn3)
        val customDialog_btn_4 = dialog.findViewById<Button>(R.id.customDialog_btn4)
        val customDialog_btn_5 = dialog.findViewById<Button>(R.id.customDialog_btn5)
        val customDialog_btn_6 = dialog.findViewById<Button>(R.id.customDialog_btn6)
        val customDialog_btn_7 = dialog.findViewById<Button>(R.id.customDialog_btn7)
        val customDialog_btn_8 = dialog.findViewById<Button>(R.id.customDialog_btn8)
        val customDialog_btn_9 = dialog.findViewById<Button>(R.id.customDialog_btn9)
        val customDialog_btn_10 = dialog.findViewById<Button>(R.id.customDialog_btn10)
        val customDialog_btn_11 = dialog.findViewById<Button>(R.id.customDialog_btn11)
        val customDialog_btn_12 = dialog.findViewById<Button>(R.id.customDialog_btn12)
        val customDialog_btn_13 = dialog.findViewById<Button>(R.id.customDialog_btn13)
        val customDialog_btn_14 = dialog.findViewById<Button>(R.id.customDialog_btn14)
        val customDialog_btn_15 = dialog.findViewById<Button>(R.id.customDialog_btn15)
        val customDialog_btn_16 = dialog.findViewById<Button>(R.id.customDialog_btn16)

//
//        val ButtonArray = ArrayList<Button>()
//
//        for(i in 0..15) {ㄴ
//            ButtonArray[i] = dialog.findViewById(R.id.customDialog_btn1 + i)
//        }

        customDialog_btn_1.setOnClickListener {
            onClickListener.onClick(customDialog_btn_1.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_2.setOnClickListener {
            onClickListener.onClick(customDialog_btn_2.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_3.setOnClickListener {
            onClickListener.onClick(customDialog_btn_3.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_4.setOnClickListener {
            onClickListener.onClick(customDialog_btn_4.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_5.setOnClickListener {
            onClickListener.onClick(customDialog_btn_5.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_6.setOnClickListener {
            onClickListener.onClick(customDialog_btn_6.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_7.setOnClickListener {
            onClickListener.onClick(customDialog_btn_7.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_8.setOnClickListener {
            onClickListener.onClick(customDialog_btn_8.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_9.setOnClickListener {
            onClickListener.onClick(customDialog_btn_9.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_10.setOnClickListener {
            onClickListener.onClick(customDialog_btn_10.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_11.setOnClickListener {
            onClickListener.onClick(customDialog_btn_11.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_12.setOnClickListener {
            onClickListener.onClick(customDialog_btn_12.text.toString())
            dialog.dismiss()
        }

        customDialog_btn_13.setOnClickListener {
            onClickListener.onClick(customDialog_btn_13.text.toString())
            dialog.dismiss()
        }
        customDialog_btn_14.setOnClickListener {
            onClickListener.onClick(customDialog_btn_14.text.toString())
            dialog.dismiss()
        }
        customDialog_btn_15.setOnClickListener {
            onClickListener.onClick(customDialog_btn_15.text.toString())
            dialog.dismiss()
        }
        customDialog_btn_16.setOnClickListener {
            onClickListener.onClick(customDialog_btn_16.text.toString())
            dialog.dismiss()
        }
        dialog.show()
    }

    // 커스텀 다이얼로그의 이벤트를 설정해주기 위해 interface를 선언함.
    // 커스텀 다이얼로그의 이벤트를 액티비티로 알려주는 역할
    interface ButtonClickListener {
        fun onClick(text: String)
    }



    fun setOnClickListener(listener: ButtonClickListener) {
        onClickListener = listener
    }

    }
