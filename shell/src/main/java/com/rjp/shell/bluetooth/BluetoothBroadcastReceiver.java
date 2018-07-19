package com.rjp.shell.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * author : Gimpo create on 2018/4/16 18:46
 * email  : jimbo922@163.com
 */
public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    BluetoothCallback callback;

    public BluetoothBroadcastReceiver(BluetoothCallback callback){
        this.callback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            callback.findDevice(device);
        }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
            callback.discoveryFinished();
        }else if(BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)){
            BluetoothDevice device = intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int bondState = device.getBondState();
            callback.bondStateChange(bondState);
        }
    }
}
