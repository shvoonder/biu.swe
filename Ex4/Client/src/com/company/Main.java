package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Socket socket = null;
        Scanner fromServerIS;
        PrintStream toServerOS;
        Scanner s = new Scanner(System.in);
        try{
                socket = new Socket("localhost", 7000);
                fromServerIS = new Scanner(socket.getInputStream());
                toServerOS = new PrintStream(socket.getOutputStream());
                while (true) {
                    System.out.println(fromServerIS.nextLine());
                    int input = s.nextInt();
                    toServerOS.println(input);
                    switch (input) {
                        case 1:
                            System.out.println(fromServerIS.nextLine());
                            input = s.nextInt();
                            toServerOS.println(input);
                            System.out.println(fromServerIS.nextLine());
                            break;
                        case 2:
                            System.out.println(fromServerIS.nextLine());
                            input = s.nextInt();
                            toServerOS.println(input);
                            input = s.nextInt();
                            toServerOS.println(input);
                            break;
                        case 3:
                            System.out.println(fromServerIS.nextLine());
                            input = s.nextInt();
                            toServerOS.println(input);
                            break;
                        case 4:
                            System.out.println(fromServerIS.nextLine());
                            input = s.nextInt();
                            toServerOS.println(input);
                            break;
                        case 5:
                            System.out.println(fromServerIS.nextLine());
                            break;
                        case 6:
                            socket.close();
                            break;
                    }
                }
        }
        catch (IOException e){}
    }
}
