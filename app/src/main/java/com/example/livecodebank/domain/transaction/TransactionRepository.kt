package com.example.livecodebank.domain.transaction

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository(val transactionAPI: TransactionAPI) {
    var transaction: MutableLiveData<Transaction> = MutableLiveData<Transaction>()
    var allTransaction : MutableLiveData<List<Transaction>> = MutableLiveData<List<Transaction>>()

    fun getAllTransaction(id:String){
        transactionAPI.getAllTransaction(id).enqueue(object : Callback<List<Transaction>> {
            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                println("Failed Because ${t.localizedMessage}")
                println("${t.printStackTrace()}")
            }

            override fun onResponse(call: Call<List<Transaction>>, response: Response<List<Transaction>>) {
                val response = response.body()
                val gson = Gson()
                val stringResponse = gson.toJson(response)
                val transactionObject:List<Transaction> = gson.fromJson(stringResponse,Array<Transaction>::class.java).toList()
                allTransaction.value = transactionObject
            }
        })
    }

    fun saveTransaction(transaction: Transaction) {
        transactionAPI.createTransaction(transaction).enqueue(object : Callback<Transaction> {
            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                if (response.code() == 200) {
                    println("SUCCESS")
                }
            }

            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                t.printStackTrace()
                println("Failed Created Film Because  ${t.localizedMessage}")
            }

        })
    }
}