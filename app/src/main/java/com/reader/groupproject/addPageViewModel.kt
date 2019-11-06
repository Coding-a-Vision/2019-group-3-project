package com.reader.groupproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class addPageViewModel: ViewModel() {
    var text = MutableLiveData<String>()

    init {
        text.value = ""
    }
}