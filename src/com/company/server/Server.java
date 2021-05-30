package com.company.server;

import javax.imageio.IIOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {  //main thread

        System.out.println("server is running....");
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("server socket created");

        while (true){
            //server running forever
            Socket client = serverSocket.accept(); //wait until a client connects
            System.out.println("server accepted a client");

            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();

        }

    }
}

//tomorrow 11.59 PM
//accept user inputs using command line(2 client chatting with 1 server like )
//use a gui for client and server
//encrypt messages between client and the server
//limit the number of clients
//anything ...