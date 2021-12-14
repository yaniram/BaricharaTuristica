package com.yaniramonsalve.baricharaturismo.data

import com.yaniramonsalve.baricharaturismo.model.BaricharaItem
import retrofit2.http.GET

interface ApiSrvice {

    @GET("yaniram/BaricharaTuristica/barichara")
    suspend fun getBarichara(): BaricharaItem
}