package com.example.livecodebank.domain.transaction

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TransactionAPI {
    @GET("transactions")
    fun getAllTransaction(): Call<List<Transaction>>

    @POST("transactions")
    fun createTransaction(@Body transaction: Transaction): Call<Transaction>

}