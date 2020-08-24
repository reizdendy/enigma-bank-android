package com.example.livecodebank.screen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.livecodebank.R
import com.example.livecodebank.domain.transaction.Transaction
import com.example.livecodebank.domain.transaction.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_amount.*
import kotlinx.android.synthetic.main.fragment_input_recipient.*
import java.time.LocalDateTime

/**
 * A simple [Fragment] subclass.
 * Use the [InputAmountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputAmountFragment : Fragment(), View.OnClickListener{

    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        proccessAmountButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v){
            proccessAmountButton -> {

                val amount = inputAmount.text.toString()
//                val desc = inputDescription.text.toString()

                transactionViewModel.saveTransaction(Transaction(userID = "1" , nominal = amount))

                Navigation.findNavController(v).navigate(R.id.action_inputAmountFragment_to_confirmationFragment)}
        }
    }
}