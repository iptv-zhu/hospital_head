package hospital.head.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import hospital.head.app.MyApplication;
import hospital.head.mvp.model.RegistVo;
import hospital.head.mvp.model.UploadLogVo;

public class SocketIO {
    private String ip = "192.168.2.6";
    private String port = "8003";
//    private String url = "http://" + ip + ":" + port + "/main";
    private String url = "http://" + ip + ":" + port + "/tv";

    public static Socket socket;
    private Context context;
    private MyApplication app;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
            }
        }
    };

    public SocketIO(Context context) {
        try {
            this.context = context;
            app = (MyApplication) context.getApplicationContext();
            socket = IO.socket(url);
            Logs.e(url);
            socket.on(Socket.EVENT_CONNECT, EVENT_CONNECT);
            socket.on(Socket.EVENT_CONNECT_ERROR, EVENT_CONNECT_ERROR);
            socket.on(Socket.EVENT_CONNECT_TIMEOUT, EVENT_CONNECT_TIMEOUT);
            socket.on(Socket.EVENT_DISCONNECT, EVENT_DISCONNECT);
            socket.on(Socket.EVENT_ERROR, EVENT_ERROR);
            socket.on(Socket.EVENT_MESSAGE, EVENT_MESSAGE);
            socket.on(Socket.EVENT_RECONNECT, EVENT_RECONNECT);
//            socket.on(Socket.EVENT_RECONNECT_ATTEMPT, EVENT_RECONNECT_ATTEMPT);
//            socket.on(Socket.EVENT_RECONNECT_ERROR, EVENT_RECONNECT_ERROR);
//            socket.on(Socket.EVENT_RECONNECT_FAILED, EVENT_RECONNECT_FAILED);
//            socket.on(Socket.EVENT_RECONNECTING, EVENT_RECONNECTING);
            sio();
            socket.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sio() {
        socket.on("success", new Emitter.Listener() {

            public void call(Object... arg0) {
                // TODO Auto-generated method stub
                String json = arg0[0].toString();
                Logs.e("sio-success-事件" + json);
            }
        });

        socket.on("vol", new Emitter.Listener() {

            public void call(Object... arg0) {
                // TODO Auto-generated method stub
                try {
                    String json = arg0[0].toString();
                    Logs.e("sio-vol-事件" + json);
                    MyApplication.setStreamVolume(Integer.valueOf(json));
                    uploadLog("音量更新为-" + json + "%");
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

        });
        socket.on("close", new Emitter.Listener() {// 关机：close
            @Override
            public void call(Object... args) {
                try {
//                    String json = args[0].toString();
                    Logs.e("sio-close-事件");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        socket.on("open", new Emitter.Listener() {//  开机：open
            @Override
            public void call(Object... args) {
                try {
//                    String json = args[0].toString();
                    Logs.e("sio-open-事件");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        socket.on("upgrade", new Emitter.Listener() {//  开机：open
            @Override
            public void call(Object... args) {
                try {
                    String json = args[0].toString();
                    Logs.e("sio-open-事件");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private Emitter.Listener EVENT_CONNECT = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("连接" + url + "成功");
            registVo();
        }
    };

    private void registVo() {
        RegistVo registVo = new RegistVo();
        registVo.setVersion(Double.valueOf(Utils.getVersion(context)));
        registVo.setVoice(Utils.getCurrentVolume(context));
        String registVojson = Utils.gson.toJson(registVo);
        socket.emit("register", registVojson);
        Logs.e("发送注册事件" + registVojson);

    }

    private Emitter.Listener EVENT_CONNECT_ERROR = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
//            Logs.e("连接失败");
        }
    };
    private Emitter.Listener EVENT_CONNECT_TIMEOUT = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("连接超时");
        }
    };
    private Emitter.Listener EVENT_DISCONNECT = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("断开连接");
        }
    };
    private Emitter.Listener EVENT_ERROR = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_ERROR");
        }
    };
    private Emitter.Listener EVENT_MESSAGE = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_MESSAGE");
        }
    };
    private Emitter.Listener EVENT_RECONNECT = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_RECONNECT");
        }
    };
    private Emitter.Listener EVENT_RECONNECT_ATTEMPT = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_RECONNECT_ATTEMPT");
        }
    };
    private Emitter.Listener EVENT_RECONNECT_ERROR = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_RECONNECT_ERROR");
        }
    };
    private Emitter.Listener EVENT_RECONNECT_FAILED = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_RECONNECT_FAILED");
        }
    };
    private Emitter.Listener EVENT_RECONNECTING = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Logs.e("EVENT_RECONNECTING");
        }
    };

    public static void uploadLog(String operatetion) {
        UploadLogVo uploadLogVo = new UploadLogVo();
        uploadLogVo.setOperatetion(operatetion);
        String json = Utils.gson.toJson(uploadLogVo);
        Logs.e("uploadLog " + json);
        socket.emit("uploadLog", json);
    }
}
