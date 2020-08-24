package com.example.livecodebank.domain.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.livecodebank.config.RetrofitBuilder

class TransactionViewModel :ViewModel(){

    val transactionRepository: TransactionRepository

    init {
        val transactionAPI = RetrofitBuilder.createRetrofit().create(TransactionAPI::class.java)
        transactionRepository = TransactionRepository(transactionAPI)
    }

    val transaction: LiveData<Transaction> = transactionRepository.transaction
    val allTransaction: LiveData<List<Transaction>> = transactionRepository.allTransaction

    fun getAllTransaction(id: String){
        transactionRepository.getAllTransaction(id)
    }

    fun saveTransaction(transaction: Transaction) {
        transactionRepository.saveTransaction(transaction)
    }
}