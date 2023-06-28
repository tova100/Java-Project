/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Home
 */
public class ServerGui {
   public static client2.Condidet[] allCondident=new client2.Condidet[3];

    public ServerGui()throws IOException {
        allCondident[0]=new client2.Condidet("שס", 0);
        allCondident[1]=new client2.Condidet("ג", 0);
        allCondident[2]=new client2.Condidet("ליכוד", 0);
        Server s=new Server();
        while(true){
            try {
                Socket ss=s.Accept();
                InetAddress add=ss.getInetAddress();
                System.out.println(" accept client   "+add.getHostAddress());
                Thread thread=new Thread(new HandleClient(ss));
                thread.start();
            } catch (IOException ex) {
                Logger.getLogger(ServerGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
          new ServerGui();
    }
    
}
