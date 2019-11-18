package com.reader.groupproject

import android.util.Log
import android.webkit.URLUtil
import androidx.lifecycle.ViewModel

class search_class : ViewModel() {
    fun search_fun(query: String) {
        if (URLUtil.isValidUrl(query)) {
            val net = internet_library()

            net.return_file(query, object :
                internet_library.ResultReceiver {
                override fun onResult(status: String?) {
                    update_text(status)
                }

                override fun onError(error: Throwable) {
                    Log.i("Error ", error.toString())
                }
            })

        } else {
            update_text("Not url")
        }
    }

    fun update_text(message: String?){
        viewModel.changeText(message.toString())
    }
}