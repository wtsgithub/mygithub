package com.wt.test;

import java.util.Map;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wt.test.dao.JsonDataDao;
import com.wt.test.entities.User;


//属性名字是user的或者值是属于String类型的Map键值对都会保存到Session域，
//测试ModelAttributes的时候注销，不然抛出异常
@RequestMapping("/springmvc")
@Controller
public class SpringMVCtest {
	
//	@RequestMapping(value="/testPOJO")
//	public String testPOJO(User user) throws Exception{
//		System.out.println("testPOJO:"+user);
//		JsonDataDao jdd=new JsonDataDao();
//		jdd.saveData(user);
////		map.put("id", jdd.findDataID(Document.parse(tjs.toString())));
//		return "success";
//	}
	
	@RequestMapping(value="/testJsonParams",method=RequestMethod.POST)
	public String testJsonParams(@RequestParam(value="jsonStr") String json,Map<String, Object> map) throws Exception{
		System.out.println("jsonData:"+json);
		JsonDataDao jdd=new JsonDataDao();
		jdd.saveData(json.toString());
		String id=jdd.findDataID(Document.parse(json.toString()));
		map.put("id",id);
		System.out.println("id="+id);
		return "success";
	}
	
	@RequestMapping(value="/testt",method=RequestMethod.POST)
	public String testt(@RequestBody String code,Map<String, Object> map) throws Exception{
		System.out.println(code);
		JsonDataDao jdd=new JsonDataDao();
		jdd.saveData(code.toString());
		System.out.println("id="+jdd.findDataID(Document.parse(code.toString())));
		return "success";
	}
	
}
