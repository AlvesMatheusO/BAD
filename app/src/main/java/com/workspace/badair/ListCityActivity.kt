package com.workspace.badairdetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.workspace.badair.R
import com.workspace.badair.models.Cities
import com.workspace.badair.adapters.CityListAdapter
import com.workspace.badairdetector.service.RequestService
import kotlinx.android.synthetic.main.activity_city.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)


        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.airvisual.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val requestService = retrofit.create((RequestService::class.java))

        requestService.listCity().enqueue(object : Callback<Cities> {
            override fun onFailure(call: Call<Cities>, t: Throwable) {
                Toast.makeText(this@ListCityActivity, t.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<Cities>, response: Response<Cities>) {
                showData(response.body()!!)
            }


        })

    }

    private fun showData(cities: Cities) {

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListCityActivity)

            adapter = CityListAdapter(cities)
        }
    }

}
