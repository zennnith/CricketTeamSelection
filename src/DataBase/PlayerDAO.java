/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Genes.IplTeam;
import Genes.IplTeamPlayer;
import Genes.Player;
import Genes.IplBatting;
import Genes.IplBowling;
import Genes.IplFeilding;
import Genes.PlayerStatistic;
import Genes.Statistics;
import PlayerDataUI.IPLBatting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ZenitH
 */
public class PlayerDAO {
    
    private static String url;
    private static Connection con;

    static {
        try {
            // Load Sun's jdbc-odbc driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            url = "jdbc:mysql://localhost/cricketers";
            con = DriverManager.getConnection(url, "root", "123");
        } catch (Exception cnfe) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + cnfe);
            System.exit(0);
        }

    }
    
     public static void insertPlayer(Player p){
         try{
            PreparedStatement insertPlayer = con.prepareStatement("INSERT INTO player (Name,Nationality,Value,Age,Speciality) Values(?,?,?,?,?)");
            insertPlayer.setString(1,p.getName());
            insertPlayer.setString(2,p.getNationality());
            insertPlayer.setInt(3,p.getValue());
            insertPlayer.setInt(4,p.getAge());
            insertPlayer.setString(5,p.getSpeciality());
            
            insertPlayer.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
         public static void insertTeam(IplTeam iTeam){
         try{
            PreparedStatement insertIplTeam = con.prepareStatement("INSERT INTO iplteam (Name,Owner,Town) Values(?,?,?)");
            insertIplTeam.setString(1,iTeam.getTeamName());
            insertIplTeam.setString(2,iTeam.getTeamOwner());
            insertIplTeam.setString(3,iTeam.getTown());
            
            insertIplTeam.executeUpdate();
            
        }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
     }
         
        
     
         public static void insertYearOfStat(IplTeamPlayer teamPlayer){
         try{
              IplTeamPlayer itp = new IplTeamPlayer();
            PreparedStatement getPlayerID = con.prepareStatement("SELECT id FROM player ORDER BY id DESC LIMIT 1");
            
            String i;
              ResultSet rs = getPlayerID.executeQuery();
             while (rs.next()) {
                
                 itp.setPlyerID((rs.getString("ID")));
            
           
                }
              PreparedStatement insertIplTeamPlayer = con.prepareStatement("INSERT INTO iplteam_player (PlayerID,IPLTeamID,Year) Values(?,?,?)");
          
            insertIplTeamPlayer.setString(1,itp.getPlyerID());
            insertIplTeamPlayer.setString(2,itp.getPlyerID());
            insertIplTeamPlayer.setString(3,teamPlayer.getYear());
            
            insertIplTeamPlayer.executeUpdate();
         }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
            }
         }
         
         public static void insertIplBatting(IplBatting ib){
         try{
              
            Player itp = new Player();
            IplBatting teamPlayer = new IplBatting();
            PreparedStatement getPlayerID = con.prepareStatement("SELECT id FROM player ORDER BY id DESC LIMIT 1");
                        
             ResultSet rs = getPlayerID.executeQuery();
             while (rs.next()) {
                
//                 itp.setPlyerID((rs.getString("ID")));
                 
                 
                 itp.setId(rs.getString("ID"));
//                   itp.setID((rs.getString("ID")));
            
           
             }
            PreparedStatement insertIplBatting = con.prepareStatement("INSERT INTO iplteam_player_battingstatistics (PlayerID,TeamID,Average, StrikeRate) Values(?,?,?,?)");
          
            insertIplBatting.setString(1,itp.getId());
            insertIplBatting.setString(2,itp.getId());
            insertIplBatting.setString(3,ib.getAverage());
            insertIplBatting.setString(4,ib.getStrRate());
            
            insertIplBatting.executeUpdate();
         }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
         
         
         
         }
         
//ooooooooooooooooooooooooooooooooooooooooooooooooo
         
         public static void insertIplBowlingFeilding(IplBowling ib,IplFeilding iff){
         try{
              
            Player itp = new Player();
            IplBowling teamPlayer = new IplBowling();
            IplFeilding ifeilding = new IplFeilding();
            PreparedStatement getPlayerID = con.prepareStatement("SELECT id FROM player ORDER BY id DESC LIMIT 1");
                        
             ResultSet rs = getPlayerID.executeQuery();
             while (rs.next()) {
                
//                 itp.setPlyerID((rs.getString("ID")));
                 
                 
                 itp.setId(rs.getString("ID"));
//                   itp.setID((rs.getString("ID")));
            
           
             }
            PreparedStatement insertIplBowling = con.prepareStatement("INSERT INTO iplteam_player_bowlingstatistics (PlayerID,TeamID,Economy) Values(?,?,?)");
          
            insertIplBowling.setString(1,itp.getId());
            insertIplBowling.setString(2,itp.getId());
            insertIplBowling.setString(3,ib.getEcon());
            //insertIplBowling.setString(4,ib.getStrRate());
            
            insertIplBowling.executeUpdate();
            
            
            
            PreparedStatement insertIplFeilding = con.prepareStatement("INSERT INTO iplteam_player_fieldingstatistics (PlayerID,TeamID,Catches) Values(?,?,?)");
            insertIplFeilding.setString(1,itp.getId());
            insertIplFeilding.setString(2,itp.getId());
            insertIplFeilding.setString(3,ib.getEcon());
            
              insertIplFeilding.executeUpdate();
            
         }
         catch(Exception e ){
             
             throw new RuntimeException(e.getMessage());
         }
         
         
         
         }
         
         
        //**** *****  
        public static List<Player> getAllBatsmen() {
        List<Player> batsman = new ArrayList<Player>();

        try {

           // PreparedStatement getBatsmanstmt = con.prepareStatement("  SELECT * FROM iplteam_player_battingstatistics,iplteam_player WHERE iplteam_player.PlayerID = 1 	AND (iplteam_player_battingstatistics.PlayerID = iplteam_player.PlayerID AND iplteam_player_battingstatistics.TeamID =  iplteam_player.IPLTeamID) " );
           PreparedStatement getBatsmanstmt = con.prepareStatement("SELECT * FROM iplteam_player_battingstatistics b,iplteam_player_bowlingstatistics bo,iplteam_player_fieldingstatistics fi,player p WHERE b.PlayerID=bo.PlayerID AND fi.PlayerID=bo.PlayerID  AND fi.PlayerID=b.PlayerID AND p.ID=b.PlayerID AND p.ID=fi.PlayerID AND p.ID=bo.PlayerID AND p.Speciality='Batsman'");
           ResultSet rs = getBatsmanstmt.executeQuery();
            while (rs.next()) {

                Player pl=new Player();
                PlayerStatistic stat = new PlayerStatistic();
                
                stat.setBattingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBattingstrkRate(Double.parseDouble(rs.getString("StrikeRate")));
              //??????? bat.setBowlingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBowlingeconomy(Double.parseDouble(rs.getString("Economy")));
              //??????? bat.setBowlingstrkRate(Double.parseDouble(rs.getString("Average")));
//  give not null values f nt throwing an error               stat.setCatches(Integer.parseInt(rs.getString("Catches")));
//   give not null values f nt throwing an error             stat.setStumpings(Integer.parseInt(rs.getString("Stumpings")));
                
                
                pl.setPlayerStatistic(stat);
                pl.setId(rs.getString("PlayerID"));
                pl.setName(rs.getString("Name"));
                pl.setSpeciality(rs.getString("Speciality"));
                pl.setAge(Integer.parseInt(rs.getString("Age")) );
                batsman.add(pl);

            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return batsman;


    }
        
        public static List<Player> getAllBowler() {
        List<Player> bowler = new ArrayList<Player>();

        try {

           // PreparedStatement getBatsmanstmt = con.prepareStatement("  SELECT * FROM iplteam_player_battingstatistics,iplteam_player WHERE iplteam_player.PlayerID = 1 	AND (iplteam_player_battingstatistics.PlayerID = iplteam_player.PlayerID AND iplteam_player_battingstatistics.TeamID =  iplteam_player.IPLTeamID) " );
           PreparedStatement getBowlerstmt = con.prepareStatement("SELECT * FROM iplteam_player_battingstatistics b,iplteam_player_bowlingstatistics bo,iplteam_player_fieldingstatistics fi,player p WHERE b.PlayerID=bo.PlayerID AND fi.PlayerID=bo.PlayerID  AND fi.PlayerID=b.PlayerID AND p.ID=b.PlayerID AND p.ID=fi.PlayerID AND p.ID=bo.PlayerID AND p.Speciality='Bowler'");
           ResultSet rs = getBowlerstmt.executeQuery();
          
            while (rs.next()) {

                Player pl=new Player();
                PlayerStatistic stat = new PlayerStatistic();
                
                stat.setBattingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBattingstrkRate(Double.parseDouble(rs.getString("StrikeRate")));
              //??????? bat.setBowlingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBowlingeconomy(Double.parseDouble(rs.getString("Economy")));
              //??????? bat.setBowlingstrkRate(Double.parseDouble(rs.getString("Average")));
//  give not null values f nt throwing an error               stat.setCatches(Integer.parseInt(rs.getString("Catches")));
//   give not null values f nt throwing an error             stat.setStumpings(Integer.parseInt(rs.getString("Stumpings")));
                
                
                pl.setPlayerStatistic(stat);
                pl.setId(rs.getString("PlayerID"));
                pl.setName(rs.getString("Name"));
                pl.setSpeciality(rs.getString("Speciality"));
                pl.setAge(Integer.parseInt(rs.getString("Age")) );
                bowler.add(pl);

            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return bowler;


    }
        /// get getAllRounders
         
        public static List<Player> getAllRounders() {
        List<Player> allRounder = new ArrayList<Player>();

        try {

           // PreparedStatement getBatsmanstmt = con.prepareStatement("  SELECT * FROM iplteam_player_battingstatistics,iplteam_player WHERE iplteam_player.PlayerID = 1 	AND (iplteam_player_battingstatistics.PlayerID = iplteam_player.PlayerID AND iplteam_player_battingstatistics.TeamID =  iplteam_player.IPLTeamID) " );
           PreparedStatement getAllRounderstmt = con.prepareStatement("SELECT * FROM iplteam_player_battingstatistics b,iplteam_player_bowlingstatistics bo,iplteam_player_fieldingstatistics fi,player p WHERE b.PlayerID=bo.PlayerID AND fi.PlayerID=bo.PlayerID  AND fi.PlayerID=b.PlayerID AND p.ID=b.PlayerID AND p.ID=fi.PlayerID AND p.ID=bo.PlayerID AND p.Speciality='Bowler'");
           ResultSet rs = getAllRounderstmt.executeQuery();
            while (rs.next()) {

                Player pl=new Player();
                PlayerStatistic stat = new PlayerStatistic();
                
                stat.setBattingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBattingstrkRate(Double.parseDouble(rs.getString("StrikeRate")));
              //??????? bat.setBowlingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBowlingeconomy(Double.parseDouble(rs.getString("Economy")));
              //??????? bat.setBowlingstrkRate(Double.parseDouble(rs.getString("Average")));
//  give not null values f nt throwing an error               stat.setCatches(Integer.parseInt(rs.getString("Catches")));
//   give not null values f nt throwing an error             stat.setStumpings(Integer.parseInt(rs.getString("Stumpings")));
                
                
                pl.setPlayerStatistic(stat);
                pl.setId(rs.getString("PlayerID"));
                pl.setName(rs.getString("Name"));
                pl.setSpeciality(rs.getString("Speciality"));
                pl.setAge(Integer.parseInt(rs.getString("Age")) );
                allRounder.add(pl);

            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return allRounder;


    }
        
        
      //  getAllWicketKeeper
        
        
        public static List<Player> getAllWicketKeeper() {
        List<Player> wicketkeeper = new ArrayList<Player>();

        try {

           // PreparedStatement getBatsmanstmt = con.prepareStatement("  SELECT * FROM iplteam_player_battingstatistics,iplteam_player WHERE iplteam_player.PlayerID = 1 	AND (iplteam_player_battingstatistics.PlayerID = iplteam_player.PlayerID AND iplteam_player_battingstatistics.TeamID =  iplteam_player.IPLTeamID) " );
           PreparedStatement getWicketkeeperstmt = con.prepareStatement("SELECT * FROM iplteam_player_battingstatistics b,iplteam_player_bowlingstatistics bo,iplteam_player_fieldingstatistics fi,player p WHERE b.PlayerID=bo.PlayerID AND fi.PlayerID=bo.PlayerID  AND fi.PlayerID=b.PlayerID AND p.ID=b.PlayerID AND p.ID=fi.PlayerID AND p.ID=bo.PlayerID AND p.Speciality='Wicket-Keeper'");
           ResultSet rs = getWicketkeeperstmt.executeQuery();
            while (rs.next()) {

                Player pl=new Player();
                PlayerStatistic stat = new PlayerStatistic();
                
                stat.setBattingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBattingstrkRate(Double.parseDouble(rs.getString("StrikeRate")));
              //??????? bat.setBowlingAvg(Double.parseDouble(rs.getString("Average")));
                stat.setBowlingeconomy(Double.parseDouble(rs.getString("Economy")));
             
                
                pl.setPlayerStatistic(stat);
                pl.setId(rs.getString("PlayerID"));
                pl.setName(rs.getString("Name"));
                pl.setSpeciality(rs.getString("Speciality"));
                pl.setAge(Integer.parseInt(rs.getString("Age")) );
                wicketkeeper.add(pl);

            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return wicketkeeper;


    }
}
        
        
     
    
         
    

