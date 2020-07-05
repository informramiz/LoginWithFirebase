package github.informramiz.loginwithfirebase

import android.app.Application
import timber.log.Timber


/**
 * Created by Ramiz Raja on 05/07/2020.
 */
class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}