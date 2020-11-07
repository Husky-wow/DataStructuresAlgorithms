package threadlcoal;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xuxiaoding
 * @version 1.0.0
 * @ClassName MultiThreadCopyFile.java
 * @Description 多线程拷贝文件
 */
public class MultiThreadCopyFile {

    public static void main(String[] args) {
        File srcFile = new File("G:\\旧文件\\续武\\俄胜平");
        File dscFile = new File("G:\\拷贝文件夹");
        try {
            copyFolder(srcFile, dscFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copySingleFile(File srcFile, File dstFile) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(dstFile);
        // 接受读取到的数据
        byte[] data = new byte[1024];
        // 读取到的byte数
        int count = 0;
        // 边读边写
        while ((count = fis.read(data)) != -1) {
            fos.write(data, 0, count);
            fos.flush();
        }
        fis.close();
        fis.close();
    }


    /**
     * 把folder文件夹下所有文件拷贝至dstFolder文件夹下
     * @param folder
     * @param dstFolder
     * @throws IOException
     */
    public static void copyFolder(File folder, File dstFolder) throws IOException {
        // 源文件夹根路径
        String folderRootPath = folder.getAbsolutePath();
        // 获取目的地根路径
        String dstRootPath = dstFolder.getAbsolutePath();
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                // 文件夹，创建文件夹
                String path = dstRootPath + File.separator + file.getName();
                File pathFile = new File(path);
                if (!pathFile.exists()) {
                    pathFile.mkdirs();
                }
                // 递归拷贝文件夹file,目的
                copyFolder(file, pathFile);
            } else {
                // 复制文件
                String srcFileAbsolutePath = file.getAbsolutePath();
                String dstFilePath = srcFileAbsolutePath.replace(folderRootPath, dstRootPath);
                File dstFile = new File(dstFilePath);
                // 根据文件长度决定是否开启线程，单位字节， 1M，大于1M开线程
                if (FileUtils.sizeOf(file) > 1048576) {
                    // 异步拷贝
                    new Thread(new RunnerTask(file, dstFile)).start();
                } else {
                    // 同步拷贝
                    copySingleFile(file, dstFile);
                }
            }
        }
    }
}

/**
 * 多线程任务
 */
class RunnerTask implements Runnable {

    private File srcFile;

    private File dstFile;

    public RunnerTask(File srcFile, File dstFile) {
        System.out.println("RunnerTask.RunnerTask: " + srcFile.getAbsolutePath());
        this.srcFile = srcFile;
        this.dstFile = dstFile;
    }

    @Override
    public void run() {
        try {
            System.out.println(FileUtils.byteCountToDisplaySize(srcFile.length()));
            MultiThreadCopyFile.copySingleFile(srcFile, dstFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
