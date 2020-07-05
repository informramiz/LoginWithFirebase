package github.informramiz.loginwithfirebase.ui.utils


/**
 * Created by Ramiz Raja on 05/07/2020.
 */
open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent() = content
}