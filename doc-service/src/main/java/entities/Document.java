package main.java.entities;

import main.java.service.Storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {
    private int id;
    private String name;
    private String content;
    private int autoId = 1;
    private int owner_id;

    //store access levels
    Map<Integer, String> accessLevelMap = new HashMap<>();

    public Document(String name, String content, int userId, String tier) {
        this.name = name;
        this.content = content;
        this.id = getAutoIncrementId();
        accessLevelMap.put(userId, AccessLevel.OWNER);
        owner_id = userId;
        Storage.saveDoc(tier, this);
    }

    public Document readDocument(String name, int userId) {
        Document doc = getDocumentByName(name, userId);
        if(doc == null){
            System.out.println("Document does not exist");
            return null;
        }
        else if(!isReadAccess(doc,userId)){
            System.out.println("User does not have access to read");
            return null;
        }
       return doc;
    }

    public Document updateDocument(String name, int userId, String content){
        Document doc = getDocumentByName(name, userId);
        if(isEditAccess(doc,userId) || isOwner(doc, userId)){
            this.content = content;
            return doc;
        } else{
            System.out.println("YOu do not have edit access for the document");
        }
        return null;
    }

    public static Document getDocumentByName(String name, int userId) {
        List<Document> docs = Storage.docs;
        for(Document doc : docs) {
            if(doc.name.equals(name)){
                return doc;
            }
        }
        return null;
    }

    public boolean isReadAccess(Document doc, int userId) {
        for(Map.Entry<Integer, String> access : accessLevelMap.entrySet()) {
            if(access.getKey().equals(userId) && access.getValue().equals(AccessLevel.READ)){
                return true;
            }
        }
        return false;
    }

    public boolean isEditAccess(Document doc, int userId) {
        for(Map.Entry<Integer, String> access : accessLevelMap.entrySet()) {
            if(access.getKey().equals(userId) && access.getValue().equals(AccessLevel.EDIT)){
                return true;
            }
        }
        return false;
    }

    public boolean isOwner(Document doc, int userId) {
        for(Map.Entry<Integer, String> access : accessLevelMap.entrySet()) {
            if(access.getKey().equals(userId) && access.getValue().equals(AccessLevel.OWNER)){
                return true;
            }
        }
        return false;
    }

    public Map<Integer, String> getAccessLevelMap() {
        return accessLevelMap;
    }

    public int getOwner_id() {
        return this.owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public synchronized int getAutoIncrementId() {
        return autoId++;
    }
}
