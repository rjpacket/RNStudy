package com.rjp.shell.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.zhy.adapter.abslistview.CommonAdapter;

import java.util.List;

/**
 * author : Gimpo create on 2018/4/16 18:46
 * email  : jimbo922@163.com
 */
public class BluetoothBroadcastReceiver extends BroadcastReceiver {
    List<BluetoothDevice> devices;
    CommonAdapter<BluetoothDevice> bluetoothAdapter;

    public BluetoothBroadcastReceiver(List<BluetoothDevice> devices, CommonAdapter<BluetoothDevice> bluetoothAdapter){
        this.devices = devices;
        this.bluetoothAdapter = bluetoothAdapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        // 发现设备
        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            // 从Intent中获取设备对象
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            // 将设备名称和地址放入array adapter，以便在ListView中显示
            devices.add(device);
            bluetoothAdapter.notifyDataSetChanged();
            Log.d("-------->", "扫描到:" + devices.size() + "个设备");
        }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
            Log.d("-------->", "扫描完成");
        }else if(BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)){
            Log.d("-------->", "配对状态:" + action);
            BluetoothDevice device = intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int bondState = device.getBondState();
            if(bondState == BluetoothDevice.BOND_BONDED){
                Log.d("-------->", "配对成功");
            }else if(bondState == BluetoothDevice.BOND_BONDING){
                Log.d("-------->", "正在配对");
            }else if(bondState == BluetoothDevice.BOND_NONE){
                Log.d("-------->", "正在配对");
            }
        }
    }
}
