package cn.jyd.designPatterns.adapterPattern;
/**
 * 目标接口（Target）
 * 客户端希望使用统一的接口来播放各种格式的音频
 */
public interface MediaPlayer {
    void play(String audioType, String fileName);
}
