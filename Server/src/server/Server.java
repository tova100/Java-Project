package server;


import client2.Condidet;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ServerGui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */
public class Server {
         //ערוץ תקשורת
    ServerSocket serversocket;
  
    public Server () {
        
       
        try {
            //מקבל בבנאי  port
            serversocket=new ServerSocket(8000);
        } catch (IOException ex) {
            Logger.getLogger(ServerGui.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
   public Socket Accept(){
        try {
            //ממתין ללקוחות שיתחברו ומחזיר את ערוץ התקשרות של הלקוח
            System.out.println("    accept");
            return serversocket.accept();
        } catch (IOException ex) {
            Logger.getLogger(ServerGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   } 
   
}
//
