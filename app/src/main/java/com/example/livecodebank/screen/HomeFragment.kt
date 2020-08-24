package com.example.livecodebank.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.livecodebank.R
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transferButton.setOnClickListener(this)
        historyButton.setOnClickListener(this)
        callButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            transferButton -> {
                Navigation.findNavController(v)
                    .navigate(R.id.action_homeFragment_to_inputRecipientFragment)
            }
            historyButton -> {
                Navigation.findNavController(v)
                    .navigate(R.id.action_homeFragment_to_transferHistoryFragment)
            }

        }
    }
}