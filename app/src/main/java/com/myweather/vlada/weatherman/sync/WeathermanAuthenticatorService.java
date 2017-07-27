package com.myweather.vlada.weatherman.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class WeathermanAuthenticatorService extends Service {

    private WeathermanAuthenticator mAuthenticator;

    @Override
    public void onCreate() {

        mAuthenticator = new WeathermanAuthenticator(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
