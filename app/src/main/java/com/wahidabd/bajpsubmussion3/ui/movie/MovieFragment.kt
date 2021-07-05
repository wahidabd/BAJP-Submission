package com.wahidabd.bajpsubmussion3.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmussion3.databinding.FragmentMovieBinding
import com.wahidabd.bajpsubmussion3.models.movie.DataMovie
import com.wahidabd.bajpsubmussion3.ui.detail.movie.DetailMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MovieAdapter()
        with(binding){
            rvMovie.layoutManager = GridLayoutManager(requireContext(), 2)
            rvMovie.adapter = adapter

            viewModel.getMovie().observe(viewLifecycleOwner, {
                progress.visibility = GONE
                adapter.setList(it)
                adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: DataMovie) {
                        startActivity(Intent(requireContext(), DetailMovieActivity::class.java)
                            .putExtra(DetailMovieActivity.EXTRA_ID, data.id))
                    }
                })
            })
        }


    }
}