package com.example.anywheremobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CharacterDetails : AppCompatActivity() {

    private lateinit var characterImage: ImageView
    private lateinit var characterTitle: TextView
    private lateinit var characterDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_details)

        characterImage = findViewById(R.id.character_image)
        characterTitle = findViewById(R.id.character_title)
        characterDesc = findViewById(R.id.character_desc)

        val bundle = intent.extras
        val image = bundle?.getString("image")
        val title = bundle?.getString("title")
        val desc = bundle?.getString("desc")

        characterTitle.text = title
        characterDesc.text = desc

        if(image == ""){
            Glide.with(this).load(R.drawable.ic_android_black_24dp).into(characterImage)
        } else {
            Glide.with(this).load(image).into(characterImage)
        }

    }
}