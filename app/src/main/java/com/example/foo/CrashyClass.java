package com.example.foo;

public class CrashyClass {

    public static RuntimeException crash(String msg) {
        return sendMessage(msg);
    }

    private static RuntimeException sendMessage(String msg) {
        return new RuntimeException(msg);
    }
}
