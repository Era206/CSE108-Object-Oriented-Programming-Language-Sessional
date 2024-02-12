package mypackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    public static List<Car> carList = File.readFile();

    Server() {
        userMap = new HashMap<>();
        userMap.put("a", "a");
        userMap.put("b", "b");
        userMap.put("c", "c");
        userMap.put("d", "d");
        userMap.put("e", "e");
        try {
            serverSocket = new ServerSocket(2000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {

        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        System.out.println("Hello client");

        new ReadThreadServer(userMap, networkUtil);
    }

    public static void main(String[] args) {


        carList=File.readFile();

        new Server();
    }
}
