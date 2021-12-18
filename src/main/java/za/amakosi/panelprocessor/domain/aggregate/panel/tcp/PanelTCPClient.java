package za.amakosi.panelprocessor.domain.aggregate.panel.tcp;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class PanelTCPClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    @SneakyThrows
    public void startConnection(String ip, int port) {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @SneakyThrows
    public String sendMessage(String msg) {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    @SneakyThrows
    public void stopConnection() {
        in.close();
        out.close();
        clientSocket.close();
    }
}
