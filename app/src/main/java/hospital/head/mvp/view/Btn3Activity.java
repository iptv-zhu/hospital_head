package hospital.head.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import hospital.head.R;
import hospital.head.mvp.view.base.BaseActivity;

public class Btn3Activity extends BaseActivity implements View.OnClickListener {

    private ImageButton over_huli;

    @Override
    public void initView(Bundle savedInstanceState) {
        over_huli = findViewByid(R.id.over_huli);
        over_huli.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public int getContentId() {
        return R.layout.activity_btn3;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.over_huli:
                finish();
                break;
        }
    }
}
