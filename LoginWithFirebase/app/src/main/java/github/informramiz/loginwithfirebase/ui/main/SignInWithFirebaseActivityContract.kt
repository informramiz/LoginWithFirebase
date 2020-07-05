package github.informramiz.loginwithfirebase.ui.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import github.informramiz.loginwithfirebase.ui.utils.OperationResponse


/**
 * Created by Ramiz Raja on 05/07/2020.
 */
class SignInWithFirebaseActivityContract : ActivityResultContract<Void?, OperationResponse<FirebaseUser>>() {
    override fun createIntent(context: Context, input: Void?): Intent {
        //sign-in providers we want to support
        val providers = listOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        return AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
    }

    override fun parseResult(resultCode: Int, intent: Intent?): OperationResponse<FirebaseUser> {
        val response = IdpResponse.fromResultIntent(intent)
        val user = FirebaseAuth.getInstance().currentUser
        return if (resultCode != Activity.RESULT_OK || user == null) {
            OperationResponse.Error(response?.error ?: Exception("Login failed due to unknown reason"))
        } else {
            OperationResponse.Success(user)
        }
    }

}