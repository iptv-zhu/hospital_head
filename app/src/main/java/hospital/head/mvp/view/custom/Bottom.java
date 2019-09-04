package hospital.head.mvp.view.custom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import hospital.head.R;
import hospital.head.mvp.view.Btn1Activity;
import hospital.head.mvp.view.Btn2Activity;
import hospital.head.mvp.view.Btn3Activity;
import hospital.head.utils.Logs;

public class Bottom extends ConstraintLayout implements View.OnClickListener {
    private Button btn1, btn2, btn3;
    private Context context;
    private View view;
    private StringBuffer keyValue = new StringBuffer();
    private final static String psw = "123456";

    public Bottom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
        loadData();
    }

    private void initView() {
        view = LayoutInflater.from(context).inflate(R.layout.bottom, this);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        initKeyBoard();
    }


    private void loadData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                context.startActivity(new Intent(context, Btn1Activity.class));
                break;
            case R.id.btn2:
                context.startActivity(new Intent(context, Btn2Activity.class));
                break;
            case R.id.btn3:
                if (dialog != null)
                    dialog.show();
                break;
        }
    }


    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button btn_d, btn_b;
    private TextInputEditText password;
    private BottomSheetDialog dialog = null;

    private void initKeyBoard() {
        dialog = new BottomSheetDialog(context);
        dialog.setContentView(R.layout.keyboard);
        dialog.setCancelable(false);
        btn_0 = dialog.findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new KeyCode());
        btn_1 = dialog.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new KeyCode());
        btn_2 = dialog.findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new KeyCode());
        btn_3 = dialog.findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new KeyCode());
        btn_4 = dialog.findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new KeyCode());
        btn_5 = dialog.findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new KeyCode());
        btn_6 = dialog.findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new KeyCode());
        btn_7 = dialog.findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new KeyCode());
        btn_8 = dialog.findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new KeyCode());
        btn_9 = dialog.findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new KeyCode());
        btn_d = dialog.findViewById(R.id.btn_d);
        btn_d.setOnClickListener(new KeyCode());
        btn_b = dialog.findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new KeyCode());
        password = dialog.findViewById(R.id.password);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                keyValue.setLength(0);
            }
        });
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    class KeyCode implements OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_0:
                    keyValue.append("0");
                    break;
                case R.id.btn_1:
                    keyValue.append("1");
                    break;
                case R.id.btn_2:
                    keyValue.append("2");
                    break;
                case R.id.btn_3:
                    keyValue.append("3");
                    break;
                case R.id.btn_4:
                    keyValue.append("4");
                    break;
                case R.id.btn_5:
                    keyValue.append("5");
                    break;
                case R.id.btn_6:
                    keyValue.append("6");
                    break;
                case R.id.btn_7:
                    keyValue.append("7");
                    break;
                case R.id.btn_8:
                    keyValue.append("8");
                    break;
                case R.id.btn_9:
                    keyValue.append("9");
                    break;
                case R.id.btn_d:
                    if (keyValue.length() > 0)
                        keyValue.deleteCharAt(keyValue.length() - 1);
                    break;
                case R.id.btn_b:
                    if (dialog != null)
                        dialog.dismiss();
                    break;

                default:
                    break;

            }
            password.setText(keyValue);
            if (password.getText().toString().equals(psw)) {
                if (dialog != null)
                    dialog.dismiss();
                context.startActivity(new Intent(context, Btn3Activity.class));
            }

        }
    }


    private void cc() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 1000);
        timer.cancel();
    }


}
