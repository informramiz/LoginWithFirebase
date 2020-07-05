package github.informramiz.loginwithfirebase.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import github.informramiz.loginwithfirebase.ui.utils.Event

class MainViewModel : ViewModel() {
    private val _navigateToLogin = MutableLiveData<Event<Boolean>>()
    val navigateToLogin: LiveData<Event<Boolean>>
        get() = _navigateToLogin

    fun onLoginButtonClick() {
        _navigateToLogin.value = Event(true)
    }
}