package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream fromServerIS;
        PrintStream toServerOS;
        Scanner s = new Scanner(System.in);

        try{
            socket = new Socket("localhost", 7000);
            fromServerIS = new DataInputStream(socket.getInputStream());
            toServerOS = new PrintStream(socket.getOutputStream());
            System.out.println(fromServerIS.readLine());
            String input = s.nextLine();
            toServerOS.println(input);
            System.out.println(fromServerIS.readLine());
        }
        catch (IOException e){}
    }
}
