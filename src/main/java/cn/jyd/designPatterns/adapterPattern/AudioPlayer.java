package cn.jyd.designPatterns.adapterPattern;
/**
 * 具体播放器（Concrete Target）
 * 支持基本MP3和通过适配器扩展其他格式
 */
public class AudioPlayer implements MediaPlayer{
    @Override
    public void play(String audioType, String fileName) {
        // 支持MP3直接播放
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
            return;
        }

        // 其他格式通过适配器播放
        if (audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")) {
            MediaAdapter adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
            return;
        }
        // 不支持的格式
        System.out.println("not supported format: " + audioType);
    }
}
