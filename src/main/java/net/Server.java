package net;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(25225);
        System.out.println("Server is started!");
        while(true){
            Socket client = socket.accept();// ждем изменений
            handleRequest(client);
        }
    }

    private static void handleRequest(Socket client) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        StringBuilder stringBuilder = new StringBuilder("Hello, ");
        String username = bufferedReader.readLine();
        System.out.println("Server got String: "+ username);
        stringBuilder.append(username);
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush(); //сразу отправляем данные

        bufferedReader.close();
        bufferedWriter.close();

        client.close();
    }
}
