package com.rjp.shell.network;

/**
 * author : Gimpo create on 2018/3/30 11:30
 * email  : jimbo922@163.com
 */

public interface NetFailureCallback {
    void onFailure(String code, String errorMsg);
}
