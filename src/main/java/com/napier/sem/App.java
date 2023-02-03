package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
public class App {
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");

        // Connect to MongoDB on a local system. We're using port 27000.
        MongoClient mongoClient = new MongoClient("mongo-dbserver");
        // Get a database. Will create when we use it.
        MongoDatabase database = mongoClient.getDatabase("mydb");
        // Get a collection from the database.
        MongoCollection<Document> collection = database.getCollection("test");
        // Create a document to store.
        Document doc = new Document("name", "Maya Peretz")
                .append("class", "Software Engineering Methods")
                .append("year", "2023")
                .append("result", new Document("CW", 65).append("EX", 85));
        // Add document to the collection.
        collection.insertOne(doc);

        //Check document in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}
