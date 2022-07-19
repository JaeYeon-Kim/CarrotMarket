package com.kjy.carrotmarket

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import com.google.android.material.bottomappbar.BottomAppBar


// 메인 액티비티의 커스텀 다이얼로그
// 다이얼로그 사용을 위해 파라미터로 Context를 받음.
class CustomDialogMain(context: Context) {
    private val dialog = Dialog(context)

    private lateinit var onClickListener: ButtonClickListener

    fun showMainDialog() {
        dialog.setContentView(R.layout.custom_dialog_main)
        // 레이아웃 배경을 투명하게 함. 카드 뷰 사용시 레이아웃의 직사각형 테두리를 없애줌.
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                    WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(true)          // 뒤로가기 시 다이얼로그 종료
        dialog.setCanceledOnTouchOutside(true)      // 다이얼로그 바깥 클릭시 다이얼로그 종료

        val dialogMainButton = dialog.findViewById<Button>(R.id.dialog_main_sellButton)

        dialogMainButton.setOnClickListener {
            onClickListener.onClick(dialogMainButton.text.toString())
            dialog.dismiss()
        }
        dialog.show()
    }

    // 이벤트를 위해 인터페이스 사용
    interface ButtonClickListener {
        fun onClick(text: String)
    }

    fun setOnClickListener(listener: ButtonClickListener){
        onClickListener = listener
    }

}