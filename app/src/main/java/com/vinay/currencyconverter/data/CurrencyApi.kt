package com.vinay.currencyconverter.data

import com.vinay.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/latest")
    suspend fun getRates(
        @Query("base") base: String,
        @Query("access_key") apiKey: String
    ): Response<CurrencyResponse>
}