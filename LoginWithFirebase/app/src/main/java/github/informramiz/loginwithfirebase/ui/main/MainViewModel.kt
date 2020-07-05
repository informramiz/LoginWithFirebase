package github.informramiz.loginwithfirebase.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.firebase.ui.auth.AuthUI
import github.informramiz.loginwithfirebase.utils.Event

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _startLoginFlow = MutableLiveData<Event<Boolean>>()
    val startLoginFlow: LiveData<Event<Boolean>>
        get() = _startLoginFlow

    private val firebaseAuthListener = FirebaseAuthLiveData()
    val authenticationState: LiveData<AuthenticationState> = firebaseAuthListener.map {
        if (it != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }

    fun onLoginLogoutButtonClick() {
        if (authenticationState.value == AuthenticationState.AUTHENTICATED) {
            logout()
        } else {
            _startLoginFlow.value = Event(true)
        }
    }

    private fun logout() {
        AuthUI.getInstance().signOut(getApplication())
    }

    enum class AuthenticationState {
        UNAUTHENTICATED,
        AUTHENTICATED,
    }
}