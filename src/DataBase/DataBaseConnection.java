/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZenitH
 */
public class DataBaseConnection {

    private static String url;
    private static Connection con;

    static {
        try {
            // Load Sun's jdbc-odbc driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            url = "jdbc:mysql://localhost/cricketplayers";
            con = DriverManager.getConnection(url, "root", "123");
        } catch (Exception cnfe) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + cnfe);
            System.exit(0);
        }

    }

//////////////////////    public static String getPlayer(String id) {
//////////////////////        try {
//////////////////////            PreparedStatement retreivePlayer = con.prepareStatement("SELECT PlayerName FROM batsmen WHERE PlayerID=?");
//////////////////////            retreivePlayer.setString(1, id);
//////////////////////            ResultSet rs = retreivePlayer.executeQuery();
//////////////////////            while (rs.next()) {
//////////////////////                return rs.getString("PlayerName");
//////////////////////            }
//////////////////////        } catch (Exception e) {
//////////////////////
//////////////////////            throw new RuntimeException(e.getMessage());
//////////////////////        }
//////////////////////        return null;
//////////////////////    }

    //*********************************************************
//    public static List<Batsman> getAllBatsmen() {
//        List<Batsman> batsman = new ArrayList<Batsman>();
//
//        try {
//
//            PreparedStatement getBatsmanstmt = con.prepareStatement("SELECT * FROM Batsmen");
//            ResultSet rs = getBatsmanstmt.executeQuery();
//            while (rs.next()) {
//                Batsman bat = new Batsman();
//                bat.setName(rs.getString("PlayerName"));
//                batsman.add(bat);
//
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//        return batsman;
//
//
//    }
    //*********************************************************
//
//    public static List<AllRounder> getAllAllRounder() {
//        List<AllRounder> all = new ArrayList<AllRounder>();
//
//        try {
//
//            PreparedStatement getBatsmanstmt = con.prepareStatement("SELECT * FROM AllRounder");
//            ResultSet rs = getBatsmanstmt.executeQuery();
//            while (rs.next()) {
//                AllRounder a = new AllRounder();
//                a.setPlayerName(rs.getString("PlayerName"));
//                all.add(a);
//
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//        return all;
//
//
//    }
        //*********************************************************

    
    
      //*********************************************************

//    public static List<WicketKeeper> getAllWicketKeeper() {
//        List<WicketKeeper> all = new ArrayList<WicketKeeper>();
//
//        try {
//
//            PreparedStatement getBatsmanstmt = con.prepareStatement("SELECT * FROM wicketKeeper");
//            ResultSet rs = getBatsmanstmt.executeQuery();
//            while (rs.next()) {
//                WicketKeeper a = new WicketKeeper();
//                a.setPlayerName(rs.getString("name"));
//                all.add(a);
//
//            }
//        } catch (SQLException ex) {
//            throw new RuntimeException();
//        }
//        return all;
//
//
//    }
    //*********************************************************
    //*********************************************************
    
    //18.08.2013 According to the new DB structure 
    
    //*********************************************************
    //*********************************************************
    
    
    
    
    
}
