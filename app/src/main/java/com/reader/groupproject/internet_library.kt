package com.reader.groupproject

import android.util.Log
import okhttp3.*
import java.io.IOException

class internet_library{
    interface ResultReceiver {
        fun onResult(status: String?)
        fun onError(error :Throwable)
    }

    fun return_file(url: String, callback:ResultReceiver){
        val client = OkHttpClient()
        try {
            val request = Request.Builder().url(url).build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("APP", "error: $e")
                    callback.onError(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    if(response.isSuccessful){
                        try{
                            val resp = response.body?.string()
                            callback.onResult(resp)

                        }catch (e: Exception){
                            Log.e("APP", "error: $e")
                            callback.onError(e)
                        }
                    }
                }
            })
        }

        catch(e: java.lang.Exception) {
            callback.onError(e)
        }
    }
}