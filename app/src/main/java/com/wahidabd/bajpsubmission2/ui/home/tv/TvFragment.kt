@file:Suppress("DEPRECATION")

package com.wahidabd.bajpsubmission2.ui.home.tv

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmission2.adapter.TvAdapter
import com.wahidabd.bajpsubmission2.databinding.FragmentTvBinding
import com.wahidabd.bajpsubmission2.model.DataList
import com.wahidabd.bajpsubmission2.ui.detail.DetailActivity
import com.wahidabd.bajpsubmission2.utils.Helper.TV_TYPE
import com.wahidabd.bajpsubmission2.utils.ViewModelFactory
import com.wahidabd.bajpsubmission2.utils.progressBar


class TvFragment : Fragment() {

    private val viewModel by lazy {
        val factory = ViewModelFactory.getInstance()
        ViewModelProviders.of(this, factory)[TvViewModel::class.java]
    }

    private lateinit var binding: FragmentTvBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar(true, binding.progress)

        val adapter = TvAdapter(context)
        viewModel.getTv().observe(viewLifecycleOwner, {
            adapter.setData(it)
            progressBar(false, binding.progress)
        })

        with(binding.rvTvShow){
            layoutManager = GridLayoutManager(context, 2)
            this.adapter = adapter
        }

        adapter.setOnItemClick(object : TvAdapter.OnItemClick{
            override fun onItemClicked(data: DataList) {
                startActivity(Intent(
                    activity, DetailActivity::class.java)
                    .putExtra(DetailActivity.EXTRA_TYPE, TV_TYPE)
                    .putExtra(DetailActivity.EXTRA_ID, data.id.toString())
                )
            }
        })
    }
}