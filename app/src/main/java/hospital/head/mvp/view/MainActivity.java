package hospital.head.mvp.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import hospital.head.R;
import hospital.head.mvp.presenter.adapter.MainAdapter;
import hospital.head.mvp.view.base.BaseActivity;


public class MainActivity extends BaseActivity {
    private RecyclerView list;
    private WebView marquee;
    private ImageView more;
    private String title = "<marquee   scrollamount='5' style='position:absolute;left:0px;top:0px;color:#4a5b6f;'>" +
            "欢迎使用晟视讯医护可视对讲系统..." +
            "</marquee>";
    private MainAdapter mainAdapter;

    @Override
    public void initView(Bundle savedInstanceState) {
        list = findViewByid(R.id.list);

        marquee = findViewByid(R.id.marquee);
        marquee.setBackgroundColor(Color.TRANSPARENT);
        more = findViewByid(R.id.more);

    }

    @Override
    public void loadData() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        list.setLayoutManager(staggeredGridLayoutManager);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(i + "test");
        }
        if (data.size() < 5) {
            more.setVisibility(View.GONE);
        }
        mainAdapter = new MainAdapter(this, data);
        list.setAdapter(mainAdapter);


        marquee.loadData(title, "text/html", "utf-8");
    }

    @Override
    public int getContentId() {
        return R.layout.activity_main_2;
    }


}
