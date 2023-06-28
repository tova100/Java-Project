/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client2;

/**
 *
 * @author 138
 */

import java.io.Serializable;
import javax.print.DocFlavor;

public class Condidet implements Serializable{
  
    String name_condidet;
    int numOfVote;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Condidet() {
    }

    public Condidet(String name_condidet, int numOfVote) {
        this.name_condidet = name_condidet;
        this.numOfVote = numOfVote;
    }

    public String getName_condidet() {
        return name_condidet;
    }

    public void setName_condidet(String name_condidet) {
        this.name_condidet = name_condidet;
    }
    public int getNumOfVote() {
        return numOfVote;
    }

    public void setNumOfVote(int numOfVote) {
        this.numOfVote = numOfVote;
    }
   
}


