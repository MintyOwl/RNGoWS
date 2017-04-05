package com.rngows;

import com.facebook.react.ReactActivity;

import android.content.ContextWrapper;


import goWS.GoWS;
import java.io.File;

public class MainActivity extends ReactActivity {
 @Override
    protected void onResume() {
        super.onResume();
        File dir = new ContextWrapper(this).getFilesDir();
        GoWS.writeFile(dir.getAbsolutePath());;
        GoWS.startListening();

    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "RNGoWS";
    }
}
