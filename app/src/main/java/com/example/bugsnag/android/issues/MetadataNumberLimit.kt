package com.example.bugsnag.android.issues

import com.bugsnag.android.Bugsnag
import com.bugsnag.android.Configuration

private const val TEST_TAB = "Test Tab"

fun Configuration.addOnSendIssue1() {
    addOnSend { event ->
        println("Metadata remainingSize: ${event.getMetadata(TEST_TAB)?.size}")
        true
    }
}

fun issue1() {
    for (i in 1..160) {
        Bugsnag.addMetadata(TEST_TAB, generateRandomKey(), generateRandomValue())
    }
    println("Metadata originalSize: ${Bugsnag.getMetadata(TEST_TAB)?.size}")
}

private fun generateRandomKey() = generateRandomString(length = 15)
private fun generateRandomValue() = generateRandomString(length = 7)