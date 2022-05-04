package com.example.bugsnag.android

import android.app.Application
import com.bugsnag.android.Bugsnag
import com.bugsnag.android.Configuration
import com.example.bugsnag.android.issues.addOnSendIssue1
import com.example.bugsnag.android.issues.addOnSendIssue2
import com.example.bugsnag.android.issues.issue1
import com.example.bugsnag.android.issues.issue2

class ExampleApplication : Application() {

    companion object {
        init {
            System.loadLibrary("entrypoint")
        }
    }

    private external fun performNativeBugsnagSetup()

    override fun onCreate() {
        super.onCreate()

        val config = Configuration.load(this)
        config.setUser("123456", "joebloggs@example.com", "Joe Bloggs")
        config.addMetadata("user", "age", 31)

        config.addOnSendIssue1()
        config.addOnSendIssue2()
        Bugsnag.start(this, config)

        performNativeBugsnagSetup()

        issue2()
        issue1()
    }
}
