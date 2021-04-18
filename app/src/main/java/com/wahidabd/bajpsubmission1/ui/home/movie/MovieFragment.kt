package com.wahidabd.bajpsubmission1.ui.home.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmission1.adapter.MovieAdapter
import com.wahidabd.bajpsubmission1.data.Helper.MOVIE_TYPE
import com.wahidabd.bajpsubmission1.databinding.FragmentMovieBinding
import com.wahidabd.bajpsubmission1.model.DataEntity
import com.wahidabd.bajpsubmission1.ui.detail.DetailActivity
import com.wahidabd.bajpsubmission1.ui.home.HomeViewModel

class MovieFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
            val movie = viewModel.getAllMovie()

            val adapter = MovieAdapter()
            adapter.setData(movie)

            with(binding.rvMovie){
                setHasFixedSize(true)
                this.adapter = adapter
                layoutManager = GridLayoutManager(context, 2)
            }

            adapter.setOnItemClick(object : MovieAdapter.OnItemClick {
                override fun onItemClicked(data: DataEntity) {
                    startActivity(
                            Intent(activity, DetailActivity::class.java)
                                    .putExtra(DetailActivity.EXTRA_ID, data.id)
                                    .putExtra(DetailActivity.EXTRA_TYPE, MOVIE_TYPE)
                    )
                }
            })
        }
    }
}