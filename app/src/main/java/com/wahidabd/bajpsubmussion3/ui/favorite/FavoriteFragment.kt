package com.wahidabd.bajpsubmussion3.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wahidabd.bajpsubmussion3.databinding.FragmentFavoriteBinding
import com.wahidabd.bajpsubmussion3.ui.favorite.adapter.FavoritePagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pager = FavoritePagerAdapter(requireActivity(), childFragmentManager)
        binding.viewPager.adapter = pager
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}