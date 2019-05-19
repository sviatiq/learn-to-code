package net;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        for(int i = 0; i<10; i++) {
            sendRequest();
        }
    }

    private static void sendRequest() throws IOException {
        Socket socket = new Socket("127.0.0.1", 25225);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String str ="Sviat";
        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.flush(); //сразу отправляем данные

        String answer = bufferedReader.readLine();
        System.out.println("Client got string: "+answer);

        bufferedReader.close();
        bufferedWriter.close();

    }
}
