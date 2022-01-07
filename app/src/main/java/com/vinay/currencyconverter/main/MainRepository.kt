package com.vinay.currencyconverter.main

import com.vinay.currencyconverter.data.models.CurrencyResponse
import com.vinay.currencyconverter.util.Resource

interface MainRepository {

    suspend fun getRates(base: String): Resource<CurrencyResponse>
}