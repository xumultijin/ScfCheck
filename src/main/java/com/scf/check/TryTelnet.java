package com.scf.check;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by xuxin on 17/1/20.
 */

/*InetAddress inetAddress;
        try {
        //inetAddress=InetAddress.getLocalHost();
        inetAddress=InetAddress.getByName("m.zhuanzhuan.58.com");
        System.out.println("ip="+inetAddress.getHostAddress());
        System.out.println("hostName="+inetAddress.getHostName());
        }catch (Exception e){
        e.printStackTrace();
        }*/

public class TryTelnet
{
    static boolean telnet(String ip, int port)
    {
        try
        {
            Socket server = new Socket();
            InetSocketAddress address = new InetSocketAddress(ip, port);
            server.connect(address, 3000);
            server.close();
            return true;
        }
        catch (UnknownHostException e) {
            return false;
        }
        catch (IOException e) {
            return false;
        }
    }
}
