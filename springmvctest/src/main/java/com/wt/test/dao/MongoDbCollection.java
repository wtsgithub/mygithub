package com.wt.test.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDbCollection {
	public static MongoCollection getDBCollection(String tableName) throws Exception {

		InputStream in = new MongoDbCollection().getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties p = new Properties();
		p.load(in);
		String host = p.getProperty("host");
		String port = p.getProperty("port");
		String db_name = p.getProperty("db_name");
		String user = p.getProperty("user", null);
		String password = p.getProperty("password", null);

		System.out.println("user=" + user);
		System.out.println("password=" + password);
		System.out.println("port=" + Integer.parseInt(port));
		System.out.println("host=" + host);
		System.out.println("db_name=" + db_name);

		List<ServerAddress> seeds = new ArrayList<ServerAddress>();
		ServerAddress sa = new ServerAddress(host, Integer.parseInt(port));
		seeds.add(sa);
		List<MongoCredential> options = new ArrayList<MongoCredential>();
		MongoCredential mct = MongoCredential.createCredential(user, db_name, password.toCharArray());
		options.add(mct);
		MongoClient mc = new MongoClient(seeds, options);
		/**
		 * 本地测试
		 */
//		MongoClient mc=new MongoClient(host, Integer.parseInt(port));
//		MongoDatabase md=mc.getDatabase(db_name);
		
		MongoCollection mcn=mc.getDatabase(db_name).getCollection(tableName);
		return mcn;
	}
}
