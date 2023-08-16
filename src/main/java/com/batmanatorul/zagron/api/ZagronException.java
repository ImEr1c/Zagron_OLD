package com.batmanatorul.zagron.api;

public class ZagronException extends UnsupportedOperationException {
    public ZagronException() {
        super("Error: You don't have the plugin Zagron installed");
    }
}
