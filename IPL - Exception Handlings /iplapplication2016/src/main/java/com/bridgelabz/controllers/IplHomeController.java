package com.bridgelabz.controllers;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.bridgelabz.dao.IplDaoImpl;
import com.bridgelabz.model.PlayerModel;
import com.bridgelabz.model.TeamModel;

@Controller
@EnableWebMvc
public class IplHomeController 
{
	@Autowired
	private IplDaoImpl ipldao;
	@Autowired
	public SessionFactory sessionfactory;
	
	private Facebook facebook;
	
		// FacebookPage
		@RequestMapping(value="/facebook",method=RequestMethod.GET)
		public String helloFacebook(Model model) {
		model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        return "iplhome";
		}
	
		// IplHomePage
		@RequestMapping(value="/ipl.html",method = RequestMethod.GET)
		public ModelAndView iplHomepage(Model m)
		{
		return new ModelAndView ("iplhome");
		}

	
		// Searching 
		@RequestMapping(value="/search", method = RequestMethod.GET)
		public ModelAndView searchbyname(@RequestParam(value="by", required=true) String by,@RequestParam(value="q", required=true) String query) 
		{
		
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(by);
		System.out.println(query);
		model.put("playerlist", ipldao.jsonsearch(by,query));
		if(query.isEmpty()){
		throw new SpringException("Please Provide the Field Name");
		}
		else{
			return new ModelAndView("playerlist",model);
		    }
		
		}
	
		// sorting
		@RequestMapping(value="/sort", method = RequestMethod.GET)
		public ModelAndView searchforanything(@RequestParam(value="sortby", required=true) String fieldName) 
		{
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("playerlist", ipldao.jsonsorting( fieldName));
			return new ModelAndView("playerlist",model);
			}
	
		//display the DDplayer list
		@RequestMapping("ddplayerview")
		public String playerList1(Model model) {
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist",ipldao.DelhiPlayerList());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		
		//display the Delhi DareDevils team list
		@RequestMapping("ddteamview")
		public String playList(Model model) {
			
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", ipldao.DelhiDareDevils());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
		}

		//display the Gujrat Lion PlayerList
		@RequestMapping("glplayerview")
		public String gujratPlayerList(Model model) {
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist", this.ipldao.GujratPlayerList());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		
		//display the Punjab PlayerList
		@RequestMapping("kpplayerview")
		public String kpPlayerList(Model model) {
		
		model.addAttribute("playerdto", new PlayerModel());
		Model result = model.addAttribute("playerlist", this.ipldao.PunjabPlayerList());
		System.out.println();
		System.out.println(result);
		return "playerlist";
		}
		//display the KKr  PlayerList
		@RequestMapping("kkrplayerview")
		public String kkrPlayerList(Model model) {
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist", this.ipldao.KolkataPlayer());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		//display the mumbai indians PlayerList
		@RequestMapping("mumbaiplayerview")
		public String mumbaiPlayerList(Model model) {
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist", this.ipldao.MumbaiPlayerList());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		//display the rising pune PlayerList
		@RequestMapping("puneplayerview")
		public String punePlayerList(Model model) {
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist", this.ipldao.risingPunePlayerList());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		//display the royal challenges PlayerList
		@RequestMapping("rcbplayerview")
		public String rcbPlayerList(Model model) {
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist", this.ipldao.royalChallengesPlayerList());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		//display the sunrise HyderabadPlayerList
		@RequestMapping("sunriseplayerview")
		public String sunrisesPlayerList(Model model) {	
			
			model.addAttribute("playerdto", new PlayerModel());
			Model result = model.addAttribute("playerlist", this.ipldao.sunriseHydrabadPlayerList());
			System.out.println();
			System.out.println(result);
			return "playerlist";
		}
		//display the Gujrat Lions team list
		@RequestMapping("glteamview")
		public String gujratTeamList(Model model) {
			
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.gujratTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
		}
		
		//display the punjab team list
		@RequestMapping("kpteamview")
		public String kpTeamList(Model model) {
		
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.punjabTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
		}
		//display the KolkataKnightRidersTeam team list
		@RequestMapping("kkrteamview")
		public String kkrTeamList(Model model) {
		
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.KolkataKnightRidersTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
		}
		
		//display the MumbaiIndians team list
		@RequestMapping("mumbaiteamview")
		public String mumbaiTeamList(Model model) {
		
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.mumbaiIndiansTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
		}
	
		//display the RisingPuneTeam list
		@RequestMapping("puneteamview")
		public String puneTeamList(Model model) {
				
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.risingPuneTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
		}
	
		//display the RoyalChallengesTeam list
		@RequestMapping("rcbteamview")
		public String rcbTeamList(Model model) {
			
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.royalChallengesTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
	}
		
		//display the sunrise hyderabad team list
		@RequestMapping("sunriseteamview")
		public String sunriseTeamList(Model model) {
		
			model.addAttribute("playerdto", new TeamModel());
			Model result = model.addAttribute("ddteam", this.ipldao.sunriseHydrabadTeam());
			System.out.println();
			System.out.println(result);
			return "ddTeamPlayer";
	}
}
