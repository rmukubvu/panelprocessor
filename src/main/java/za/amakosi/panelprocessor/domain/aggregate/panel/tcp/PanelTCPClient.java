package za.amakosi.panelprocessor.domain.aggregate.panel.tcp;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class PanelTCPClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void openConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendMessage(String msg) {
        out.println(msg);
        String resp = null;
        try {
            resp = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
