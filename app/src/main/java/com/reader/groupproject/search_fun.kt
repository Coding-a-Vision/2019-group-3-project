package com.reader.groupproject

import android.webkit.URLUtil

class search_class{
    var text: String? = null
    var complete: Boolean = false

    fun search_fun(query: String) {
        this.complete = false
        if (URLUtil.isValidUrl(query)) {
            val net = internet_library()

            net.return_file(query, object :
                internet_library.ResultReceiver {
                override fun onResult(status: String?) {
                    update_text(status)
                }

                override fun onError(error: Throwable) {
                    update_text("Error " + error.toString())
                }
            })

        } else {
            update_text("Not url")
        }
    }

    fun update_text(Message: String?){
        text = Message
        this.complete = true
    }
}