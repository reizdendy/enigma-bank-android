package com.example.livecodebank.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livecodebank.R
import com.example.livecodebank.domain.transaction.TransactionViewModel
import com.example.livecodebank.domain.transaction.adapter.TransactionHistoryRecycleAdapter
import kotlinx.android.synthetic.main.fragment_transfer_history.*

/**
 * A simple [Fragment] subclass.
 * Use the [TransferHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransferHistoryFragment : Fragment() {

    val transactionViewModel by activityViewModels<TransactionViewModel>()
    lateinit var transactionHistoryRecycleAdapter: TransactionHistoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transfer_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transferHistoryRecycleView.layoutManager = LinearLayoutManager(this.context)

        transactionViewModel.allTransaction.observe(viewLifecycleOwner, Observer {
            transactionHistoryRecycleAdapter = TransactionHistoryRecycleAdapter(it)
            transferHistoryRecycleView.adapter = transactionHistoryRecycleAdapter
        })
        transactionViewModel.getAllTransaction()
    }

}