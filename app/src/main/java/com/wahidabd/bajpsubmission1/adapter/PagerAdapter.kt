package com.wahidabd.bajpsubmission1.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wahidabd.bajpsubmission1.R
import com.wahidabd.bajpsubmission1.ui.home.movie.MovieFragment
import com.wahidabd.bajpsubmission1.ui.home.tv.TvFragment

class PagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitle = intArrayOf(R.string.movie, R.string.tv_show)

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when(position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvFragment()
        }

        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(tabTitle[position])

}