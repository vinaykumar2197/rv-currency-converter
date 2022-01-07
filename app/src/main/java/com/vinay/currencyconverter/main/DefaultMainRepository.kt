package com.vinay.currencyconverter.main

import com.vinay.currencyconverter.data.CurrencyApi
import com.vinay.currencyconverter.data.models.CurrencyResponse
import com.vinay.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base,"e689b677d259fe334d5c35a6259da8d6")
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }
}