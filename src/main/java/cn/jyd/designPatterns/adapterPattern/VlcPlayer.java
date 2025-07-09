package cn.jyd.designPatterns.adapterPattern;
/**
 * Vlc适配者
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }
    @Override
    public void playMp4(String fileName) {
        // 空实现
    }
}
