package com.wahidabd.bajpsubmission1.ui.home.tv

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
import com.wahidabd.bajpsubmission1.data.Helper.TV_TYPE
import com.wahidabd.bajpsubmission1.databinding.FragmentTvBinding
import com.wahidabd.bajpsubmission1.model.DataEntity
import com.wahidabd.bajpsubmission1.ui.detail.DetailActivity
import com.wahidabd.bajpsubmission1.ui.home.HomeViewModel


class TvFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentTvBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        val tv = viewModel.getAllTv()

        val adapter = MovieAdapter()
        adapter.setData(tv)

        with(binding.rvTvShow){
            setHasFixedSize(true)
            this.adapter = adapter
            layoutManager = GridLayoutManager(context, 2)
        }

        adapter.setOnItemClick(object : MovieAdapter.OnItemClick {
            override fun onItemClicked(data: DataEntity) {
                startActivity(
                        Intent(activity, DetailActivity::class.java)
                                .putExtra(DetailActivity.EXTRA_ID, data.id)
                                .putExtra(DetailActivity.EXTRA_TYPE, TV_TYPE)
                )
            }
        })
    }
}