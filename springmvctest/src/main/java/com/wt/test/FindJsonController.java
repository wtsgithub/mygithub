package com.wt.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wt.test.dao.FindJsonDao;

@Controller
@RequestMapping(value="/find")
public class FindJsonController {
	@RequestMapping(value="/jsonbyid",method=RequestMethod.GET)
	public String findJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String id=request.getParameter("id");
		String json=null;
		FindJsonDao fdao=new FindJsonDao();
		json=fdao.getJsonById(id);
		request.setAttribute("json", json);
		request.setAttribute("by", "id");
		return "find";
	}
	@RequestMapping(value="/alljson",method=RequestMethod.GET)
	public String findAllJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String id=request.getParameter("id");
		String[] json=null;
		FindJsonDao fdao=new FindJsonDao();
		json=fdao.getAllJson();
		request.setAttribute("json", json);
		request.setAttribute("by", "all");
		return "find";
	}
}
