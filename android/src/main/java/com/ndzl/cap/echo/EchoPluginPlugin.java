package com.ndzl.cap.echo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "EchoPlugin")
public class EchoPluginPlugin extends Plugin {

    private EchoPlugin implementation = new EchoPlugin();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void mirror(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.mirror(value));
        call.resolve(ret);
    }

  @PluginMethod()
  public void openMap(PluginCall call) {
    Double latitude = call.getDouble("latitude");
    Double longitude = call.getDouble("longitude");

    // more logic

    call.resolve();
  }

    @Override
    protected void handleOnResume() {
        super.handleOnResume();
        registerIntentFilters();
    }

    void registerIntentFilters()    {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.ndzl.DW");
        filter.addCategory("android.intent.category.DEFAULT");
        getContext().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("com.ndzl.DW")) {

                    /*ZEBRA*/
                    String aimId = "N/A";
                    String charset = "N/A";
                    String codeId = intent.getStringExtra("com.symbol.datawedge.data_string");
                    String data = intent.getStringExtra("com.symbol.datawedge.data_string");
                    byte[] dataBytes = intent.getByteArrayExtra("dataBytes");
                    //String dataBytesStr = bytesToHexString(dataBytes);
                    long epoch_timestamp = intent.getLongExtra("com.symbol.datawedge.data_dispatch_time", -1 );

                    JSObject ret = new JSObject();
                    ret.put("value", data);
                    notifyListeners("dwBarcodeReading", ret);

                }
            }
        }, filter);
    }
}
