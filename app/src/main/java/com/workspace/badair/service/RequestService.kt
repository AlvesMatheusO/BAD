package com.workspace.badairdetector.service

import com.workspace.badair.models.Cities
import retrofit2.Call
import retrofit2.http.GET

interface RequestService {
    @GET("v2/nearest_city?key=380c823c-8859-425b-9541-619c98911f3b")
    fun listCity(): Call<Cities>
}