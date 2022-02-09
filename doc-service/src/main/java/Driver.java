package main.java;

import main.java.entities.User;
import main.java.service.DocumentService;

public class Driver {
    public static void main(String[] args) {
        User john = new User("John");
        User kim = new User("Kim");
        DocumentService service = new DocumentService();
        service.createDocument("Doc1", "doc1 content", john.getUserId(), "HOT_TIER");
        service.createDocument("doc2","", john.getUserId(), "COLD_TIER");
        service.updateDocument("doc2","new Content", john.getUserId());
//        service.grantGlobalAccess("name");
        service.readDocument("Doc1", kim.getUserId());
    }
}
