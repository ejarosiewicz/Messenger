package ej.com.messenger.model.database;

import java.io.Serializable;

/**
 * Created by 3mill on 2015-05-11.
 */
public class Message implements Serializable{

    private int id;
    private String sender;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
