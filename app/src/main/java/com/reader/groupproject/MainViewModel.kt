package com.reader.groupproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof.rssparser.Article
import com.prof.rssparser.Parser
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    private val url = "https://www.telefonino.net/feed/"

    val articleList = MutableLiveData<List<Article>>()

    init {
        viewModelScope.launch {
            getFeeds(url)
        }

    }

    suspend fun getFeeds(url: String) {

        try {
            val parser = Parser()
            articleList.value = parser.getArticles(url)
            // The list contains all article's data. For example you can use it for your adapter.
            Log.i("feeds", "${articleList.value}")
        } catch (e: Exception) {
            Log.i("feeds", "error $e")
        }
    }
}
