package com.kjy.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjy.carrotmarket.databinding.ItemRecyclerBinding


// 어댑터 준비 -> 항목을 구성해주는 역할
class MyAdapter: RecyclerView.Adapter<MyViewHolder>() {

    var listData = mutableListOf<Memo>()
    // 뷰 홀더 준비를 위한 자동 호출

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더의 뷰 데이터 출력
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)

    }

    // 항목 개수 판단
    override fun getItemCount(): Int {
        return listData.size
    }
}


// 뷰 홀더 준비 -> 각 항목을 구성하는 뷰 객체를 가진다. (텍스트뷰, 이미지뷰 등등)
class MyViewHolder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
    fun setMemo(memo: Memo) {
        binding.mainText.text = memo.mainText
        binding.subText.text = memo.subText
        binding.priceText.text = memo.priceText
        binding.heartText.text = memo.heartText
    }
}