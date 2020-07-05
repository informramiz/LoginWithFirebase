package github.informramiz.loginwithfirebase.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import github.informramiz.loginwithfirebase.utils.Event

class MainViewModel : ViewModel() {
    private val _navigateToLogin = MutableLiveData<Event<Boolean>>()
    val navigateToLogin: LiveData<Event<Boolean>>
        get() = _navigateToLogin

    private val firebaseAuthListener = FirebaseAuthLiveData()
    val authenticationState: LiveData<AuthenticationState> = firebaseAuthListener.map {
        if (it != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }

    fun onLoginLogoutButtonClick() {
        _navigateToLogin.value = Event(true)
    }

    enum class AuthenticationState {
        UNAUTHENTICATED,
        AUTHENTICATED,
    }
}