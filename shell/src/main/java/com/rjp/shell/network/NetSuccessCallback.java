package com.rjp.shell.network;

import com.rjp.shell.model.BaseModel;

/**
 * author : Gimpo create on 2018/3/30 11:30
 * email  : jimbo922@163.com
 */

public interface NetSuccessCallback {
    void onSuccess(String code, BaseModel result);
}
