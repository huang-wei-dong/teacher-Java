package cn.jyd.fourteen;

import cn.jyd.four.Person;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 文件操作，第10章
 */
public class TestFile {
    /**
     * 测试文件操作,Example 10_1
     */
    @Test
    public void testFile() {
        String path = "src\\test\\java\\cn\\jyd\\fourteen\\TestFile.java";

        File file = new File(path);
        System.out.println(file.getName() + "是可读的吗:" + file.canRead());
        System.out.println(file.getName() + "文件长度:" + file.length());
        System.out.println(file.getName() + "绝对路径:" + file.getAbsolutePath());
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("在当前目录下创建了新文件：\n" + file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试目录操作，Example 10_2
     */
    @Test
    public void testDirectory() {
        File javaDir = new File("java");
        System.out.println(javaDir.isDirectory());
        boolean bool = javaDir.mkdir();
        if (bool) {
            System.out.println("创建目录成功" + javaDir.getName());
        }
        File dirFile = new File(
                "src\\test\\java\\cn\\jyd\\four");//当前目录下
        System.out.println("全部文件（包括文件夹）：");
        String[] fileName = dirFile.list();
        if (fileName == null) {
            System.out.println("没有文件");
        } else {
            for (String name : fileName) {
                System.out.println(name);
            }
        }
        System.out.println("仅列出java源文件：");
        File[] files = dirFile.listFiles(f -> f.getName().endsWith(".java"));
        if (files == null) {
            System.out.println("没有java源文件");
        } else {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
    /**
     * Runtime打开记事本，Example 10_3
     */
    @Test
    public void testRuntime() {
        try {
            Runtime.getRuntime().exec("notepad");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字节输入流,Example 10_4
     */
    @Test
    public void testFileInputStream() {
        String path = "src\\test\\java\\cn\\jyd\\fourteen\\TestFile.java";

        int n = -1;
        byte[] a = new byte[100];
        try {
            File file = new File(path);
            InputStream inputStream = new FileInputStream(file);
            while ((n = inputStream.read(a, 0, 100)) != -1) {
                System.out.println(new String(a, 0, n));
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("File read error " + e);
        }
    }
    /**
     * 文件字节输出流，Example 10_5
     * 将"新年快乐"写到example10_6.txt文件并再次追加"Happy New Year"
     */
    @Test
    public void testFileOutputStream2() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\example10_6.txt";

        try {
            File file = new File(path);
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write("新年快乐".getBytes());
            outputStream.close();

            outputStream = new FileOutputStream(file, true);
            outputStream.write("Happy New Year".getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 文件字符输入-输出流，Example 10_6
     */
    @Test
    public void testFileOutputStream() {
        String sourcePath = "D:\\培训教学\\JAVA\\文件操作示例\\sourec.txt";
        String targetPath = "D:\\培训教学\\JAVA\\文件操作示例\\target.txt";
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        char[] c = new char[20];
        try {
            Writer out = new FileWriter(targetFile, true);
            Reader in = new FileReader(sourceFile);
            int n = -1;
            while ((n = in.read(c)) != -1) {
                out.write(c, 0, n);
            }
            out.flush();
            in.close();
        } catch (IOException e) {
            System.out.println("File read error " + e);
        }
    }

    /**
     * 缓冲流，Example 10_7
     */
    @Test
    public void testBufferedStream() {
        String sourcePath = "D:\\培训教学\\JAVA\\文件操作示例\\english.txt";
        String targetPath = "D:\\培训教学\\JAVA\\文件操作示例\\englishCount.txt";
        File fRead = new File(sourcePath);
        File fWrite = new File(targetPath);
        try {
            Writer out = new FileWriter(fWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(out);
            Reader in = new FileReader(fRead);
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                int count = st.countTokens();
                line = line + " 句子中单词数：" + count;
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            out.close();
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
     * 随机流读取文件，Example 10_9
     */
    @Test
    public void testRandomAccessFile() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\sourec.txt";
        RandomAccessFile in = null;
        try {
            in = new RandomAccessFile(path, "r");
            long length = in.length();
            long position = 0;
            while (position < length) {
                String line = in.readLine();
                //采用默认编码读取，中文会出现乱码
                byte[] b = line.getBytes("iso-8859-1");//获取当前行字节数组
                String str = new String(b, "utf-8");//转换为当前编码
                position = in.getFilePointer();//获取当前文件读写位置
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    /**
  * 数组流，Example 10_10
  */
    @Test
    public void testArrayStream() {
        try{
            ByteArrayOutputStream outByte = new ByteArrayOutputStream();
            byte[] byteContent =" mid-autumn festival ".getBytes();
            outByte.write(byteContent);
            ByteArrayInputStream inByte = new ByteArrayInputStream(outByte.toByteArray());
            byte[] backByte = new byte[byteContent.length];
            inByte.read(backByte);
            System.out.println(new String(backByte));
            //下面处理中文
            CharArrayWriter outChar = new CharArrayWriter();
            char[] chatContent = " 中秋快乐 ".toCharArray();
            outChar.write(chatContent);
            CharArrayReader inChar = new CharArrayReader(outChar.toCharArray());
            char[] backChar = new char[outChar.size()];
            inChar.read(backChar);
            System.out.println(new String(backChar));
        }catch(IOException e){
            System.out.println(e);
        }
    }
    /**
     * 测试数据流，Example 10_12
     * 将命令加加密后，存入文件，再读取文件解密显示
     */
    @Test
    public void testDataStream() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\encrypt.txt";
        String command = "渡江总攻时间是4月22日晚10点";
        String password = "Tiger";
        String secret = encrypt(command, password);//加密
        File file = new File(path);
        try {
            FileOutputStream out = new FileOutputStream(file);
            DataOutputStream dataOut = new DataOutputStream(out);
            dataOut.writeUTF(secret);
            System.out.println("加密后：" + secret);
        }catch (IOException e){}
        try {
            FileInputStream in = new FileInputStream(file);
            DataInputStream dataIn = new DataInputStream(in);
            String secret2 = dataIn.readUTF();
            System.out.println("解密后：" + decrypt(secret2, password));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 加密方法，Example 10_12
     */
    private String encrypt(String command, String password) {
        char[] p= password.toCharArray();
        int n = p.length;
        char[] c= command.toCharArray();
        int m= c.length;
        for(int i=0;i<m;i++){
            c[i]=(char)(c[i]^p[i%n]);
        }
        return new String(c);
    }
    /**
     * 解密方法，Example 10_12
     */
    private String decrypt(String secret, String password) {
        char[] p= password.toCharArray();
        int n = p.length;
        char[] c= secret.toCharArray();
        int m= c.length;
        for(int i=0;i<m;i++){
            c[i]=(char)(c[i]^p[i%n]);
        }
        return new String(c);
    }
    /**
     * 测试对象流，Example 10_13
     */
    @Test
    public void testObjectStream() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\object.txt";
        Person p1 = new Person("1101", "张三", "男", LocalDate.of(1990, 1, 1));
        File file = new File(path);
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(p1);
            objOut.close();
            out.close();
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(in);
            Person p2 = (Person) objIn.readObject();
            p2.showMessage();
            objIn.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 采用数组流和对象流实现对象的克隆，仿Example 10_14
     */
    @Test
    public void testClone() {
        Person p1 = new Person("1101", "张三", "男", LocalDate.of(1990, 1, 1));
        try {
            ByteArrayOutputStream outByte = new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(outByte);
            objOut.writeObject(p1);
            objOut.close();
            ByteArrayInputStream inByte = new ByteArrayInputStream(outByte.toByteArray());
            ObjectInputStream objIn = new ObjectInputStream(inByte);
            Person p2 = (Person) objIn.readObject();
            p2.setName("李四");
            p2.setSex("女");
            System.out.println("原始对象：");
            p1.showMessage();
            System.out.println("克隆对象：");
            p2.showMessage();
        }catch(IOException e){
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 测试通过Scanner解析访问文件，Example 10_16
     */
    @Test
    public void testScanner() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\scanner.txt";
        File file = new File(path);
        Scanner in = null;
        int count = 0;
        double sum = 0;
        double score=0;
        try {
            in = new Scanner(file);
            in.useDelimiter("[^0123456789.]+");
            while (in.hasNext()) {
                score = in.nextDouble();
                sum += score;
                count++;
                System.out.println(score);
            }
            System.out.println("平均成绩：" + sum / count);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (InputMismatchException e){
            System.out.println("输入格式不能解释为数值！");
        }
    }
    /**
     * 读取图像文件，Example 10_17
     */
    @Test
    public void testImage() {
        String path = "D:\\培训教学\\JAVA\\文件操作示例\\image\\";
        File fileRead = new File(path+"OIP-C.jpg");
        File fileWrite1 = new File(path+"java.bmp");
        File fileWrite2 = new File(path+"java.jpg");
        try {
            BufferedImage image = ImageIO.read(fileRead);
            Graphics2D g= image.createGraphics();
            int width = image.getWidth();
            int height = image.getHeight();
            Font font = new Font("宋体", Font.BOLD, 40);
            g.setFont(font);
            g.setColor(Color.BLUE);
            g.drawString("我喜欢Java", width / 2 - 50, height / 2);
            ImageIO.write(image, "bmp", fileWrite1);
            ImageIO.write(image, "jpg", fileWrite2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    /**
     * 统计所有.Java文件代码行数
     */
    public void testTotaleCodeLine() {
        String folderPath = "src\\";
        AtomicLong totalLineCount = new AtomicLong();
        try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> {
                        if (path.toString().endsWith(".java")) {
                            //文件行数
                            long lineCount = 0;
                            try {
                                try (Stream<String> lines = Files.lines(path)) {
                                    lineCount = lines.count();
                                    totalLineCount.addAndGet(lineCount);
                                }
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("总共的行数为: " + totalLineCount);
    }
}
