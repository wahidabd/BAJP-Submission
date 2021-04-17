package com.wahidabd.bajpsubmission1.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wahidabd.bajpsubmission1.adapter.PagerAdapter
import com.wahidabd.bajpsubmission1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.title = ""
        supportActionBar?.elevation = 0f

        val pager = PagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = pager
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}