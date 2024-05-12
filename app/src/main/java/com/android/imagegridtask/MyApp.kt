package com.android.imagegridtask

import android.app.Application
import com.android.imagegridtask.Const.DISK_CACHE_SIZE
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Configure disk cache
        val cacheDir = File(cacheDir, "picasso-cache")
        val cache = Cache(cacheDir, DISK_CACHE_SIZE)

        val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .build()

        val picasso = Picasso.Builder(this)
            .downloader(OkHttp3Downloader(okHttpClient))
            .build()

        Picasso.setSingletonInstance(picasso)
    }
}