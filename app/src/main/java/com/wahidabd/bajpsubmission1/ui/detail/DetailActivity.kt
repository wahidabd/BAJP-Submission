package com.wahidabd.bajpsubmission1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.wahidabd.bajpsubmission1.R
import com.wahidabd.bajpsubmission1.data.Helper.MOVIE_TYPE
import com.wahidabd.bajpsubmission1.data.Helper.TV_TYPE
import com.wahidabd.bajpsubmission1.databinding.ActivityDetailBinding
import com.wahidabd.bajpsubmission1.model.DataEntity

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var data: DataEntity
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_ID)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type == MOVIE_TYPE){
            viewModel.selectedMovie(id.toString())
            data = viewModel.setMovie()
        }else if (type == TV_TYPE) {
            viewModel.selectedTv(id.toString())
            data = viewModel.setTv()
        }

        with(binding) {
            tvTitle.text = data.title
            tvDesc.text = data.description
            tvRealaseDate.text = data.realeaseYear
            tvGenre.text = data.genre

            Glide.with(this@DetailActivity).load(data.imgPoster).into(imgItemPhoto)
            Glide.with(this@DetailActivity).load(data.imgBackground).into(imgItemPreview)

        }
    }
}