package ej.com.messenger.model.database;

import java.util.ArrayList;

/**
 * Created by 3mill on 2015-05-11.
 */
public class Pojo {

    private int id;

    private String name;

    private ArrayList<Message> messages;

    private ArrayList<String> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }
}
