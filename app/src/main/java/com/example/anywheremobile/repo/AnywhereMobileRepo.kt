package com.example.anywheremobile.repo

import com.example.anywheremobile.BuildConfig
import com.example.anywheremobile.api.AnywhereMobileAPI
import com.example.anywheremobile.model.CharacterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnywhereMobileRepo {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: AnywhereMobileAPI = retrofit.create(AnywhereMobileAPI::class.java)

    suspend fun getCharacterList():Response<CharacterResponse>{
        return api.getCharacterList()
    }
}