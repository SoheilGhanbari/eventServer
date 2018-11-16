package com.ingestion.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private DataInputStream dInputStream;
    private DataOutputStream dOutputStream;
    private Socket s;
    ClientHandler(Socket s,DataInputStream dInputStream, DataOutputStream dOutputStream){
        this.dInputStream =dInputStream;
        this.s =s;
        this.dOutputStream = dOutputStream;
    }
    @Override
    public void run() {
        while (true){
            try {
                dOutputStream.writeUTF("Whats your name?");
                String req =dInputStream.readUTF();
                System.out.println(req);
                switch (req){
                    case "Soheil":
                        dOutputStream.writeUTF("you are Soheil");
                        break;
                    case "Somayeh":
                        dOutputStream.writeUTF("You are Somayeh");
                        break;
                    default:
                        dOutputStream.writeUTF("I dont Know you");
                        break;
                }

            } catch (IOException e){
                System.out.println("hey this is a exception" + e);
                break;
            }
        }
        try {
            this.dOutputStream.close();
            this.dInputStream.close();
            this.s.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
