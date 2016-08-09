package org.bridgelabz.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bridgelabz.dao.CreationDao;
import org.bridgelabz.model.Projects;

public class CreationDaoImpl implements CreationDao
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean checkProjectName(String projectname) 
	{
		System.out.println("entered2");
		boolean projectFound=false;
		Session session=sessionFactory.openSession();
		String SQL_QUERY =" from Projects as p where p.projectName=? ";
		Query query=session.createQuery(SQL_QUERY);
		query.setParameter(0, projectname);
		List list = query.list();
		if ((list != null) && (list.size() > 0)) 
		{
			System.out.println("43");
			projectFound = true;
		}
		session.close();
		return projectFound;
	}
	public void addProjectName(Projects project)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(project);
		tx.commit();
	}
	public List<String> displayallnames()
	{
		Session session = sessionFactory.openSession();
		 Query query=null;
		 List<String> arrlist=new ArrayList<String>();
		 String SQL_QUERY1=null;
		 System.out.println("kkkkk");
		 SQL_QUERY1 ="FROM Projects E ";
		 query = session.createQuery(SQL_QUERY1);
		 arrlist = query.list();
		 if(arrlist != null  && (arrlist.size() > 0))
		 {
			 System.out.println("ttt");
			 session.close();
			 return arrlist;
		 }
		 return null;
	}
	public String retrievejsondetails(String k)
	{
		String file=null;
		Session session = sessionFactory.openSession();
		 Query query=null;
		 List<String> arrlist=new ArrayList<String>();
		 String SQL_QUERY1=null;
		 System.out.println("kkkkk");
		 SQL_QUERY1 ="FROM Projects E where schemaName=?";
		 
		 query = session.createQuery(SQL_QUERY1);
		 query.setParameter(0, k);
		 arrlist = query.list();
		 Gson gson=new GsonBuilder().serializeNulls().create();
		 String jsonArray=gson.toJson(arrlist);
		 System.out.println(jsonArray);
		 ObjectMapper mapper = new ObjectMapper();
	 	try {
			jsonArray= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrlist);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 PrintWriter out=null;
		try {
			file="/home/bridgelabz/Desktop/"+k+".txt";
			out = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Occurred:");
		}
		 out.println(jsonArray);
		 out.close();
		 return file;
	}
	public List<String> retrieveNames(String yourprojectname) 
	{
		 Session session = sessionFactory.openSession();
		 Query query=null;
		 List<String> arrlist=new ArrayList<String>();
		 String SQL_QUERY1=null;
		 System.out.println("kkkkk");
		 SQL_QUERY1 ="FROM Projects E where projectName=?";
		 
		 query = session.createQuery(SQL_QUERY1);
		 query.setParameter(0, yourprojectname);
		 arrlist = query.list();
		 Gson gson=new GsonBuilder().serializeNulls().create();
		 String jsonArray=gson.toJson(arrlist);
		 System.out.println(jsonArray);
		 ObjectMapper mapper = new ObjectMapper();
	 	try {
			jsonArray= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrlist);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 PrintWriter out=null;
		try {
			out = new PrintWriter("/home/bridgelabz/Desktop/"+yourprojectname+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Occurred:");
		}
		 out.println(jsonArray);
		 out.close();
		// Iterator listiterator = arrlist.iterator();
	    /* while (listiterator.hasNext()) 
	     {
	        System.out.println("541");
	 	    System.out.println(listiterator.next());
	 	 }*/
		 if(arrlist != null  && (arrlist.size() > 0))
		 {
			 System.out.println("ttt");
			 session.close();
			 return arrlist;
		 }
		 return null;
	}
}
