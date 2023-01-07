import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 554;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             Scanner str = new Scanner(System.in);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (!clientSocket.isOutputShutdown()) {
                if (in.ready()) {
                    String resp = in.readLine();
                    System.out.println(resp);
                    out.println(str.next());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

