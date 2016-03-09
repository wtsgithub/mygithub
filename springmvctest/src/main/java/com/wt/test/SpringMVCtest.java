package com.wt.test;


import java.util.Map;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wt.test.dao.JsonDataDao;


//属性名字是user的或者值是属于String类型的Map键值对都会保存到Session域，
//测试ModelAttributes的时候注销，不然抛出异常
@RequestMapping("/springmvc")
@Controller
public class SpringMVCtest {
	
//	@RequestMapping(value="/testPOJO",method=RequestMethod.POST)
//	public String testPOJO(TestJsonString tjs,Map<String, Object> map) throws Exception{
//		System.out.println("testPOJO:"+tjs);
//		JsonDataDao jdd=new JsonDataDao();
//		jdd.saveData(tjs.toString());
////		map.put("id", jdd.findDataID(Document.parse(tjs.toString())));
//		return "success";
//	}
	
//	@RequestMapping(value="/testJsonParams",method=RequestMethod.POST)
//	public String testJsonParams(@RequestParam(value="jsonData") String json){
//		System.out.println("jsonData:"+json);
//		return "success";
//	}
	
	@RequestMapping(value="/testt",method=RequestMethod.POST)
	public String testt(@RequestBody String code) throws Exception{
		System.out.println(code);
		JsonDataDao jdd=new JsonDataDao();
		jdd.saveData(code.toString());
		System.out.println("id="+jdd.findDataID(Document.parse(code.toString())));
		return "success";
	}
	
}
