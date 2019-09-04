package hospital.head.mvp.view.custom;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import hospital.head.R;
import hospital.head.utils.Logs;
import hospital.head.utils.LtoDate;

public class Top extends RelativeLayout {
    private TextView time_hm;
    private TextView time_ymd;
    private TextView time_e;
    private Context context;
    private View view;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    long sys = System.currentTimeMillis();
                    time_hm.setText(LtoDate.Hm(sys));
                    time_ymd.setText(LtoDate.yMd(sys));
                    time_e.setText(LtoDate.E(sys));
                    handler.sendEmptyMessageDelayed(0, 1000);
                    break;
            }
        }
    };


    public Top(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
        loadData();

    }

    private void initView() {
        view = LayoutInflater.from(context).inflate(R.layout.top, this);
        time_hm = view.findViewById(R.id.time_hm);
        time_ymd = view.findViewById(R.id.time_ymd);
        time_e = view.findViewById(R.id.time_e);
    }


    private void loadData() {
        handler.sendEmptyMessage(0);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logs.e("onDetachedFromWindow");
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logs.e("onAttachedToWindow");
    }

}
