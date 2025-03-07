package cn.jyd.fourteen;

import org.junit.Test;
import java.io.*;

/**
 * 第十章练习题
 */
public class Exercise10 {
    /**
     * 测试字节和字符差别
     */
    @Test
    public void testByteAndChar() {
        byte[] b = new byte[]{'A','B','C',68,69,70};
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }
        System.out.println();

        char[] c = new char[]{'我','是','一','个','学','生'};
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
    }
    /**
     * 10.4.1，page 345
     * 使用RandomAccessFile将一个文本文件倒置读出。
     */
    @Test
    public void exercise1041() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\english.txt";
        RandomAccessFile in = null;
        try {
            in = new RandomAccessFile(path, "r");
            long length = in.length();
            long position = length-1;
            while (position >= 0) {
                in.seek(position);
                byte b = in.readByte();
                position--;
                System.out.print((char) b);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * 10.4.2，page 346
     */
    @Test
    public void testBufferedStream() {
        String sourcePath = "D:\\培训教学\\JAVA\\文件操作示例\\Java教学.txt";
        String targetPath = "D:\\培训教学\\JAVA\\文件操作示例\\Java教学Line.txt";
        File fRead = new File(sourcePath);
        File fWrite = new File(targetPath);
        try {
            Writer out = new FileWriter(fWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(out);
            Reader in = new FileReader(fRead);
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = null;
            int lineNum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                line =lineNum+":"+ line ;
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                lineNum++;
            }
            bufferedWriter.close();
            out.close();
            // 下面读取目标文件，并进行显示
            in = new FileReader(fWrite);
            bufferedReader = new BufferedReader(in);
            String s = null;
            System.out.println(fWrite.getName() + "内容：");
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
            bufferedReader.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
     * 10.3.2，page 345
     */
    @Test
    public void testInputStreamRead() {
        int n=-1;
        File f=new File("D:\\培训教学\\JAVA\\文件操作示例\\hello.txt");
        byte[] a="abcd".getBytes();
        try{
            FileOutputStream out=new FileOutputStream(f);
            out.write(a);
            out.close();
            FileInputStream in=new FileInputStream(f);
            byte[] tom=new byte[3];
            int m=in.read(tom,0,3);
            System.out.println(m);          //代码1,输出：3
            String s=new String(tom,0,m);
            System.out.println(s);          //代码2,输出：abc
            m=in.read(tom,0,3);
            System.out.println(m);          //代码3,输出：1
            s=new String(tom,0,m);
            System.out.println(s);          //代码4,输出：dbc
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
