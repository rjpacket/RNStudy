package com.rjp.shell.bluetooth;

import android.bluetooth.BluetoothDevice;

/**
 * author : Gimpo create on 2018/4/17 12:05
 * email  : jimbo922@163.com
 */
public interface BluetoothCallback {
    void findDevice(BluetoothDevice device);

    void discoveryFinished();

    void bondStateChange(int bondState);
}
