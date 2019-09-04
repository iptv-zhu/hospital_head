package hospital.head.mvp.view;

import android.os.Bundle;
import hospital.head.R;
import hospital.head.mvp.view.base.BaseActivity;
import hospital.head.utils.Logs;

public class DocActivity extends BaseActivity {

    @Override
    public void initView(Bundle savedInstanceState) {
        String test = (String) getIntent().getSerializableExtra("key");
        Logs.e(test);
    }

    @Override
    public void loadData() {

    }

    @Override
    public int getContentId() {
        return R.layout.activity_doc;
    }

    private int ttr(){
        return 0;
    }

}
