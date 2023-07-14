package com.ndzl.cap.echo;

import android.util.Log;

import java.lang.*;
import java.io.*;
import java.util.*;
public class EchoPlugin {

    public String echo(String value) {
        //Log.i("Echo", value);
        return "<"+value+">";
    }


    public String mirror(String value) {
        //Log.i("mirror", value);
        StringBuilder sb = new StringBuilder(value);
        return sb.reverse().toString();
    }
}
