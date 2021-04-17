package com.wahidabd.bajpsubmission1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmission1.databinding.ItemsListBinding
import com.wahidabd.bajpsubmission1.model.DataEntity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    
    private var listData = ArrayList<DataEntity>()
    
    fun setData(data: List<DataEntity>?){
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
    
    inner class ViewHolder(private val binding: ItemsListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataEntity){
            with(binding){
                tvTitle.text = data.title
                
                Glide.with(itemView.context)
                    .load(data.imgPoster)
                    .into(imgItemPhoto)
                
//                itemCard.setOnClickListener {
//                    callback.onItemClick(data)
//                }
            }
        }
    }
}
