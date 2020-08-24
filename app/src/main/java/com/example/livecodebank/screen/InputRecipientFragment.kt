package com.example.livecodebank.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.livecodebank.R
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_input_recipient.*

/**
 * A simple [Fragment] subclass.
 * Use the [InputRecipientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputRecipientFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        proccessRecipientButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v){
            proccessRecipientButton -> {
                val bundle = bundleOf("recipientName" to inputRecipient.text.toString(),
                "bankName" to inputBank.text.toString())
                Navigation.findNavController(v).navigate(R.id.action_inputRecipientFragment_to_inputAmountFragment, bundle)}
        }
    }
}