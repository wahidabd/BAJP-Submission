package com.wahidabd.bajpsubmission2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmission2.databinding.ActivityDetailBinding
import com.wahidabd.bajpsubmission2.ui.home.movie.MovieViewModel
import com.wahidabd.bajpsubmission2.ui.home.tv.TvViewModel
import com.wahidabd.bajpsubmission2.utils.Helper
import com.wahidabd.bajpsubmission2.utils.Helper.MOVIE_TYPE
import com.wahidabd.bajpsubmission2.utils.Helper.TV_TYPE
import com.wahidabd.bajpsubmission2.utils.ViewModelFactory

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory!!)[DetailViewModel::class.java]

        val type = intent.getStringExtra(EXTRA_TYPE)
        val id = intent.getStringExtra(EXTRA_ID)

        viewModel.setData(id.toString(), type.toString())
        viewModel.getDetail().observe(this, {
            with(binding){
                when(type){
                    MOVIE_TYPE -> {
                        tvTitle.text = it.title
                        tvRealaseDate.text = it.release_date
                    }

                    TV_TYPE -> {
                        tvTitle.text = it.name
                        tvRealaseDate.text = it.first_air_date
                    }
                }

                tvDesc.text = it.overview

                Glide.with(imgItemPhoto)
                    .load(Helper.IMAGE_URL + it.poster_path)
                    .into(imgItemPhoto)

                Glide.with(imgItemPreview)
                    .load(Helper.IMAGE_URL + it.backdrop_path)
                    .into(imgItemPreview)
            }

            Toast.makeText(this, "Load Success", Toast.LENGTH_SHORT).show()
        })
    }
}