package hospital.head.app;

import android.app.Application;
import android.media.AudioManager;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import hospital.head.utils.DensityHelper;
import hospital.head.utils.SocketIO;
import hospital.head.utils.Utils;

public class MyApplication extends Application {
    public final static float DESIGN_WIDTH = 800; //绘制页面时参照的设计图宽度

    public final static ImageOptions imageOptions = new ImageOptions.Builder()
            .setFadeIn(true).setIgnoreGif(false)
            .build();
    public static String mac = "zhu";
    private static AudioManager am;
    private static int maxvolume;
    private static int defaultvolume;

    @Override
    public void onCreate() {
        super.onCreate();
        new DensityHelper(this, DESIGN_WIDTH).activate();
        x.Ext.init(this);
        mac = Utils.GetMac();
        SocketIO socketIO=new SocketIO(this);
        SocketIO.uploadLog("开机");

    }


    // 设置音量
    public static void setStreamVolume(int percent) {
        int volume = (int) Math.round((double) maxvolume * percent / 100);
        am.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_SHOW_UI);
    }

}
