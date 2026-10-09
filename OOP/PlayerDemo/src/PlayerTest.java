public class PlayerTest {
    public static void main(String[] args) {
        Playable[] p1 = new  Playable[4];
        for (int i = 0; i < 2; i++) {
            p1[i] = new Music("music" + i,44 + i);
        }

        p1[2] = new Video("video01",1.2);

        Playable ad = new Playable() {
            @Override
            public void play() {
                System.out.println("播放广告 15 秒");
            }

            @Override
            public String getInfo() {
                return "广告";
            }
        };

        p1[3] = ad;

        Player.playAll(p1);
        System.out.println("能下载的有"+  Player.countDownloadable(p1) + "个");
        Player.downloadAll(p1);

        System.out.println(Playable.MAX_VOLUME);
    }
}
