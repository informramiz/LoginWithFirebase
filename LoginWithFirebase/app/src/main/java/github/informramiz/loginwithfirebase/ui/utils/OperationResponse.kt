package github.informramiz.loginwithfirebase.ui.utils

import java.lang.Exception


/**
 * Created by Ramiz Raja on 05/07/2020.
 */
sealed class OperationResponse<out T: Any> {
    data class Success<out T: Any>(val data: T) : OperationResponse<T>()
    data class Error(val error: Exception) : OperationResponse<Nothing>()
}

val <T> T.exhaustive: T
    get() = this