package hospital.head.mvp.view.custom;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.xutils.x;

import hospital.head.R;
import hospital.head.mvp.presenter.api.IBaseView;
import hospital.head.mvp.view.base.BaseActivity;
import hospital.head.utils.Logs;

public abstract class BaseView extends ViewGroup implements IBaseView {
    public <T, View> T findViewByid(int id) {
        return (T) super.findViewById(id);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        View view = LayoutInflater.from(context).inflate(getContentId(), this);
//        initView(BaseActivity.savedInstanceState);
        initView(null);
        loadData();
    }


}
