package com.example.log;

import java.io.File;

/**
 * @author bean wanghb_prm@si-tech.com.cn
 * @Title Rename.java
 * @Project demo-log
 * @Description
 * @create 2018-05-30
 */
public class Rename {
    public static String[] getFileName(String path) {
        File file = new File(path);
        String[] fileName = file.list();
        System.out.println("--- 文件数 ：" + fileName.length);
        return fileName;
    }

    public static void renameFile(String path, String oldname, String newname) {
        if (!oldname.equals(newname)) {//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile = new File(path + "\\" + oldname);
            File newfile = new File(path + "\\" + newname);
            if (!oldfile.exists()) {
                return;//重命名文件不存在
            }
            if (newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                System.out.println(newname + "已经存在！");
            else {
                oldfile.renameTo(newfile);
            }
        } else {
            System.out.println("新文件名和旧文件名相同...");
        }
    }

    public static void main(String[] args) {
        String path = "D:\\安装包\\toppic";
        String path1 = "D:\\安装包\\toppic\\new";
        String[] fileName = getFileName(path);//<span style="font-family: Arial, Helvetica, sans-serif;">此处修改为你的本地路径</span>
        for (int i = 0; i < fileName.length; i++) {
            renameFile(path, fileName[i], "pic" + i + ".jpg");//cx修改为你要修改的文件名格式
        }
    }
}
