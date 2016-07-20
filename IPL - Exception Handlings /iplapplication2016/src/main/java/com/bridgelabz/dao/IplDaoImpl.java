package com.bridgelabz.dao;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.PlayerModel;
import com.bridgelabz.model.TeamModel;
@Repository("dd")
public class IplDaoImpl implements IplDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	// Searching Technique
	
		public  ArrayList<?> jsonsearch(String fieldname,String text) 
	  	{
		    new PlayerModel();
		    Session session = sessionFactory.openSession();
			boolean listFound = false;
			Query query;
			String SQL_QUERY =" from PlayerModel as o where o."+fieldname+" LIKE "+ "'%"+text+"%'";
			query = session.createQuery(SQL_QUERY);
			List<?> list = query.list();
			System.out.println("list is :"+list);
			if ((list != null) && (list.size() > 0)) 
			{
				listFound= true;
				System.out.println(listFound);
			}
			session.close();
			return (ArrayList<?>) list;     
		  
	  	}
		
		
		//Sorting Technique
		
		public  List<?> jsonsorting(String field) 
	  	{
		  new PlayerModel();
		  Session session = sessionFactory.openSession();
		  String SQL_QUERY =" from PlayerModel ORDER BY "+field;
		  Query query = session.createQuery(SQL_QUERY);
		  System.out.println("Query executing :"+query);
	      List<?> list = query.list();
	      System.out.println("list is :"+list);
			if ((list != null) && (list.size() > 0)) 
				{
				///
				}
				session.close();
				return list;     
		  
		  	}
		
		
		// Sorting By field name and user VALUE and  
		 public  List<?> jsonsearch(String fieldname,String text,String sortby) 
		  	{
			    new PlayerModel();
			    Session session = sessionFactory.openSession();
				boolean listFound = false;
				Query query;
				if(sortby==null)
				{
					String SQL_QUERY1 =" from PlayerModel as o where o."+fieldname+" LIKE "+ "'%"+text+"%'";
					query = session.createQuery(SQL_QUERY1);
				}
				else
				{
				String SQL_QUERY =" from PlayerModel as o where o."+fieldname+" LIKE "+ "'%"+text+"%'"+" ORDER BY "+sortby;
				query = session.createQuery(SQL_QUERY);
				}
				
		         List<?> list = query.list();
				if ((list != null) && (list.size() > 0)) 
				{
					
					listFound= true;
					System.out.println(listFound);
				}
				session.close();
				return list;     
			  
		  	}

		 //// calling Method 
					
			public ArrayList<PlayerModel> playergenerate(String filepath , String nameplayerlist ) {
			System.out.println("Retriving the List ");
						
			ArrayList<PlayerModel> arraylist=new ArrayList<PlayerModel>();
			JSONParser parser= new JSONParser();
				        
			try {
				        	
				 FileReader fileread=new FileReader(filepath);
				        	
				 Object obj=parser.parse(fileread);
				 JSONArray array =(JSONArray)obj;
				        	
				for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				jsonObject.get("Name").toString();
				JSONArray jsonArray=(JSONArray)jsonObject.get(nameplayerlist);
								
				for (int j = 0; j < jsonArray.size(); j++) {
					PlayerModel player=new PlayerModel();
					JSONObject jsonObjectArray=(JSONObject)jsonArray.get(j);
					player.setName(jsonObjectArray.get("player_name").toString());
					player.setRole(jsonObjectArray.get("player_role").toString());
					player.setBatting(jsonObjectArray.get("player_batting_style").toString());
					player.setBowler(jsonObjectArray.get("player_bowling_style").toString());
					player.setNation(jsonObjectArray.get("player_nationality").toString());
					player.setDob(stringToDate(jsonObjectArray.get("player_dob").toString()));
					arraylist.add(player);
			
					try{
							//save  with transaction in the database
							System.out.println("Entered in try block of save");
							Session session = sessionFactory.openSession();
							Transaction tx1 = session.beginTransaction();
							session.save(player);
							System.out.println("Saved data");
							tx1.commit();
							session.close();
							}catch(Exception e){
							e.printStackTrace();
									}
				
								}
				
				        	}
				        }
				        catch (Exception e) {
				        		
				        System.out.println("File Reading or Duplication Error");
				        }
					
						return arraylist;
					}
					
			
			//GujarathPlayerList 
			
			public ArrayList<PlayerModel> GujratPlayerList(){
				
			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/GujratLionPlayer.json", "GujratPlayerList");
			
			}
			
			//DelhiPlayerList 
		
			public ArrayList<PlayerModel> DelhiPlayerList(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/DelhiPlayer.json", "DelhiPlayerList");
	
			}		
			
			//PunjabPlayerList
			
			public ArrayList<PlayerModel> PunjabPlayerList(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/punjabPlayer.json", "PunjabPlayerList");
	
			}
			
			//KKRPlayer
			
			public ArrayList<PlayerModel> KolkataPlayer(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/KKRPlayer.json", "KKRPlayer");
	
			}
			
			//MumbaiPlayerList
			
			public ArrayList<PlayerModel> MumbaiPlayerList(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/MumbaiPlayer.json", "MumbaiPlayerList");
	
			}
	
			//risingPunePlayerList
			
			public ArrayList<PlayerModel> risingPunePlayerList(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/RisingPunePlayer.json", "PunePlayerList");
	
			}	

			// String to Date
			
			public Date stringToDate(String str){
			DateFormat f = new SimpleDateFormat("dd MMMM yyyy");
    	    try {
    	    	
			return f.parse(str);
			
    	    } catch (java.text.ParseException e) {
			
			e.printStackTrace();
    	    }
    	    return null;
			}

			//royalChallengesPlayerList
			
			public ArrayList<PlayerModel> royalChallengesPlayerList(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/RoyalChallenges.json", "RoyalChallengePlayerList");
	
			}				

			//royalChallengesPlayerList
			
			public ArrayList<PlayerModel> sunriseHydrabadPlayerList(){

			return playergenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLPlayer/SunriseHydrabad.json", "SunRiseHydrabadPlayerList");
	
			}
	
	
