package com.wahidabd.bajpsubmussion3.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmussion3.databinding.ListItemsBinding
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.utils.Constant.IMAGE_URL

class FavoriteMovieAdapter : PagedListAdapter<DataFavorite, FavoriteMovieAdapter.ViewHolder>(
    DIFF_CALLBACK
) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    private val list = ArrayList<DataFavorite>()
    fun setList(list: List<DataFavorite>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: DataFavorite){
            with(binding){
                tvTitle.text = data.title
                Glide.with(imgPhoto)
                    .load(IMAGE_URL+data.poster_path)
                    .into(imgPhoto)

                itemCard.setOnClickListener {
                    onItemClickCallback.onItemClicked(data)
                }
            }
        }
    }

    companion object{
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<DataFavorite> = object : DiffUtil.ItemCallback<DataFavorite>(){
            override fun areItemsTheSame(oldItem: DataFavorite, newItem: DataFavorite): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: DataFavorite, newItem: DataFavorite): Boolean =
                oldItem == newItem
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: DataFavorite)
    }
}