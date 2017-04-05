package com.rngows;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.Map;
import goWS.GoWS;

public class GoModule extends ReactContextBaseJavaModule {

    @ReactMethod
    public void sayHello(Callback success){
        final ReactApplicationContext context = this.getReactApplicationContext();
        success.invoke(GoWS.helloWorld(new goWS.EventBus() {
            @Override
            public void sendEvent(String channel, String message) {
                Log.i(channel, message);
                context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit(channel, message);
            }
        }));
    }
    @Override
    public String getName(){
        return "Go";
    }

    public GoModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }
}