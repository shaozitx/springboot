package com.yhshao.springboot.plugin;

import com.yhshao.springboot.util.FileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shaoqi on 18/2/9.
 */
public class CopyFolderUtil {

    static long currentFileSizeCopied = 0;
    static long sumfilessize = 0;
    public static void main(String[] args){

        JFrame j = new JFrame();
        j.setBounds(100,100,600,150);
        j.setLayout(null);

        JLabel j1 = new JLabel("源文件地址:");
        j.add(j1);
        j1.setBounds(20,30,120,20);

        JTextField jt = new JTextField("/Users/ouyangzhi/.m2");
        j.add(jt);
        jt.setBounds(100,30,180,20);

        JLabel j2 = new JLabel("复制到:");
        j.add(j2);
        j2.setBounds(jt.getX()+5+jt.getWidth(),30,120,20);

        JTextField jt1 = new JTextField("/Users/ouyangzhi/1");
        j.add(jt1);
        jt1.setBounds(j2.getX()+50,30,180,20);

        JButton jb = new JButton("开始复制");
        jb.setBounds(20,j1.getY() + j1.getHeight()+5,80,20);
        j.add(jb);

        JLabel j3 = new JLabel("文件复制进度:");
        j.add(j3);
        j3.setBounds(jb.getX()+5+jb.getWidth(),jb.getY(),120,20);

        JProgressBar pb = new JProgressBar();

        pb.setBounds(j3.getX()+j3.getWidth()+5,jb.getY(),180,20);
        //进度条最大100
        pb.setMaximum(100);
        //当前进度是50
        pb.setValue(0);
        //显示当前进度
        pb.setStringPainted(true);
        j.add(pb);


        // 给按钮 增加 监听
        jb.addActionListener(new ActionListener() {
            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            public void actionPerformed(ActionEvent e) {
                // 1.获取两个路径
                String src = jt.getText();
                String toFile = jt1.getText();
                sumfilessize = (long)FileUtil.getDirSize(new File(src))*1024*1024;

                new Thread(() -> copyFolder(src,src,toFile)).start();
            }
            // 复制全部文件夹和文件
            public  void copyFolder(String firFolder,String srcFolder, String destFolder){
                String sepa = java.io.File.separator;
                File f = new File(destFolder);

                if (!f.exists()) f.mkdirs();

                File srcf = new File(srcFolder);
                for (File f1:srcf.listFiles()) {
                    if (f1.isDirectory()){  // 是文件夹就继续进入
                        copyFolder(firFolder,f1.getAbsolutePath(),destFolder);
                    }else { // 如果是文件就直接复制过去
                        String destFile = destFolder + f1.getParent().substring(firFolder.length())+sepa+f1.getName();
                        currentFileSizeCopied+=f1.length();
                        System.out.println(currentFileSizeCopied + "---" + sumfilessize);
                        double i = (double) currentFileSizeCopied/(double) sumfilessize *100;
                        pb.setValue((int)i);
                        if ((int)i == 100)
                            JOptionPane.showMessageDialog(j, "复制完毕");
                        copyFile(f1,new File(destFile));
                    }
                }
            }

            public  void copyFile(File fromFile,File toFile) {

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

        });
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    static int index = 1;




}
