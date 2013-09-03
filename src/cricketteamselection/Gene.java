/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketteamselection;

import DataBase.DataBaseConnection;
import DataBase.PlayerDAO;
import Genes.*;

import java.util.List;

/**
 *
 * @author ZenitH
 */
public class Gene {

    public static List<Player> getBatsmen() {

        return PlayerDAO.getAllBatsmen();

    }

//    public static List<AllRounder> getAllRounder() {
//
//        return DataBaseConnection.getAllAllRounder();
//
//    }
//
    public static List<Player> getBowler() {

        return PlayerDAO.getAllBowler();

    }

    public static List<Player> getWicketKeeper() {

        return PlayerDAO.getAllWicketKeeper();

    }
    public static List<Player> getAllRounder()
    {
        return PlayerDAO.getAllRounders();
    
    }
    
//    public static void main(String[] args) {
//        List<Batsman> g=getBatsmen();
//        for(int i=0;i<g.size();i++)
//        {
//            System.out.println(g.get(i).getName());
//        
//        }
//    }
}
