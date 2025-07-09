package cn.jyd.designPattern;

import cn.jyd.designPatterns.adapterPattern.AudioPlayer;
import cn.jyd.designPatterns.adapterPattern.MediaPlayer;
import org.junit.jupiter.api.Test;
/**
 * 适配器模式测试类
 */
public class adapterPatternTest {
    // 测试适配器模式
    @Test
    public void adapterPatternTest() {
        MediaPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");      // 直接支持
        player.play("vlc", "movie.vlc");    // 通过适配器支持
        player.play("mp4", "video.mp4");    // 通过适配器支持
        player.play("avi", "file.avi");     // 不支持的格式
    }
}
