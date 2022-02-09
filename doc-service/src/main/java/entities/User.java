package main.java.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String name;
    List<Document> documentList;

    private int autoId=1;

    public User(String name) {
        this.userId = getAutoId();
        this.name = name;
        this.documentList = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private synchronized int getAutoId() {
        return this.autoId++;
    }
}
