package github.informramiz.loginwithfirebase.ui.main

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter
import github.informramiz.loginwithfirebase.R


/**
 * Created by Ramiz Raja on 05/07/2020.
 */
@BindingAdapter("authenticationState")
fun TextView.setAuthenticationState(authenticationState: MainViewModel.AuthenticationState?) {
    val msgResId = if (authenticationState == MainViewModel.AuthenticationState.AUTHENTICATED) {
        R.string.main_fragment_welcome_msg_logged_in
    } else {
        R.string.main_fragment_welcome_msg_not_logged_in
    }
    text = context.getText(msgResId)
}

@BindingAdapter("authenticationState")
fun Button.setAuthenticationState(authenticationState: MainViewModel.AuthenticationState?) {
    val msgResId = if (authenticationState == MainViewModel.AuthenticationState.AUTHENTICATED) {
        R.string.main_fragment_logout_label
    } else {
        R.string.main_fragment_login_label
    }
    text = context.getText(msgResId)
}