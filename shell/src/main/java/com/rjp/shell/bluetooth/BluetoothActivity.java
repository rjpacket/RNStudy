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
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.rjp.shell.bluetooth.PrintUtils.*;

public class BluetoothActivity extends BaseActivity implements BluetoothCallback {

    private BluetoothAdapter mAdapter;
    private ArrayList<BluetoothDevice> devices;
    private BluetoothBroadcastReceiver mReceiver;
    private CommonAdapter<BluetoothDevice> bluetoothAdapter;

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

        //扫描
        findViewById(R.id.btn_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });

        //打印
        findViewById(R.id.btn_print).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printDemo();
            }
        });

        ListView listView = (ListView) findViewById(R.id.list_view);
        bluetoothAdapter = new CommonAdapter<BluetoothDevice>(mContext, R.layout.item_bluetooth, devices) {
            @Override
            protected void convert(ViewHolder viewHolder, BluetoothDevice item, int position) {
                viewHolder.setText(R.id.tv_name, item.getName() + "\n" + item.getAddress());
            }
        };
        listView.setAdapter(bluetoothAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BluetoothDevice clickDevice = devices.get(position);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    int bondState = clickDevice.getBondState();
                    if(bondState == BluetoothDevice.BOND_BONDED){
                        connect(clickDevice);
                    }else{
                        clickDevice.createBond();
                    }
                }
            }
        });

        mReceiver = new BluetoothBroadcastReceiver(this);
        // 注册BroadcastReceiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(mReceiver, filter);
    }

    public void getServiceData(){
        NetUtils.getInstance().get(this, "http://192.168.2.237/lotserver/query/btnget", new NetSuccessCallback() {
            @Override
            public void onSuccess(final String result) {

            }
        });
    }

    /**
     * 打印测试
     */
    private void printDemo() {
        new Thread(){
            @Override
            public void run() {
                PrintUtils.selectCommand(RESET);
                PrintUtils.selectCommand(ALIGN_CENTER);
                PrintUtils.selectCommand(DOUBLE_HEIGHT_WIDTH);
                PrintUtils.selectCommand(BOLD);
                PrintUtils.printText("商家");
                PrintUtils.selectCommand(ALIGN_LEFT);
                PrintUtils.selectCommand(NORMAL);
                PrintUtils.selectCommand(BOLD_CANCEL);
                PrintUtils.printText("鱼香肉丝            12元");
                PrintUtils.selectCommand(NEW_LINE);
                PrintUtils.printText("鱼香肉丝            12元");
                PrintUtils.selectCommand(NEW_LINE);
                PrintUtils.printText("鱼香肉丝            12元");
                PrintUtils.selectCommand(NEW_LINE);
                PrintUtils.printText("鱼香肉丝            12元");
                PrintUtils.selectCommand(NEW_LINE);
                PrintUtils.selectCommand(CUT_PAPER);
            }
        }.start();
    }

    final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private void connect(BluetoothDevice dev) {
        UUID uuid = UUID.fromString(SPP_UUID);
        try {
            BluetoothSocket socket = dev.createRfcommSocketToServiceRecord(uuid);
            socket.connect();
            Log.d("-------->", "连接成功");
            OutputStream outputStream = socket.getOutputStream();
            PrintUtils.setOutputStream(outputStream);
        } catch (Exception e) {
            Log.d("-------->", "连接失败");
            e.printStackTrace();
        }
    }

    private void requestPermission() {
        PermissionUtils
                .with(this)
                .permission(new String[]{
                        Manifest.permission.BLUETOOTH,
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
        Log.d("-------->", "扫描开始");
        if (!mAdapter.startDiscovery()) {
            //有可能打开失败，需要关闭蓝牙重新尝试
            Log.e("-------->", "蓝牙扫描打开失败");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void findDevice(BluetoothDevice device) {
        devices.add(device);
        Log.d("-------->", "扫描到" + devices.size() + "个设备");
        bluetoothAdapter.notifyDataSetChanged();
    }

    @Override
    public void discoveryFinished() {
        //取消搜索
        mAdapter.cancelDiscovery();
        Log.d("-------->", "扫描结束");
    }

    @Override
    public void bondStateChange(int bondState) {
        if(bondState == BluetoothDevice.BOND_BONDED){
            Log.d("-------->", "配对成功");
        }else if(bondState == BluetoothDevice.BOND_BONDING){
            Log.d("-------->", "正在配对");
        }else if(bondState == BluetoothDevice.BOND_NONE){
            Log.d("-------->", "配对失败");
        }
    }
}
