@file:Suppress("DEPRECATION")

package com.wahidabd.bajpsubmussion3.ui.favorite.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.wahidabd.bajpsubmussion3.R
import com.wahidabd.bajpsubmussion3.ui.favorite.movie.FavoriteMovieFragment
import com.wahidabd.bajpsubmussion3.ui.favorite.tv.FavoriteTvFragment

class FavoritePagerAdapter(private val context: Context,  fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitle = intArrayOf(R.string.movie, R.string.tv_show)

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when(position){
            0 -> fragment = FavoriteMovieFragment()
            1 -> fragment = FavoriteTvFragment()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(tabTitle[position])
}