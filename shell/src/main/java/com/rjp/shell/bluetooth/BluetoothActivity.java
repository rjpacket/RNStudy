package com.rjp.shell.bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.rjp.permissionutils.Action;
import com.rjp.permissionutils.PermissionUtils;
import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BluetoothActivity extends BaseActivity {

    private BluetoothAdapter mAdapter;
    private ArrayList<BluetoothDevice> devices;
    private BluetoothBroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    @Override
    protected void initView() {
        mAdapter = BluetoothAdapter.getDefaultAdapter();
        devices = new ArrayList<>();

        findViewById(R.id.btn_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_view);
        CommonAdapter<BluetoothDevice> bluetoothAdapter = new CommonAdapter<BluetoothDevice>(mContext, R.layout.item_bluetooth, devices) {
            @Override
            protected void convert(ViewHolder viewHolder, BluetoothDevice item, int position) {
                viewHolder.setText(R.id.tv_name, item.getName() + "\n" + item.getAddress());
            }
        };
        listView.setAdapter(bluetoothAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BluetoothDevice device = devices.get(position);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    boolean bond = device.createBond();
                    Log.d("-------->", "配对成功");
                    if(bond){
                        connect(device);
                    }
                }
            }
        });

        mReceiver = new BluetoothBroadcastReceiver(devices, bluetoothAdapter);
        // 注册BroadcastReceiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mReceiver, filter);
    }

    final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private void connect(BluetoothDevice dev) {
        UUID uuid = UUID.fromString(SPP_UUID);
        try {
            BluetoothSocket socket = dev.createRfcommSocketToServiceRecord(uuid);
            socket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void requestPermission() {
        PermissionUtils
                .with(this)
                .permission(new String[]{Manifest.permission.BLUETOOTH,
                        Manifest.permission.BLUETOOTH_ADMIN,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                })
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        scanBluetooth();
                    }
                })
                .start();
    }

    public void scanBluetooth() {
        if (mAdapter == null) {
            // 设备不支持蓝牙
            return;
        }
        // 打开蓝牙
        if (!mAdapter.isEnabled()) {
            mAdapter.enable();
            mAdapter.cancelDiscovery();
        }
        // 寻找蓝牙设备，android会将查找到的设备以广播形式发出去
        while (!mAdapter.startDiscovery()) {
            Log.e("BlueTooth", "尝试失败");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
