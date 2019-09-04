package hospital.head.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

import hospital.head.R;
import hospital.head.mvp.view.base.BaseActivity;

public class Btn2Activity extends BaseActivity implements View.OnClickListener {

    private ImageButton over_icon;

    @Override
    public void initView(Bundle savedInstanceState) {
        over_icon = findViewByid(R.id.over_icon);
        over_icon.setOnClickListener(this);
    }

    @Override
    public void loadData() {
    }

    @Override
    public int getContentId() {
        return R.layout.activity_btn2;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.over_icon:
                finish();
                break;

        }
    }
}
