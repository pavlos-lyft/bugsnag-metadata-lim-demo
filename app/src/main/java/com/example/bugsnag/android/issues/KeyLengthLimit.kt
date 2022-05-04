package com.example.bugsnag.android.issues

import com.bugsnag.android.Bugsnag
import com.bugsnag.android.Configuration

private const val KEY_LIMIT_TEST_TAB = "Key Limit Test Tab"

fun Configuration.addOnSendIssue2() {
    addOnSend { event ->
        val (key, value) = event.getMetadata(KEY_LIMIT_TEST_TAB)!!.entries.first()
        println("Metadata keySize ${key.length} | valueSize: ${value.toString().length}")
        true
    }
}

fun issue2() {
    Bugsnag.addMetadata(KEY_LIMIT_TEST_TAB, generateRandomString(1000), generateRandomString(1000))
}