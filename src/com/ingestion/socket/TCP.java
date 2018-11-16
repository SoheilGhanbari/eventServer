package com.ingestion.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCP
{
    public static void main(String[] args) throws IOException{
       try(ServerSocket ss = new ServerSocket(1212)){
           while (true){
               Socket s = ss.accept();
               System.out.println("A new client is connected : " + s);
               DataInputStream dInputStream = new  DataInputStream(s.getInputStream());
               DataOutputStream dOutputStream = new  DataOutputStream(s.getOutputStream());
               Runnable ch = new ClientHandler(s, dInputStream, dOutputStream);
               Thread th = new Thread(ch);
               System.out.println("thread ID : "+ th.getId()+" thread Name : "+th.getName() +"state :"+ th.getState());
               th.start();
           }
       }
       catch (Exception e){
           System.out.println("Throws exception"+ e);
       }
    }

}
