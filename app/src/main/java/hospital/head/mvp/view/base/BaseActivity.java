package hospital.head.mvp.view.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import org.xutils.x;

import hospital.head.mvp.presenter.api.IBaseView;
import hospital.head.mvp.view.SleepActivity;
import hospital.head.utils.Logs;

public abstract class BaseActivity extends Activity implements IBaseView {
    private static final int Sleep = 0;
    private static final long sleeptime = 10 * 60 * 1000;
    //    private static final long sleeptime = 10 * 1000;
    public static Activity activity;
    public static Bundle savedInstanceState;

    public <T, View> T findViewByid(int id) {
        return (T) super.findViewById(id);
    }


    @Override
    protected void onStart() {
        super.onStart();
        activity = this;
        Reslepp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        x.view().inject(this);
        setContentView(getContentId());
        initView(savedInstanceState);
        loadData();
    }


    @Override
    protected void onStop() {
        super.onStop();
        handler.removeMessages(Sleep);
        Logs.e("cancle sleep");
    }

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Sleep:
                    startActivity(new Intent(BaseActivity.this, SleepActivity.class));
                    break;
            }
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Logs.e(event.toString());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Reslepp();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }

    private void Reslepp() {
        Logs.e("reset sleep");
        handler.removeMessages(Sleep);
        handler.sendEmptyMessageDelayed(Sleep, sleeptime);
    }

}
