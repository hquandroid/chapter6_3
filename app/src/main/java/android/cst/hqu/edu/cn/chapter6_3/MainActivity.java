package android.cst.hqu.edu.cn.chapter6_3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainActivity extends Activity {
    private final int remotePort=5645;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView=findViewById(R.id.txtView);
        new Thread(){


            @Override
            public void run() {
                int i=0;
                try {
                    DatagramSocket ds=new DatagramSocket(remotePort);
                    InetAddress serverAddress=InetAddress.getByName("192.168.31.59");
                    String str="hello";
                    byte[] buffer=str.getBytes();
                    DatagramPacket dp=new DatagramPacket(buffer,buffer.length,serverAddress,remotePort);
                    ds.send(dp);
                    } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (SocketException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }.start();

    }
}
