package mypackage;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private NetworkUtil networkUtil;

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void ConnectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 2000;

        networkUtil = new NetworkUtil("LocalHost", 2000);
        new ReadThread(this);
    }

    public static void main(String[] args) throws IOException {
        Main instance = new Main();
        instance.ConnectToServer();
    }
}
