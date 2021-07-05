package com.wahidabd.bajpsubmussion3.ui.favorite.tv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmussion3.databinding.FragmentFavoriteTvBinding
import com.wahidabd.bajpsubmussion3.models.favorite.DataFavorite
import com.wahidabd.bajpsubmussion3.ui.detail.tv.DetailTvActivity
import com.wahidabd.bajpsubmussion3.ui.favorite.FavoriteViewModel
import com.wahidabd.bajpsubmussion3.ui.favorite.adapter.FavoriteMovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteTvFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvBinding
    private lateinit var adapter: FavoriteMovieAdapter
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun setupRecycler() {
        adapter = FavoriteMovieAdapter()
        with(binding){
            rvTvShow.layoutManager = GridLayoutManager(requireContext(), 2)
            rvTvShow.adapter = adapter
        }
    }

    private fun loadData() {
        viewModel.getMovie().observe(viewLifecycleOwner, {
            val data = it.filter { filter -> filter.category == "TV" }
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
                startActivity(
                    Intent(requireContext(), DetailTvActivity::class.java)
                        .putExtra(DetailTvActivity.EXTRA_ID, data.id))
            }
        })
    }
}