@file:Suppress("DEPRECATION")

package com.wahidabd.bajpsubmission2.ui.home.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmission2.adapter.MovieAdapter
import com.wahidabd.bajpsubmission2.databinding.FragmentMovieBinding
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.ui.detail.DetailActivity
import com.wahidabd.bajpsubmission2.utils.Helper.MOVIE_TYPE
import com.wahidabd.bajpsubmission2.utils.ViewModelFactory
import com.wahidabd.bajpsubmission2.utils.progressBar

class MovieFragment : Fragment() {

    private val viewModel by lazy {
        val factory = ViewModelFactory.getInstance()
        ViewModelProviders.of(this, factory)[MovieViewModel::class.java]
    }

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar(true, binding.progress)

        val adapter = MovieAdapter(context)
        viewModel.getMovies().observe(viewLifecycleOwner, {
            adapter.setData(it)
            progressBar(false, binding.progress)
        })

        with(binding.rvMovie){
            layoutManager = GridLayoutManager(context, 2)
            this.adapter = adapter
        }

        adapter.setOnItemClick(object : MovieAdapter.OnItemClick{
            override fun onItemClicked(data: DataList) {
                startActivity(Intent(
                    activity, DetailActivity::class.java)
                    .putExtra(DetailActivity.EXTRA_TYPE, MOVIE_TYPE)
                    .putExtra(DetailActivity.EXTRA_ID, data.id.toString())
                )
            }
        })
    }
}