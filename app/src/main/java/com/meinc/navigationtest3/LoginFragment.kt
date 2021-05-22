package com.meinc.navigationtest3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.meinc.navigationtest3.databinding.FragmentLoginBinding
import com.meinc.navigationtest3.databinding.FragmentWelcomeBinding

class LoginFragment: Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val args: LoginFragmentArgs by navArgs()

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

        val usernameDeepLink= args.username
        //use setText() instead of the .text function here. Otherwise you'll get a mismatch
        binding.editTextUsername.setText(usernameDeepLink)

        binding.buttonConfirm.setOnClickListener {
            val username= binding.editTextUsername.text.toString()
            val password= binding.editTextPassword.text.toString()
            val action= LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(action)
        }
    }
}