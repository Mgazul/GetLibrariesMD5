package cn.mgazul.getlibrariesmd5;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] strings) {
        folderMethod("libraries");
    }

    public static void folderMethod(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        folderMethod(file2.getPath());
                    } else {
                        try {
                            System.out.println(file2.getPath().replace("\\", "/") + "|" + MD5Util.getMD5(file2) + "|" + file2.length());
                        } catch (NoSuchAlgorithmException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("File does not exist!");
        }
    }
}
