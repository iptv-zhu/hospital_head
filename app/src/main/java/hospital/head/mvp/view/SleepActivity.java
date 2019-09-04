package hospital.head.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import org.xutils.x;

import hospital.head.R;
import hospital.head.utils.Logs;

public class SleepActivity extends Activity implements View.OnTouchListener {

    private WebView sleep;
    private String title = "<marquee   scrollamount='5' style='position:absolute;left:0px;top:0px;color:#4a5b6f;'>" +
            "欢迎使用晟视讯医护可视对讲系统..." +
            "</marquee>";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        sleep = findViewById(R.id.sleep);


        sleep.loadData(title, "text/html", "utf-8");
        sleep.setOnTouchListener(this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Logs.e(event.toString());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                finish();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                finish();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return false;
    }
}
