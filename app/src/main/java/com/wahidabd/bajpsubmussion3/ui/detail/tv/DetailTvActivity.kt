package com.wahidabd.bajpsubmussion3.ui.detail.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmussion3.R
import com.wahidabd.bajpsubmussion3.databinding.ActivityDetailTvBinding
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTvActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvBinding
    private val viewModel: DetailTvViewModel by viewModels()
    private var status: Boolean? = null
    private var dataFavorite = DataFavorite()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        checkFavorite(id)

        viewModel.getTv(id).observe(this, {
            if (it != null){
                dataFavorite = DataFavorite(
                    it.id, it.name, it.poster_path, it.backdrop_path, it.first_air_date, "TV"
                )
            }

            with(binding){
                progress.visibility = View.GONE
                tvTitle.text = it.name
                tvRealaseDate.text = it.first_air_date
                tvDesc.text = it.overview

                Glide.with(imgItemPhoto)
                    .load(Constant.IMAGE_URL +it.poster_path)
                    .into(imgItemPhoto)

                Glide.with(imgItemPreview)
                    .load(Constant.IMAGE_URL +it.backdrop_path)
                    .into(imgItemPreview)
            }
        })

        with(binding){
            imgFavorite.setOnClickListener {
                if (status == true) deleteFavorite(id)
                else setFavorite(dataFavorite)
            }

            imgBack.setOnClickListener {
                onBackPressed()
            }
        }
    }

    private fun checkFavorite(id: Int){
        viewModel.getFavoriteById(id).observe(this, {
            status = it != null
            if (status == true){
                binding.imgFavorite.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.ic_favorite)
                )
            }else{
                binding.imgFavorite.setImageDrawable(
                    ContextCompat.getDrawable(this, R.drawable.ic_un_favorite)
                )
            }
        })
    }

    private fun setFavorite(data: DataFavorite){
        viewModel.insertFavorite(data)
        status = true
        data.id?.let { checkFavorite(it) }
    }

    private fun deleteFavorite(id: Int){
        viewModel.deleteFavoriteById(id)
        status = false
        checkFavorite(id)
    }

    companion object{
        const val EXTRA_ID = "extra id"
    }
}