package com.example.anywheremobile.api

import com.example.anywheremobile.BuildConfig
import com.example.anywheremobile.model.CharacterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnywhereMobileAPI {

    // http://api.duckduckgo.com/?q=simpsons+characters&format=json

    @GET(BuildConfig.END_POINT)
    suspend fun getCharacterList():
            Response<CharacterResponse>
}