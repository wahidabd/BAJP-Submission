package com.wahidabd.bajpsubmission2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmission2.databinding.ItemsListBinding
import com.wahidabd.bajpsubmission2.model.DataList

class MovieAdapter(private val context: Context?) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var onItemClick: OnItemClick
    private var list: List<DataList> = emptyList()

    fun setData(list: List<DataList>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val binding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemsListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataList){
            with(binding){
                Glide.with(root)
                    .load("https://image.tmdb.org/t/p/w500${data.poster_path}")
                    .into(imgItemPhoto)

                tvTitle.text = data.title

                itemCard.setOnClickListener {
                    onItemClick.onItemClicked(data)
                }
            }
        }
    }

    fun setOnItemClick(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }

    interface OnItemClick{
        fun onItemClicked(data: DataList)
    }
}