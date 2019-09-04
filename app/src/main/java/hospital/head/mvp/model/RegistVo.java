package hospital.head.mvp.model;


import hospital.head.app.MyApplication;

public class RegistVo {
    private String mac = MyApplication.mac;

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double version = 1.0;
    private int voice = 0;
    private String name = " ";  //可为空
    private Integer terType = 3;
}
