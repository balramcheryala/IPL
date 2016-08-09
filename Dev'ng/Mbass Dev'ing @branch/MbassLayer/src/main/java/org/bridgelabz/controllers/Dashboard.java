package org.bridgelabz.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.bridgelabz.form.CustomerDTO;
import org.bridgelabz.form.Projectname;
import org.bridgelabz.model.Projects;
import org.bridgelabz.service.ProjectService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller("project")

// This controller is used to control and handle all the activities related to
// creation of an app page.
public class Dashboard 
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProjectService projectService;
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz1234567890";
	private static final int RANDOM_STRING_LENGTH = 4;
	
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bridgelabz";
    
    static final String USER = "root";
    static final String PASS = "bridgeit";
    
    String k;
	// This method is used to display the blank uninitiated project creation
	// form.
	@SuppressWarnings("unchecked")
	/*
	 * @RequestMapping(method=RequestMethod.GET) public String Showform(Map
	 * model) { Projectname projectcreate=new Projectname();
	 * model.put("projectcreate", projectcreate); System.out.println("mlp");
	 * return "projectcreation"; }
	 */
	@RequestMapping(value="/overview")
	 public ModelAndView displaydashboard(@RequestParam(value="projectname", required=true) String pName,Projectname projectname)
	 {
		System.out.println("123345");
		 Map<String, Object> model = new HashMap<String, Object>();	
		 model.put("projectname",pName);
		 return new ModelAndView("projectoverview",model);
	 }
	@RequestMapping(value="/projectlist")
	public ModelAndView listofprojects()
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("Projectlist", projectService.displayallnames());
		return new ModelAndView("Projectlist", model);
	}
	@RequestMapping(value = "/addmbaas" ,method=RequestMethod.GET)
	public String downloadjson(@RequestParam(value = "packagename", required = true) String packagename) 
	{
		
		Connection conn3=null;
		 try {
        	 String DB_URL3 = "jdbc:mysql://localhost:3306/"+k;
        	 conn3= DriverManager.getConnection(DB_URL3, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("hii");
			e.printStackTrace();
		}
        System.out.println("insertig data in table...");
        /*Statement stmt=null;
        try {
			stmt = conn3.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		String filePath = projectService.retrievejsondetails(k);
        System.out.println(filePath);
        System.out.println(packagename);
        String sql3 = "INSERT INTO APPCONFIG (packagename,configfile) values (?, ?)";
        
		try {
			PreparedStatement statement = conn3.prepareStatement(sql3);
			statement.setString(1, packagename);
			InputStream inputStream = new FileInputStream(new File(filePath));
			statement.setBlob(2, inputStream,new File(filePath).length());
			statement.executeUpdate();
			System.out.println("hii4");
			statement.close();
			conn3.close();
		} catch (Exception e1) {
			System.out.println("hii2");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       /* try {
			statement.setString(1, packagename);
		} catch (SQLException e1) {
			System.out.println("hii3");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //statement.setString(2, "Eagar");
        InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("hii4");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

       /* try {
			statement.setBlob(2, inputStream);
		} catch (SQLException e) {
			System.out.println("hii5");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

       /* int row = 0;
		try {
			row = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (row > 0) {
            System.out.println("A file was inserted with all config details.");
        }*/
     /*   try {
        	statement.close();
			conn3.close();
		} catch (SQLException e) {
			System.out.println("hii6");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("789");
	/*	ArrayList<CustomerDTO> arr=new ArrayList<CustomerDTO>();
		System.out.println("1");
		arr=getAllCustomers();
		System.out.println(arr);
		System.out.println("2");
		model.put("projectdetails", arr); 
		System.out.println("3");
		System.out.println("mlpre");
		return "projectconfig"; */
		return "projectconfig";
    } 
	/**
	 * A servlet that retrieves a file from MySQL database and lets the client
	 * downloads the file.
	 * @author www.codejava.net
	 */
	@WebServlet("/downloadFileServlet")
	//@RequestMapping(value="/downloadFileServlet")
	public class DBFileDownloadServlet extends HttpServlet {
	 
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// size of byte buffer to send file
	    private static final int BUFFER_SIZE = 4096;   
	     
	    // database connection settings
	    private String dbURL = "jdbc:mysql://localhost:3306/"+k;
	    private String dbUser = "root";
	    private String dbPass = "bridgeit";
	     
	    protected void doGet(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	        // get upload id from URL's parameters
	        int uploadId = 2;
	        System.out.println(uploadId);
	       /* Integer.parseInt(request.getParameter("id")) */
	        Connection conn = null; // connection to the database
	         
	        try {
	            // connects to the database
	            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	             try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	 
	            // queries the database
	            String sql = "select * from APPCONFIG";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            //statement.setInt(1, uploadId);
	 
	            ResultSet result = statement.executeQuery();
	            if (result.next()) {
	                // gets file name and file blob data
	                String fileName = result.getString("packagename");
	                Blob blob = result.getBlob("configfile");
	                InputStream inputStream = blob.getBinaryStream();
	                int fileLength = inputStream.available();
	                 
	                System.out.println("fileLength = " + fileLength);
	 
	                ServletContext context = getServletContext();
	 
	                // sets MIME type for the file download
	                String mimeType = context.getMimeType(fileName);
	                if (mimeType == null) {        
	                    mimeType = "application/octet-stream";
	                }              
	                 
	                // set content properties and header attributes for the response
	                response.setContentType(mimeType);
	                response.setContentLength(fileLength);
	                String headerKey = "Content-Disposition";
	                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
	                response.setHeader(headerKey, headerValue);
	 
	                // writes the file to the client
	                OutputStream outStream = response.getOutputStream();
	                 
	                byte[] buffer = new byte[BUFFER_SIZE];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outStream.write(buffer, 0, bytesRead);
	                }
	                 
	                inputStream.close();
	                outStream.close();             
	            } else {
	                // no file found
	                response.getWriter().print("File not found for the id: " + uploadId);  
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            response.getWriter().print("SQL Error: " + ex.getMessage());
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            response.getWriter().print("IO Error: " + ex.getMessage());
	        } finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }          
	        }
	    }
	}
	
	/*public ArrayList<CustomerDTO> getAllCustomers() 
	{
	    ArrayList<CustomerDTO> customers = new ArrayList<CustomerDTO>();
	    CustomerDTO customer = new CustomerDTO();
	    System.out.println("getcustomers");
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("getcustomers1");
	    	String dburl="jdbc:mysql://localhost:3306/"+k;
	    	System.out.println("getcustomers2");
	        Connection con=DriverManager.getConnection(dburl, "root", "bridgeit");
	        System.out.println("getcustomers3");
	        PreparedStatement ps=con.prepareStatement("select * from APPCONFIG");
	        System.out.println("getcustomers4");
	        ResultSet rs=ps.executeQuery();
	        System.out.println("getcustomers5");
	        while (rs.next()) {
	        	System.out.println("getcustomers6");
	            customer.setPersonid(rs.getInt("personid"));
	            System.out.println("getcustomers7");
	            customer.setPackagename(rs.getString("packagename"));
	            System.out.println("getcustomers8");
                customer.setConfigfile(rs.getBlob("configfile"));
                System.out.println("getcustomers9");
	            customer.setAddress(rs.getString("address"));
	            customer.setPhone(rs.getString("phone"));
	            customer.setEmail(rs.getString("email"));
	            customer.setBountPoints(rs.getInt("bonuspoint"));
	            customer.setTotalsale(rs.getInt("totalsale"));
                System.out.println("getcustomers10");
	            customers.add(customer);
	        }
	        System.out.println("getcustomers11");
	        rs.close();
	        System.out.println("getcustomers12");
	    } catch (Exception e) 
	    {
	    	System.out.println("getcustomers13");
	        System.out.println(e);
	    }
	    System.out.println("getcustomers14");
	    return customers;
	}
	*/
	// This method is used to process the entered login data.
	@RequestMapping(value = "/project")
	public ModelAndView processForm(@RequestParam(value = "name", required = true) String fieldName,
			Projectname projectname) {
		System.out.println("value from js " + fieldName);

		Map<String, Object> model = new HashMap<String, Object>();
		/*
		 * BindingResult result=null; //@ModelAttribute("projectcreation")
		 * //modelAttribute="projectcreation" System.out.println("plm"); if
		 * (result.hasErrors()) { System.out.println("5");
		 * System.out.println(projectname.getProjectName()); return
		 * "projectcreation"; }
		 */
		projectname.setProjectName(fieldName);
		System.out.println(projectname.getProjectName());
		boolean pnameexists = projectService.checkPName(projectname.getProjectName());
		System.out.println("result :" + pnameexists);
		if (!pnameexists) {
			System.out.println("568vhb");

			Projects project = prepareModel(projectname);
			System.out.println("i am");
			projectService.addProject(project);
			model.put("Projectlist", projectService.retrieveProjectNames(project.getProjectName()));
			System.out.println("we are");
			return new ModelAndView("Projectlist", model);
		} else {
			/*
			 * result.rejectValue("projectName","nameexist",
			 * "Project Name already exists...Not Available"); return
			 * "projectcreation";
			 */
			System.out.println("checking ping...");
			return new ModelAndView("demo", model);
		}
	}

	private Projects prepareModel(Projectname projectname) {
		Projects project = new Projects();
		project.setProjectName(projectname.getProjectName());
		UUID uidprojectnumber = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		project.setProjectNumber(uidprojectnumber.randomUUID().toString());
		 k = project.getProjectName()+ generateRandomString();
		project.setProjectURL("http://localhost:8085/MbassLayer/" + k);
		project.setSchemaName(k);
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection conn=null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement s=null;
		try {
			s =  conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	String database="CREATE SCHEMA "+k;
			s.executeUpdate(database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("database created....");
        try {
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection conn1=null;
        try {
        	 String DB_URL1 = "jdbc:mysql://localhost:3306/"+k;
			conn1= DriverManager.getConnection(DB_URL1, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Creating table in given database...");
        Statement stmt=null;
        try {
			stmt = conn1.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String sql = "CREATE TABLE APPS " +
                     "(appid INTEGER not NULL, " +
                     " appname VARCHAR(255), " + 
                     " appkey VARCHAR(255), " + 
                     " appsecret INTEGER, " +
                     " provider VARCHAR(255),"+
                     " PRIMARY KEY ( appid ))"; 
        String sql1 = "CREATE TABLE ProjectUser " +
                "(projectid INTEGER not NULL, " +
                " emailid VARCHAR(255), " + 
                " password VARCHAR(255), " + 
                " createddate DATE, " + 
                " PRIMARY KEY ( projectid ))"; 
        String sql2 = "CREATE TABLE APPCONFIG " +
                "(personid int(11) NOT NULL AUTO_INCREMENT,"+
                " packagename VARCHAR(255), " + 
                " configfile blob,"+
                " PRIMARY KEY ( personid ))"; 

        try {
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not executed...");
			e.printStackTrace();
		}
        try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			conn1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}

	public String generateRandomString() {

		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}

	private int getRandomNumber() 
	{
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) 
	        {
	            return randomInt;
	        } else 
	        {
	            return randomInt - 1;
	        }
	}
    
}
