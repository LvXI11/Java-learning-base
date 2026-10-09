public class Music implements Playable,Downloadable{
    private String name;
    private double duration;

    public Music(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public void play() {
        System.out.println("播放音乐《" + name + "》");
    }

    @Override
    public void download() {
        System.out.println("已下载《" + name + "》" + "时长：" + duration);
    }

    @Override
    public String getInfo() {
        return "音乐名：《" + name + "》 时长；" + duration;
    }
}
