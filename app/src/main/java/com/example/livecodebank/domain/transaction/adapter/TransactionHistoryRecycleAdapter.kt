package com.example.livecodebank.domain.transaction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livecodebank.R
import com.example.livecodebank.domain.transaction.Transaction

class TransactionHistoryRecycleAdapter (private val transactionList: List<Transaction>) :
    RecyclerView.Adapter<TransactionHistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_transfer_recycle_layout, parent, false)
        return TransactionHistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        holder.dateTransaction.text = transactionList[position].trans_date
        holder.amountTransaction.text = "$" + transactionList[position].amount
    }

}