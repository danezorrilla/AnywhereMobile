package com.example.anywheremobile

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.activity.viewModels
import com.example.anywheremobile.adapter.AnywhereMobileAdapter
import com.example.anywheremobile.databinding.ActivityMainBinding
import com.example.anywheremobile.viewmodel.AnywhereMobileViewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: AnywhereMobileViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    private val mAdapter: AnywhereMobileAdapter by lazy {
        AnywhereMobileAdapter(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val snapper = LinearSnapHelper()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mainRecycler.adapter = mAdapter
        snapper.attachToRecyclerView(binding.mainRecycler)
        mViewModel.anywhereMobileMutableLiveData.observe(this) {
            mAdapter.setData(it ?: listOf())
        }

        mViewModel.loadResponse()

        binding.filterText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                if (binding.filterText.text.trim().isNotEmpty())
                    mAdapter.setData(mViewModel.filterList(binding.filterText.text.trim().toString()))
                else
                    mViewModel.anywhereMobileMutableLiveData.value?.let {
                        mAdapter.setData(it) }  ?: mAdapter.setData(
                        listOf()
                    )
                true
            } else {
                false
            }
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        binding.mainRecycler.adapter = mAdapter
    }

}