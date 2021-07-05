package com.wahidabd.bajpsubmussion3.ui.detail.movie

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmussion3.R
import com.wahidabd.bajpsubmussion3.databinding.ActivityDetailMovieBinding
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.utils.Constant.IMAGE_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private val viewModel: DetailMovieViewModel by viewModels()
    private var status: Boolean? = null
    private var dataFavorite = DataFavorite()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        checkFavorite(id)

        viewModel.getMovie(id).observe(this, {
            if (it != null){
                dataFavorite = DataFavorite(
                    it.id, it.title, it.poster_path, it.backdrop_path, it.release_date, "MOVIE"
                )
            }

            with(binding){
                progress.visibility = View.GONE
                tvTitle.text = it.title
                tvRealaseDate.text = it.release_date
                tvDesc.text = it.overview

                Glide.with(imgItemPhoto)
                    .load(IMAGE_URL+it.poster_path)
                    .into(imgItemPhoto)

                Glide.with(imgItemPreview)
                    .load(IMAGE_URL+it.backdrop_path)
                    .into(imgItemPreview)
            }
        })

        with(binding){
            imgFavorite.setOnClickListener {
                if (status == true) deleteFavorite(id)
                else setFavorite(dataFavorite)

            }

            imgBack.setOnClickListener {
                finish()
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

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        finish()
        return super.navigateUpTo(upIntent)
    }

    companion object{
        const val EXTRA_ID = "extra id"
    }
}