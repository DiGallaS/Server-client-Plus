import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(554)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("New connection accepted");
                out.println("What country are you from?");
                String country = in.readLine();
                out.println("Сhange the language: Yes/No?");
                if (in.readLine().equals("Yes")) {
                    out.println("Ваше имя?");
                    String name = in.readLine();
                    out.println("Ваш возраст?");
                    String age = in.readLine();
                    out.println("Вы работаете: Да/Нет?");
                    String work = in.readLine();
                    if (work.equals("Да")) {
                        out.println(String.format("Привет %s, Удачи на вашей работе", name));
                    } else {
                        out.println(String.format("Привет %s, хватит сидеть за компьютером", name));
                    }
                } else {
                    out.println("Your name?");
                    String name = in.readLine();
                    out.println("Your age?");
                    String age = in.readLine();
                    out.println("You are working: Yes/No?");
                    String work = in.readLine();
                    if (work.equals("Yes")) {
                        out.println(String.format("Hi %s. Good luck at your job", name));
                    } else {
                        out.println(String.format("Hi %s. Stop sitting at the computer", name));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
