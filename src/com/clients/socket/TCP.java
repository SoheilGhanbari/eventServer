package com.clients.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCP {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("localhost");
        try (Socket s = new Socket(ip,1212)){
            Scanner scn = new Scanner(System.in);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din= new DataInputStream(s.getInputStream());
            while (true){

                String received = din.readUTF();
                System.out.println(received);
                String tosend = scn.nextLine();

                dout.writeUTF(tosend);
                if (tosend.equals("Exit")) {
                    System.out.println("the connection closed!");
                    break;
                }
            }
            dout.close();
            din.close();
        }
        catch (Exception e){
           System.out.println(e);
        }
    }
}