/////////////////////////////TeamModel  Method //////////////
			
			public ArrayList<TeamModel> teamgenerate(String filepath , String nameteamlist ) {
			
				ArrayList<TeamModel> arraylist = new ArrayList<TeamModel>();
				JSONParser parser = new JSONParser();

			try {
				FileReader fileread = new FileReader(filepath);
				Object obj = parser.parse(fileread);
				JSONArray array = (JSONArray) obj;

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);
				String name = jsonObject.get("Name").toString();
				System.out.println("json  name"+name);
				JSONArray jsonArray = (JSONArray) jsonObject.get(nameteamlist);
			
			for (int j = 0; j < jsonArray.size(); j++) {
				System.out.println("inner for ");
				TeamModel teammodel = new TeamModel();
				JSONObject jsonObjectArray = (JSONObject) jsonArray.get(j);
				teammodel.setName(jsonObjectArray.get("team_name").toString());
				teammodel.setCouch(jsonObjectArray.get("team_coach").toString());
				teammodel.setCaption(jsonObjectArray.get("team_captain").toString());
				teammodel.setVeneue(jsonObjectArray.get("team_home_venue").toString());
				teammodel.setOwner(jsonObjectArray.get("team_owner").toString());
				arraylist.add(teammodel);
			
			try{
				
				//save  with transaction
				System.out.println("Entered in try block of save");
				Session session = sessionFactory.openSession();
				Transaction tx1 = session.beginTransaction();
				session.save(teammodel);
				System.out.println("Saved data");
				tx1.commit();
				session.close();
				
				}catch(Exception e){
				e.printStackTrace();
					}
				}
				Iterator<TeamModel> itr = arraylist.iterator();
				while (itr.hasNext()) {
				
						}
					}
				} catch (Exception e) {
				e.printStackTrace();
				}

				return arraylist;
	}

/////////////////////  gujratTeam         //////////////
	public ArrayList<TeamModel> gujratTeam() {
		
	return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/GujratTeam.json", "GujratPlayerList");
	
	}
	
/////////////////////    punjabTeam    //////////////
	public ArrayList<TeamModel> punjabTeam() {

	return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/PunjabTeam.json", "PunjabPlayerList");

	}
	
///////////////////// KolkataKnightRidersTeam //////////////
	
	public ArrayList<TeamModel> KolkataKnightRidersTeam() {

	return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/KKRTeam.json", "KKRPlayerList");

	}	

///////////////////// mumbaiIndiansTeam //////////////
	
		public ArrayList<TeamModel> mumbaiIndiansTeam() {

		return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/MumbaiIndians.json", "MumbaiPlayerList");

		}	
///////////////////// risingPuneTeam //////////////
		
		public ArrayList<TeamModel> risingPuneTeam() {

		return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/RisingPune.json", "PuneteamList");

		}

///////////////////// royalChallengesTeam //////////////
		
		public ArrayList<TeamModel> royalChallengesTeam() {

		return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/RoyalChallenges.json", "RoyalChallengeList");

		}

///////////////////// SunrisersHyderabad Team //////////////
		
		public ArrayList<TeamModel> sunriseHydrabadTeam() {

		return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/SunriseHydrabad.json", "SunrisersHyderabadList");

		}
///////////////////// SunrisersHyderabad Team //////////////
		
		public ArrayList<TeamModel> DelhiDareDevils() {

		return teamgenerate("/home/balram/git/IPL/IPL - Exception Handlings /iplapplication2016/src/main/jsonfile/IPLTeam/DelhiDareDevilsTeam.json", "DelhiDareDevilsTeamlist");

		}
}
	
