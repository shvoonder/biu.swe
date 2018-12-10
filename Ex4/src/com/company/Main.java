package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Date;
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
                        PrintStream outputStream = new PrintStream(socket.getOutputStream());
                        outputStream.println("1. Get 2. Set 3. Add 4. Remove 5. Print 6. Goodbye");
                        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                        int index;
                        int value;
                        int option = inputStream.readInt();
                        switch (option){
                            case 1:
                                outputStream.println("Insert index");
                                index = inputStream.readInt();
                                outputStream.println(numbers.get(index));
                                break;
                            case 2:
                                outputStream.println("Insert index and value");
                                index = inputStream.readInt();
                                value = inputStream.readInt();
                                numbers.set(index, value);
                                break;
                            case 3:
                                outputStream.println("Insert value");
                                value = inputStream.readInt();
                                numbers.add(value);
                                break;
                            case 4:
                                outputStream.println("Insert index");
                                index = inputStream.readInt();
                                numbers.remove(index);
                                break;
                            case 5:
                                outputStream.println(numbers.toString());
                                break;
                            case 6:
                                break;
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
