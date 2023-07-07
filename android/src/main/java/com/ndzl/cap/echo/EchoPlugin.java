package com.ndzl.cap.echo;

import android.util.Log;

public class EchoPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
