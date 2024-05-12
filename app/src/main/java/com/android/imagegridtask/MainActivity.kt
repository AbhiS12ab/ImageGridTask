    package com.android.imagegridtask

    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.widget.Toast
    import androidx.recyclerview.widget.GridLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.android.imagegridtask.adapter.MediaCoverageAdapter
    import com.android.imagegridtask.data.MediaCoverage
    import com.google.gson.Gson
    import com.google.gson.reflect.TypeToken
    import kotlinx.coroutines.CoroutineScope
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.launch
    import kotlinx.coroutines.withContext
    import okhttp3.OkHttpClient
    import okhttp3.Request
    import okio.IOException

    class MainActivity : AppCompatActivity() {
        private lateinit var recyclerView: RecyclerView
        private lateinit var adapter: MediaCoverageAdapter
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = GridLayoutManager(this, 3)
            adapter = MediaCoverageAdapter()
            recyclerView.adapter = adapter

            fetchDataFromApi()
        }


        private fun fetchDataFromApi() {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = getApiResponse()
                    withContext(Dispatchers.Main) {
                        adapter.setData(response)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    // Handle error gracefully
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@MainActivity, "Failed to fetch data${e.message}", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }

        private fun getApiResponse(): List<MediaCoverage> {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://acharyaprashant.org/api/v2/content/misc/media-coverages?limit=100")
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val body = response.body?.string() ?: throw IOException("Response body is null")
            val listType = object : TypeToken<List<MediaCoverage>>() {}.type
            return Gson().fromJson(body, listType)
        }
    }