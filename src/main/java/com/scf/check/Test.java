package com.scf.check;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xuxin on 17/1/20.
 */

public class Test
{
    public static void main(String[] args)
    {
        try
        {
            try
            {
                if (args[0].equals("getScf"))
                    HandleScf.getScf();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            WriteDeleteUtil.deleteFile("logs/scf_all.log");
            WriteDeleteUtil.deleteFile("logs/scf_error.log");
            WriteDeleteUtil.deleteFile("logs/scf_type_error.log");
            String str = "";
            FileReader reader = new FileReader("logs/scf.txt");
            BufferedReader reader2 = new BufferedReader(reader);
            while ((str = reader2.readLine()) != null) {
                String[] a = str.split("[ ]+");
                if (a.length != 3) {
                    WriteDeleteUtil.writeFile("logs/scf_type_error.log", str + "   格式错误：字符之间的分割不是空格或其他错误");
                }
                else {
                    String scfName = a[0];
                    String scfIp = a[1];
                    String scfPort = a[2];
                    boolean result = TryTelnet.telnet(scfIp, Integer.parseInt(scfPort));
                    WriteDeleteUtil.writeFile("logs/scf_all.log", scfName + " " + scfIp + " " + scfPort + " " + result);
                    if (!result)
                        WriteDeleteUtil.writeFile("logs/scf_error.log", scfName + " " + scfIp + " " + scfPort + " " + "不通");
                }
            }
            reader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
