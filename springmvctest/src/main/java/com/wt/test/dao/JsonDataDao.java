package com.wt.test.dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.wt.test.entities.User;

public class JsonDataDao {

	public JsonDataDao() {

	}

	public void saveData(String json) throws Exception{
		MongoCollection	mc=MongoDbCollection.getDBCollection("spring_test");
		Document document=Document.parse(json);
		mc.insertOne(document);
		System.out.println("save ("+json+") success");
	}
	
	public void saveData(User user) throws Exception{
		MongoCollection	mc=MongoDbCollection.getDBCollection("spring_test");
		Document document=new Document();
		document.put("username", user.getUsername());
		document.put("password", user.getPassword());
		document.put("age", user.getAge());
		document.put("email", user.getEmail());
		mc.insertOne(document);
		System.out.println("save ("+user.toString()+") success");
	}
	
	public String findDataID(Document document) throws Exception{
		String _id="null";
		MongoCollection mc=MongoDbCollection.getDBCollection("spring_test");
		FindIterable fit=mc.find(document);
		MongoCursor mcusor=fit.iterator();
		while(mcusor.hasNext()){
			Document doc=(Document) mcusor.next();
			_id=doc.getObjectId("_id").toString();
		}
		return _id;
	}
}

