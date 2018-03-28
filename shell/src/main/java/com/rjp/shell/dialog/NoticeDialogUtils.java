package com.rjp.shell.dialog;

import android.content.Context;

public class NoticeDialogUtils {

    /**
     * 只响应一个按钮的dialog
     * @param context
     * @param msg
     */
    public static NoticeDialog notice0(Context context , String msg ){
        return notice(context, "提醒", msg, null, "确定", true, null, new NoticeDialog.OnNoticeClickListener() {
            @Override
            public void onNoticeClick(NoticeDialog dialog, int which) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 只响应一个按钮的dialog
     * @param context
     * @param msg
     * @param listener
     */
    public static NoticeDialog notice1(Context context , String msg , NoticeDialog.OnNoticeClickListener listener){
        return notice(context, "提醒", msg, "取消", "确定", true, new NoticeDialog.OnNoticeClickListener() {
            @Override
            public void onNoticeClick(NoticeDialog dialog, int which) {
                dialog.dismiss();
            }
        }, listener);
    }


    /**
     * 只响应一个按钮的dialog  点击外部不可以取消
     * @param context
     * @param msg
     * @param listener
     */
    public static NoticeDialog notice1Cancel(Context context , String msg , boolean cancel,  NoticeDialog.OnNoticeClickListener listener){
        return notice(context, "提醒", msg, "取消", "确定", cancel, new NoticeDialog.OnNoticeClickListener() {
            @Override
            public void onNoticeClick(NoticeDialog dialog, int which) {
                dialog.dismiss();
            }
        }, listener);
    }

    /**
     * 响应两个按钮的dialog , 取消按钮除了dismiss()会执行操作
     * @param context
     * @param msg
     * @param listener
     */
    public static NoticeDialog notice2(Context context , String msg , NoticeDialog.OnNoticeClickListener listener){
        return notice(context, "提醒", msg, "取消", "确定", listener);
    }

    /**
     * 提示的dialog
     * @param context
     * @param title
     * @param msg
     * @param cancel
     * @param confirm
     * @param listener
     */
    public static NoticeDialog notice(Context context , String title , String msg , String cancel , String confirm , NoticeDialog.OnNoticeClickListener listener){
        return notice(context, title, msg, cancel, confirm, true, listener , listener);
    }

    /**
     * 提示的dialog  可以取消
     * @param context
     * @param title
     * @param msg
     * @param cancel
     * @param confirm
     * @param listener
     */
    public static NoticeDialog noticeCancel(Context context , String title , String msg , String cancel , String confirm , boolean cancelble, NoticeDialog.OnNoticeClickListener listener){
        return notice(context, title, msg, cancel, confirm, cancelble, listener , listener);
    }

    /**
     * 提示dialog
     * @param context
     * @param title
     * @param msg
     * @param cancel
     * @param confirm
     * @param cancelListener
     * @param confirmListener
     */
    private static NoticeDialog notice(Context context , String title , String msg , String cancel , String confirm ,boolean cancelble,
                              NoticeDialog.OnNoticeClickListener cancelListener , NoticeDialog.OnNoticeClickListener confirmListener){
        NoticeDialog.Builder builder = new NoticeDialog.Builder(context);
        NoticeDialog dialog = builder.setTitle(title)
                .setOutSideCancelble(cancelble)
                .setMessage(msg)
                .setPositiveButton(confirm, confirmListener)
                .setNegativeButton(cancel, cancelListener)
                .create();
        dialog.show();
        return dialog;
    }
}
