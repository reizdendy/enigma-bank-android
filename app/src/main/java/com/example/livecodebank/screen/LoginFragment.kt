package com.example.livecodebank.screen

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.livecodebank.R
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener{
            val username = inputUsername.text.toString()
            val password = inputPassword.text.toString()
            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(activity, "Input Username and Password!", Toast.LENGTH_SHORT).show()
            } else if(username == "reizdendy" && password == "admin01"){
               Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                Toast.makeText(activity, "Username or Password doesnt exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}