package com.example.anywheremobile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anywheremobile.model.RelatedTopic
import com.example.anywheremobile.repo.AnywhereMobileRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnywhereMobileViewModel: ViewModel() {

    private var anywhereMobileRepo = AnywhereMobileRepo()
    var anywhereMobileMutableLiveData =
        MutableLiveData<List<RelatedTopic>?>(listOf())

    fun loadResponse() {
        viewModelScope.launch(Dispatchers.IO) {
            anywhereMobileMutableLiveData.postValue(
                withContext(Dispatchers.Default) {
                    anywhereMobileRepo.getCharacterList().body()?.relatedTopics
                }
            )
        }
    }

    fun filterList(filter: String): List<RelatedTopic> {
        return anywhereMobileMutableLiveData.value?.filter {
            it.text?.contains(filter, true) ?: false
        } ?: listOf()
    }
}