package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static Vector<Integer> numbers = new Vector<Integer>();

    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(7000);
        while (true){
            final Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        int option = 0;
                        while (option!=6) {
                            PrintStream outputStream = new PrintStream(socket.getOutputStream());
                            outputStream.println("1. Get 2. Set 3. Add 4. Remove 5. Print 6. Goodbye");
                            Scanner inputS = new Scanner(socket.getInputStream());
                            int index;
                            int value;
                            option = inputS.nextInt();
                            switch (option) {
                                case 1:
                                    outputStream.println("Insert index");
                                    index = inputS.nextInt();
                                    if ((numbers.size()<index))
                                        outputStream.println("Vector too short");
                                    else
                                        outputStream.println(numbers.get(index));
                                    break;
                                case 2:
                                    outputStream.println("Insert index and value");
                                    index = inputS.nextInt();
                                    value = inputS.nextInt();
                                    numbers.set(index, value);
                                    break;
                                case 3:
                                    outputStream.println("Insert value");
                                    value = inputS.nextInt();
                                    numbers.add(value);
                                    break;
                                case 4:
                                    outputStream.println("Insert index");
                                    index = inputS.nextInt();
                                    if ((numbers.size()<index))
                                        outputStream.println("Vector too short");
                                    else
                                        numbers.remove(index);
                                    break;
                                case 5:
                                    outputStream.println(numbers.toString());
                                    break;
                                case 6:
                                    outputStream.println("Connection closed");
                                    break;
                            }
                        }
                    }
                    catch (IOException e){
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }
}
