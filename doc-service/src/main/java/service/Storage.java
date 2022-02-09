package main.java.service;

import main.java.entities.Document;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Document> hotTiers = new ArrayList<>();
    private static List<Document> coldTiers = new ArrayList<>();
    public static List<Document> docs = new ArrayList<>();

    public static void addToHotTier(Document document) {
        hotTiers.add(document);
    }

    public static void addToColdTiers(Document document) {
        coldTiers.add(document);
    }

    public static void saveDocuments() {
        docs.addAll(hotTiers);
        docs.addAll(coldTiers);

    }

    public  static void saveDoc(String tier, Document document) {
        if(tier.equals("HOT_TIER"))
            addToHotTier(document);
        else{
            addToColdTiers(document);
        }
        saveDocuments();
    }

}
