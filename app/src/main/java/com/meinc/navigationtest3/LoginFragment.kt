package com.meinc.navigationtest3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.meinc.navigationtest3.databinding.FragmentLoginBinding
import com.meinc.navigationtest3.databinding.FragmentWelcomeBinding

class LoginFragment: Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonConfirm.setOnClickListener {
            val username= binding.editTextUsername.text.toString()
            val password= binding.editTextPassword.text.toString()
            val action= LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(action)
        }
    }
}