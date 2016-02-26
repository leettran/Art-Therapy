package com.ngaini.arttherpy;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.widget.Toast;

/**
 * Created by Nathan on 2/25/2016.
 */
public class BroadcastThis extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
//        boolean isScreenOn = powerManager.isScreenOn();
        KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);
        if (keyguardManager.inKeyguardRestrictedInputMode())
        {
//
//            //phone was unlocked, do stuff here
//
        }
        else
        {
            Toast.makeText(context, "Broadcast Reciever working", Toast.LENGTH_SHORT).show();

        }
    }
}
