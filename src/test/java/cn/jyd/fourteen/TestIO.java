package cn.jyd.fourteen;

import org.junit.Test;

import java.io.*;

/**
 * 测试IO流
 *
 */
public class TestIO {
    /*拷贝文件
     * 通过输入流读取文件，再通过输出流写入文件
     */
    @Test
    public void testByteStream() throws IOException {
        String path = "src\\test\\java\\cn\\jyd\\fourteen\\TestIO.java";
        String copyFilePath = "D:\\培训教学\\JAVA\\文件操作示例\\TestIO.txt";
        File file = new File(path);
        File copyFile = new File(copyFilePath);
        BufferedWriter bos = null;
        BufferedReader bis = null;
        try {
            FileReader fis = new FileReader(file);
            FileOutputStream fos = new FileOutputStream(copyFile);
            bis = new BufferedReader(fis);
            //OutputStreamWriter将字节流转换为字符流
            bos = new BufferedWriter(new OutputStreamWriter(fos));
            int n = -1;
            char[] buff = new char[100];
            while ((n = bis.read(buff, 0, 100)) != -1) {
                System.out.print(new String(buff, 0, n));
                bos.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bos.close();
            bis.close();
        }
    }
}
