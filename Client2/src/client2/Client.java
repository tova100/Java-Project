package client2;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */
public class Client {
    //ערוץ תקשורת
    public Socket socket;
    //קריאה  של אוביקט
    private static ObjectOutputStream toServer;
    //כתיבה של אוביקט
    private static ObjectInputStream fromserver;
    public Client(){
    
        try {
            //כתובת ipconfig  ,באיזה port ירוץ
            socket=new Socket("localhost",8000);
            //היכן לכתוב או לקרא
            toServer=new ObjectOutputStream(socket.getOutputStream());
             fromserver=new ObjectInputStream(socket.getInputStream());
            System.out.println("    success...");
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void writeToserver(Condidet condidet) throws IOException{
        //כתיבה לשרת
       try {
           toServer.writeObject(condidet);
           toServer.flush();
           System.out.println(" after write");
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Condidet readFromserver(){
        try {
            try {
                //קריאה מהשרת
                return (Condidet)fromserver.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
  
    public Condidet[] readFromserver2(){
        try {
            try {
                //קריאה מהשרת
                return (Condidet[])fromserver.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
}

    
    


    
    

