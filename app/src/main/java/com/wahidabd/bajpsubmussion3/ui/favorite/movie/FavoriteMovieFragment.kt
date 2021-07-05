package com.wahidabd.bajpsubmussion3.ui.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmussion3.databinding.FragmentFavoriteMovieBinding
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.ui.detail.movie.DetailMovieActivity
import com.wahidabd.bajpsubmussion3.ui.favorite.FavoriteViewModel
import com.wahidabd.bajpsubmussion3.ui.favorite.adapter.FavoriteMovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var adapter: FavoriteMovieAdapter
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    private fun setupRecycler() {
        adapter = FavoriteMovieAdapter()
        with(binding){
            rvMovie.layoutManager = GridLayoutManager(requireContext(), 2)
            rvMovie.adapter = adapter
            loadData()
        }
    }

    private fun loadData() {
        viewModel.getMovie().observe(viewLifecycleOwner,{
            val data = it.filter { filter -> filter.category == "MOVIE" }
            if (data.isEmpty()){
                binding.imgEmpty.visibility = View.VISIBLE
                binding.noData.visibility = View.VISIBLE
            }else{
                binding.imgEmpty.visibility = View.INVISIBLE
                binding.noData.visibility = View.INVISIBLE
            }
            adapter.setList(data)
        })

        adapter.setOnItemClickCallback(object : FavoriteMovieAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DataFavorite) {
                startActivity(Intent(requireContext(), DetailMovieActivity::class.java)
                    .putExtra(DetailMovieActivity.EXTRA_ID, data.id))
            }
        })
    }
}