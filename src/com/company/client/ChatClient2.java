package com.company.client;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();

        //what if you can capture user input using the scanner class???
        /*client.sendMessage("Hello from the client");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank You");
        client.sendMessage("exit");*/

        Scanner in = new Scanner(System.in);

        String msg = "";
        while (!msg.equals("exit") ){
            msg = in.nextLine();
            client.sendMessage(msg);
        }

        System.out.println("Client finished the execution...");



    }

}
