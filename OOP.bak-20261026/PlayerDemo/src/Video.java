public class Video implements Playable,Downloadable{
    private String name;
    private double sizeGB;

    public Video(String name, double sizeGB) {
        this.name = name;
        this.sizeGB = sizeGB;
    }

    @Override
    public void play() {
        System.out.println("播放视频《" + name + "》");
    }

    @Override
    public void download() {
        System.out.println("已下载《" + name + "》" + " 内存：" + sizeGB);
    }

    @Override
    public String getInfo() {
        return "视频名：" + name + "大小：" + sizeGB;
    }
}
