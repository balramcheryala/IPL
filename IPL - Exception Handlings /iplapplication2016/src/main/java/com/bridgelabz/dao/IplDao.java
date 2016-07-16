package com.bridgelabz.dao;
import java.util.ArrayList;

import com.bridgelabz.model.PlayerModel;
import com.bridgelabz.model.TeamModel;
public interface IplDao {
	public ArrayList<PlayerModel> playergenerate(String filepath , String nameplayerlist );
	public ArrayList<PlayerModel> GujratPlayerList();
	public ArrayList<PlayerModel> PunjabPlayerList();
	public ArrayList<PlayerModel> KolkataPlayer();
	public ArrayList<PlayerModel> MumbaiPlayerList();
	public ArrayList<PlayerModel> risingPunePlayerList();
	public ArrayList<PlayerModel> royalChallengesPlayerList();
	public ArrayList<PlayerModel> sunriseHydrabadPlayerList();
	public ArrayList<PlayerModel> DelhiPlayerList();
	public ArrayList<TeamModel> teamgenerate(String filepath , String nameteamlist );
	public ArrayList<TeamModel> gujratTeam();
	public ArrayList<TeamModel> punjabTeam();
	public ArrayList<TeamModel> KolkataKnightRidersTeam();
	public ArrayList<TeamModel> mumbaiIndiansTeam();
	public ArrayList<TeamModel> risingPuneTeam();
	public ArrayList<TeamModel> royalChallengesTeam();
	public ArrayList<TeamModel> sunriseHydrabadTeam();
	public ArrayList<TeamModel> DelhiDareDevils();
}
