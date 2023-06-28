package server;

import client2.Condidet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;

import java.util.logging.Logger;
import static server.ServerGui.allCondident;

//import java.util.concurrent.locks.Condition;
/**
 *
 * @author Home
 */
public class HandleClient implements Runnable {
    static Vector<ObjectOutputStream> AllClients = new Vector<ObjectOutputStream>();
    //צינור תקשורת של הלקוח
    Socket socket;
    //המחלקה שמטפלת בקריאה 
    ObjectInputStream inputFormClient;
    //כתיבה
    ObjectOutputStream outputFormClient;

    public HandleClient(Socket socket) throws IOException {
        this.socket = socket;
        //בבנאי מקבל את הכתובת שאליו יקרא או יכתוב
    }
    @Override
    public void run() {
        try {
            inputFormClient = new ObjectInputStream(socket.getInputStream());
            outputFormClient = new ObjectOutputStream(socket.getOutputStream());
            AllClients.add(outputFormClient);
            outputFormClient.writeObject(allCondident);
            System.out.println("    run start");
            while (true) {
                try {
                    
                    Condidet c = new Condidet();
                    //מקבל את הלחיצה של המשתמש ובודק למי הוא לחץ
                    System.out.println("  start while");
                    c = (Condidet) inputFormClient.readObject();
                    System.out.println(c.getNumOfVote());
                    update(c);
                    //1 
//                    c.setId("1");
                    System.out.println(c.getNumOfVote());
                    outputFormClient.writeObject(c);
//                    c.setId("0");
                    sendToAllClients(c);
                } catch (IOException ex) {
                    Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //עובר על המערך של המועמדים ובודק למי הוא לחץ ואז מוסיף לו קו 
    public void update(Condidet c) {
        for (Condidet condidet : ServerGui.allCondident) {
            System.out.println(c.getName_condidet());
            System.out.println(condidet.getName_condidet());
            if (c.getName_condidet().trim().equals(condidet.getName_condidet().trim())) {
                synchronized (condidet) {
                    c.setNumOfVote(condidet.getNumOfVote() + 1);
                    condidet.setNumOfVote(c.getNumOfVote());
                }
            }
        }
    }

    private void sendToAllClients(Condidet c) throws IOException {
        for (int i = 0; i < AllClients.size(); i++) {
            System.out.println("send..." + c);
            c.setId(null);
            AllClients.elementAt(i).writeObject(c);
        }
    }
}
