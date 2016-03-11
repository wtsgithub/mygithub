package com.wt.test.dao;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class FindJsonDao {
	public String getJsonById(String id) throws Exception
	{
		String json=null;
		if(id==null||id.length()!=24)
			return null;
		MongoCollection	mc=MongoDbCollection.getDBCollection("spring_test");
		FindIterable res;
		try{
			res=mc.find(new BasicDBObject("_id",new ObjectId(id)));
			}catch(Exception e)
			{
				return null;
			}
		if(res.iterator().hasNext())
		{
			json=((Document)res.iterator().next()).toJson();
		}
		return json;
	}
	public String[] getAllJson() throws Exception
	{
		List<String> jsons=new LinkedList<String>();
		MongoCollection	mc=MongoDbCollection.getDBCollection("spring_test");
		FindIterable res=mc.find();
		MongoCursor ite=res.iterator();
		while(ite.hasNext())
		{
			jsons.add(((Document)ite.next()).toJson());
		}
		
		return jsons.toArray(new String[jsons.size()]);
	}
	
}
