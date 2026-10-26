public class Player {
    public static void playAll(Playable[] items){
        int count = 1;
        for(Playable p : items){
            System.out.println(count + "、" + p.getInfo());
            count++;
            p.play();
        }
    }

    public static int countDownloadable(Playable[] items){
        int count = 0;
        for(Playable p : items){
            if(p instanceof Downloadable){
                count++;
            }
        }
        return count;
    }

    public static void downloadAll(Playable[] items){
        for(Playable p : items){
            if(p instanceof Downloadable d){
                d.download();
            }else{
                System.out.println("不支持下载，跳过");
            }
        }
    }
}
