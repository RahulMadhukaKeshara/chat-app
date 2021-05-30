package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {

        try {

           // Thread.sleep(15000);//wait 15secs  before  executing the rest of the code

            //receive some data from client
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //continuous reading data from the client
            String inputData;
            while ((inputData = bufferedReader.readLine()) != null){
                System.out.println("client says:" + inputData);

                if (inputData.equals("exit")){
                    outputStream.writeBytes( "See you soon ....\n");
                    break;
                }

                else{
                    //send data to the client
                    Scanner in = new Scanner(System.in);
                    String msg = in.nextLine();
                    System.out.println("server says:" + msg);
                    outputStream.writeBytes(msg + "\n");
                }


                /*switch (inputData){
                    case "Hello from the client":
                        outputStream.writeBytes("hello from the server.....\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I'm fine , How are you? \n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("Okay good to know \n");
                        break;
                    case "Thank You":
                        outputStream.writeBytes("You are welcome \n");
                        break;
                    default:
                        outputStream.writeBytes("I cant understand \n");
                        break;
                }

                if (inputData.equals("exit")){
                    break;
                }*/
            }
            this.client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //two ways to create a thread in java
    //1.Extend the class using Thread Super Class
    //2.Implement the class using Runnable interface

}
