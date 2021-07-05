package com.wahidabd.bajpsubmussion3.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmussion3.databinding.ListItemsBinding
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import com.wahidabd.bajpsubmussion3.utils.Constant.IMAGE_URL

class TvAdapter : RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    private val list = ArrayList<DataTv>()
    fun setList(list: List<DataTv>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvAdapter.ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataTv){
            with(binding){
                tvTitle.text = data.name
                Glide.with(imgPhoto)
                    .load(IMAGE_URL+data.poster_path)
                    .into(imgPhoto)

                itemCard.setOnClickListener {
                    onItemClickCallback.onItemClicked(data)
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: DataTv)
    }

}