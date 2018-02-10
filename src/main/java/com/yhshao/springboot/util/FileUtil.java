package com.yhshao.springboot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shaoqi on 18/2/9.
 */
public class FileUtil {


    // 复制全部文件夹和文件
    public static void copyFolder(String firFolder,String srcFolder, String destFolder){
        String sepa = java.io.File.separator;
        File f = new File(destFolder);
        if (!f.exists()) f.mkdirs();

        File srcf = new File(srcFolder);

        for (File f1:srcf.listFiles()) {
            if (f1.isDirectory()){  // 是文件夹就继续进入
                copyFolder(firFolder,f1.getAbsolutePath(),destFolder);
            }else { // 如果是文件就直接复制过去
                String destFile = destFolder + f1.getParent().substring(firFolder.length())+sepa+f1.getName();
                copyFile(f1,new File(destFile));
            }
        }
    }

    public static void copyFile(File fromFile,File toFile) {


        if (!toFile.exists()) {
            toFile.getParentFile().mkdirs();
        }

        try (FileInputStream ins = new FileInputStream(fromFile);
             FileOutputStream out = new FileOutputStream(toFile);) {
            byte[] b = new byte[1024];
            int n = 0;
            while ((n = ins.read(b)) != -1) {
                out.write(b, 0, n);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static double getDirSize(File file) {

        if (!file.exists())
            file.mkdirs();

        //判断文件是否存在
        if (file.exists()) {
            //如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                double size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {//如果是文件则直接返回其大小,以“兆”为单位
                double size = (double) file.length() / 1024 / 1024;
                return size;
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0.0;
        }
    }
}
