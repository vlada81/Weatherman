package com.myweather.vlada.weatherman.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class WeathermanSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static WeathermanSyncAdapter sWeathermanSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("WeathermanSyncService", "onCreate - WeathermanSyncService");
        synchronized (sSyncAdapterLock) {
            if (sWeathermanSyncAdapter == null) {
                sWeathermanSyncAdapter = new WeathermanSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sWeathermanSyncAdapter.getSyncAdapterBinder();
    }
}
