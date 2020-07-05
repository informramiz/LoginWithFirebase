package github.informramiz.loginwithfirebase.ui.main

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


/**
 * Created by Ramiz Raja on 05/07/2020.
 */
class FirebaseAuthLiveData : LiveData<FirebaseUser?>() {
    private val authListener = FirebaseAuth.AuthStateListener {
        value = it.currentUser
    }

    override fun onActive() {
        super.onActive()
        FirebaseAuth.getInstance().addAuthStateListener(authListener)
    }

    override fun onInactive() {
        super.onInactive()
        FirebaseAuth.getInstance().removeAuthStateListener(authListener)
    }
}