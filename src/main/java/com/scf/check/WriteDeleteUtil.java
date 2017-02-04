package com.scf.check;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xuxin on 17/1/20.
 */

public class WriteDeleteUtil
{
    public static void deleteFile(String pathString)
    {
        File file = new File(pathString);
        if ((file.exists()) && (file.isFile()))
            file.delete();
    }

    public static void writeFile(String pathString) {
        File file = new File(pathString);
        BufferedWriter bufferedWriter = null;
        try {
            deleteFile(pathString);
            file.createNewFile();
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write(i + "\n");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String pathString, String str) { File file = new File(pathString);
        BufferedWriter bufferedWriter = null;
        try {
            file.createNewFile();
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(str + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDirection(String pathString){
        File file=new File(pathString);
        if (!file.isDirectory()) {
              file.mkdirs();
        }
    }
}
