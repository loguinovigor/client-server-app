import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080; // Выберите порт в доступном диапазоне
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket clientSocket = serverSocket.accept(); // Ждем подключения
            System.out.println("New connection accepted");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            final String name = in.readLine();
            System.out.println("Received: " + name);

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
