package com.reader.groupproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddPageViewModel: ViewModel() {
    var text = MutableLiveData<String>()

    init {
        text.value = ""
    }

    fun changeText(newText: String) {
        text.postValue(newText)
    }
}