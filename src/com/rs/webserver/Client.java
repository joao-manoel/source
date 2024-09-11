package com.rs.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
  
/**
 * Classe client usada para comunicaçao com o Server.js
 * @author grecolima
 */
public class Client {
  // objeto socket
  private Socket socket = null;
 
  public static void main(String[] args) throws UnknownHostException, 
  IOException, ClassNotFoundException {
    // Instancia classe
    Client client = new Client();
 
    // Conexão socket TCP
    String ip = "localhost";
    int port = 3001;
    client.socketConnect(ip, port);
 
    // Recebe mensagem 
    String mensagem = JOptionPane.showInputDialog("Escreva sua msg: ");
    
    // Escreve mensagem
    System.out.println("Enviando: " + mensagem);
    String retorno = client.echo(mensagem);
    System.out.println("Recebendo: " + retorno);
  }
 
  // Conecta com o socket
  private void socketConnect(String ip, int port) throws UnknownHostException, IOException {
    System.out.println("Conectando socket...");
    this.socket = new Socket(ip, port);
  }           
               
  // escreve e recebe mensagem no socket
  public String echo(String mensagem) {
    try {
    	
      // out & in 
      PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
 
      // escreve string no socket e lê linha
      out.println(mensagem);
      String retorno = in.readLine();
      return retorno;
                
      } catch (IOException e) {
      e.printStackTrace();
    }
               
    return null;
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
  
 
  // obtem instância do socket
  private Socket getSocket() {
              return socket;
  }
}