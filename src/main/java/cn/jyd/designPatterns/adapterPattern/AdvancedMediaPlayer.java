package cn.jyd.designPatterns.adapterPattern;
/**
 * 高级媒体播放器接口（现有解码器）
 *提供了播放VLC和MP4文件的方法
 * 我们希望用play(String audioType, String fileName)方法播放所有文件
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
