package com.rjp.shell.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjp.shell.R;


public class NoticeDialog extends Dialog {
    public static final int NOTICE_CONFIRM = 1000;
    public static final int NOTICE_CANCEL = 1001;

    public NoticeDialog(Context context) {
        super(context);
    }

    public NoticeDialog(Context context, int theme) {
        super(context, theme);
    }

    public static class Builder {
        private Context context;
        private String title;
        private boolean cancelble;
        private String message;
        private String positiveBtn;
        private String negativeBtn;
        private OnNoticeClickListener positiveBtnClickListener;
        private OnNoticeClickListener negativeBtnClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置提醒content
         * @param message
         * @return
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setOutSideCancelble(boolean cancelble) {
            this.cancelble = cancelble;
            return this;
        }

        /**
         * 设置提醒title
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText,
                                         OnNoticeClickListener listener) {
            this.positiveBtn = (String) context
                    .getText(positiveButtonText);
            this.positiveBtnClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText,
                                         OnNoticeClickListener listener) {
            this.positiveBtn = positiveButtonText;
            this.positiveBtnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText,
                                         OnNoticeClickListener listener) {
            this.negativeBtn = (String) context
                    .getText(negativeButtonText);
            this.negativeBtnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText,
                                         OnNoticeClickListener listener) {
            this.negativeBtn = negativeButtonText;
            this.negativeBtnClickListener = listener;
            return this;
        }

        public NoticeDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final NoticeDialog dialog = new NoticeDialog(context, R.style.common_dialog_and_popup);
            View layout = inflater.inflate(R.layout.layout_notice_dialog, null);
            ((TextView) layout.findViewById(R.id.tv_title)).setText(title);
            if (positiveBtn != null) {
                ((TextView) layout.findViewById(R.id.tv_confirm)).setText(positiveBtn);
                if (positiveBtnClickListener != null) {
                    (layout.findViewById(R.id.tv_confirm)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            positiveBtnClickListener.onNoticeClick(dialog, NOTICE_CONFIRM);
                        }
                    });
                }
            } else {
                layout.findViewById(R.id.tv_confirm).setVisibility(View.GONE);
            }
            if (negativeBtn != null) {
                ((TextView) layout.findViewById(R.id.tv_cancel)).setText(negativeBtn);
                if (negativeBtnClickListener != null) {
                    (layout.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            negativeBtnClickListener.onNoticeClick(dialog, NOTICE_CANCEL);
                        }
                    });
                }
            } else {
                layout.findViewById(R.id.tv_cancel).setVisibility(View.GONE);
            }
            if (message != null) {
                ((TextView) layout.findViewById(R.id.tv_notice)).setText(message);
            }
            dialog.setContentView(layout , new ViewGroup.LayoutParams((int) (getWindowWidth(context) * 0.8), ViewGroup.LayoutParams.WRAP_CONTENT));
            dialog.setCanceledOnTouchOutside(cancelble);
            dialog.setCancelable(cancelble);
            return dialog;
        }

        /**
         * 获取屏幕宽度
         * @return
         */
        public int getWindowWidth(Context context){
            return context.getResources().getDisplayMetrics().widthPixels;
        }
    }

    public interface OnNoticeClickListener {
        void onNoticeClick(NoticeDialog dialog, int which);
    }
}
