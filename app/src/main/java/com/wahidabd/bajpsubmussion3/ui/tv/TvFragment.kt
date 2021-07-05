package com.wahidabd.bajpsubmussion3.ui.tv

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.wahidabd.bajpsubmussion3.databinding.FragmentTvBinding
import com.wahidabd.bajpsubmussion3.models.tv.DataTv
import com.wahidabd.bajpsubmussion3.ui.detail.tv.DetailTvActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvFragment : Fragment() {

    private lateinit var binding: FragmentTvBinding
    private lateinit var adapter: TvAdapter
    private val viewModel: TvViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TvAdapter()
        with(binding){
            rvTvShow.layoutManager = GridLayoutManager(requireContext(), 2)
            rvTvShow.adapter = adapter

            viewModel.getTv().observe(viewLifecycleOwner, {
                progress.visibility = GONE
                adapter.setList(it)
                adapter.setOnItemClickCallback(object : TvAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: DataTv) {
                        startActivity(Intent(requireContext(), DetailTvActivity::class.java)
                            .putExtra(DetailTvActivity.EXTRA_ID, data.id))
                    }
                })
            })
        }

    }
}