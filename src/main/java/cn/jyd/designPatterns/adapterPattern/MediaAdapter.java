package cn.jyd.designPatterns.adapterPattern;
/**
 * 媒体适配器：将AdvancedMediaPlayer适配为MediaPlayer
 */
public class MediaAdapter implements MediaPlayer{
    // 引用一个AdvancedMediaPlayer对象，来执行不同类型媒体的播放
    private AdvancedMediaPlayer advancedPlayer;
    // 构造函数,通过传入参数，创建不同的AdvancedMediaPlayer对象
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer = new Mp4Player();
        }
    }
    // 通过调用AdvancedMediaPlayer的方法来播放
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
    }
}
