package com.rs.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.rs.utils.Logger;

public class SocketServer {
	
	private static ServerSocket serverSocket;
	
	private  void createServerSocket(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}
	
	private Socket acceptConnect() throws IOException {
		Socket socket = serverSocket.accept();
		Logger.log("WEBSOCKET", "CONNECTED, "+ socket.getInetAddress().getHostAddress());
		return socket;
	}
	
	private void handleConnection(Socket socket) throws IOException {
		try {
			 final InputStream inputStream = socket.getInputStream();
             final InputStreamReader streamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(streamReader);

             // readLine blocks until line arrives or socket closes, upon which it returns null
             String line = null;
             while ((line = br.readLine()) != null) {
                 System.out.println(line);
             }

             sendMessage(socket);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeSocket(socket);
			Logger.log("WEBSOCKET", "Client Disconnected "+ socket.getInetAddress().getHostAddress());
		}
		
	}
	
	public static void sendMessage(Socket socket) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.write("data");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static String inputStreamAsString(InputStream stream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        br.close();
        return sb.toString();
    }
	
	private void closeSocket(Socket socket) throws IOException {
		socket.close();
	}

	public static void main(String[] args) throws IOException{
		try {
			
			SocketServer server = new SocketServer();
			server.createServerSocket(4999);
			
			while(true) {
				Socket socket = server.acceptConnect();
				server.handleConnection(socket);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		 
		 
	 }
 
}
