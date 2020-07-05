package github.informramiz.loginwithfirebase.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import github.informramiz.loginwithfirebase.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var viewBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return MainFragmentBinding.inflate(inflater, container,false).also { viewBinding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        viewBinding.viewModel = viewModel
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.navigateToLogin.observe(viewLifecycleOwner, Observer {
            if (it.getContentIfNotHandled() == true) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
            }
        })
    }
}