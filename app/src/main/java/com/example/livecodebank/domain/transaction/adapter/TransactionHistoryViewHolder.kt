package com.example.livecodebank.domain.transaction.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.livecodebank.R

class TransactionHistoryViewHolder (v: View) : RecyclerView.ViewHolder(v) {

    var dateTransaction: TextView = v.findViewById(R.id.date_recycle)
    var amountTransaction: TextView = v.findViewById(R.id.amount_recycle)
}