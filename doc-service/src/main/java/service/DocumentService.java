package main.java.service;

import main.java.entities.AccessLevel;
import main.java.entities.Document;
import main.java.entities.User;

import java.util.Map;

public class DocumentService {
    //create doc
    //update doc
    //read doc

    public void createDocument(String name, String content, int userId, String tier) {
        Document doc = new Document(name, content, userId, tier);
//        User user = getUserById(userId);
//        user.addDocument(doc);
        displayDocument(doc);
    }

    public void updateDocument(String name, String updatedContent, int userId) {
        Document doc = Document.getDocumentByName(name, userId);
        doc.updateDocument(name, userId,updatedContent);
        displayDocument(doc);
    }

    public void readDocument(String name, int userId) {
        Document doc = Document.getDocumentByName(name,userId);
        displayDocument(doc.readDocument(name,userId));
    }

    public void displayDocument(Document doc) {
        if(doc == null)
            System.out.println("Not a valid request");
        else {
            System.out.println("---------------Display--------------");
            System.out.println("Document Name: "+doc.getName());
            System.out.println("Content: "+doc.getContent());
            System.out.println("Created By: "+doc.getOwner_id());
        }
    }

//    public void grantGlobalAccess(Document doc) {
//        Map<Integer,String> map = doc.getAccessLevelMap();
//        for(Map.Entry<Integer, String> access : map.entrySet()) {
//            map.put(access.getKey(), AccessLevel.EDIT);
//        }
//    }


}
