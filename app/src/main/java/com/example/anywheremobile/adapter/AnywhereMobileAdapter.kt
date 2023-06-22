package com.example.anywheremobile.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.anywheremobile.CharacterDetails
import com.example.anywheremobile.R
import com.example.anywheremobile.databinding.CharacterCardBinding
import com.example.anywheremobile.model.CharacterResponse
import com.example.anywheremobile.model.Details
import com.example.anywheremobile.model.RelatedTopic

class AnywhereMobileAdapter(private val context: Context):
    RecyclerView.Adapter<AnywhereMobileAdapter.AnywhereMobileViewHolder>(){

    private var mList = listOf<RelatedTopic>()

    fun setData(mList: List<RelatedTopic>){
        this.mList = mList
        notifyDataSetChanged()
    }

    class AnywhereMobileViewHolder(var binding: CharacterCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnywhereMobileViewHolder {
        val binding = CharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnywhereMobileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: AnywhereMobileViewHolder, position: Int) {
        holder.binding.apply {
            characterName.text = mList[position].text?.substringBefore("-") ?: ""
            characterName.setOnClickListener() {
                Intent(context, CharacterDetails::class.java).apply {
                    putExtra(
                        "image", if (!mList[position].icon?.url.isNullOrEmpty()) {
                            "https://duckduckgo.com" + mList[position].icon?.url
                        } else {
                            null
                        }
                    )
                    putExtra("title", characterName.text)
                    putExtra("desc", mList[position].text?.substringAfter("-")?.trim())

                }.also {
                    ContextCompat.startActivity(context, it, null)
                }
            }
        }
    }
}