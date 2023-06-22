package com.example.anywheremobile

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.example.anywheremobile.adapter.AnywhereMobileAdapter
import com.example.anywheremobile.databinding.ActivityMainBinding
import com.example.anywheremobile.model.RelatedTopic
import com.example.anywheremobile.viewmodel.AnywhereMobileViewModel

class MainActivity : AppCompatActivity() {

    private val mViewModel: AnywhereMobileViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val mAdapter: AnywhereMobileAdapter by lazy {
        AnywhereMobileAdapter(this)
    }

    private var mList = ArrayList<RelatedTopic>()

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

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })

    }

    private fun filterList(newText: String?) {
        if (newText != null){
            val filterList = ArrayList<RelatedTopic>()
            for (i in mViewModel.anywhereMobileMutableLiveData.value!!){
                if (i.text.lowercase().contains(newText)){
                    mAdapter.setData(mViewModel.filterList(newText))
                }
            }
            if (filterList.isEmpty()){
                Toast.makeText(this, "No Data Found", Toast.LENGTH_LONG).show()
            } else {
                mAdapter.setData(filterList)
            }
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        binding.mainRecycler.adapter = mAdapter
    }

}