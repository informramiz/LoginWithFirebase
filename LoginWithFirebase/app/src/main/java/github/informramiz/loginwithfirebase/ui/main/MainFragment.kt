package github.informramiz.loginwithfirebase.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import github.informramiz.loginwithfirebase.databinding.MainFragmentBinding
import github.informramiz.loginwithfirebase.ui.activityresultcontracts.SignInWithFirebaseActivityContract
import github.informramiz.loginwithfirebase.utils.OperationResponse
import github.informramiz.loginwithfirebase.utils.exhaustive
import timber.log.Timber

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var viewBinding: MainFragmentBinding
    private val signInActivityLauncher = registerForActivityResult(
        SignInWithFirebaseActivityContract()
    ) { result ->
        when (result) {
            is OperationResponse.Success -> Timber.d("Login successful with user: ${result.data.displayName}")
            is OperationResponse.Error -> Timber.d("Login failed with error: ${result.error.localizedMessage}")
        }.exhaustive
    }

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
                signInActivityLauncher.launch()
            }
        })
    }
}