package com.example.lession11_;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ff on 2016/9/30.
 */
public class MyBootBroadcastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action=intent.getAction();
        if(Intent.ACTION_BOOT_COMPLETED.equals(action)){

            Log.i("mytest","开机完成");
            Intent intent1=new Intent(context,MyBootService.class);
                context.getApplicationContext().startService(intent1);

        }


    }
}
