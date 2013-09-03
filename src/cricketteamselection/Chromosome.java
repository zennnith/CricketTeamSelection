/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketteamselection;



import DataBase.PlayerDAO;
import cricketteamselection.Gene;
import Genes.IplAllRounder;
import Genes.IplBatting;
import Genes.IplBowling;
import Genes.IplFeilding;
import Genes.Player;
import Genes.PlayerStatistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author ZenitH
 */
public class Chromosome {

    List<Player> batsman;
    List<Player> bowler;
    List<Player> allRounder;
    List<Player> wicketKeeper;
    
    List<Player> bat=new ArrayList<Player>();
    List<Player> bowl=new ArrayList<Player>();
    List<Player> wick=new ArrayList<Player>();
    List<Player> all=new ArrayList<Player>();
    
    public Chromosome() {
        batsman = Gene.getBatsmen();
      
        bowler = Gene.getBowler();
        
        wicketKeeper = Gene.getWicketKeeper();
        allRounder = Gene.getAllRounder();
    }
     
    List<Gene> team;
    int randomGene;
    static int geneLength = 16;
    Random r = new Random();

    //add genes(players) to the chromosome(team)
    public void addGenes() {

       team = new ArrayList<Gene>();
        //team.add(getGene());

    }

    //get a random gene(player) from batsmen table
    public  HashMap< String, List<Player>>  generatePlayer() {
        int duplicate = 0;
        
//List<List<Integer>> mainList = new ArrayList<List<Integer>>();
//        for (int j = 0; j < 100; j++) {
//        List<Integer> a = new ArrayList<Integer>();
        HashMap< String, List<Player>> h = new HashMap<String, List<Player> >();
        for (int i = 0; i < 16; i++) {
//           List<Integer> bat;
            if (i < 6) {
//             System.out.println("batsman No : "+i);
                if (i==0) {
                    randomGene = r.nextInt(batsman.size());
//                        a.add(randomGene);
//                    System.out.println("i <6 first random number "+randomGene);
//                    h.put("batsman", randomGene);
//                    System.out.println(randomGene);
                    bat.add(batsman.get(randomGene));

                } else {
                      
                    randomGene = r.nextInt(batsman.size());
//                     System.out.println("i <6  random number "+randomGene);
//                    for (int b = 0; b < 6; b++) {
                    for (int k=0;k<bat.size();k++) {
//                        if (a.get(i) == randomGene) {
//                            randomGene = r.nextInt(50);
////                                a.add(randomGene);
//                            h.put("batsman", randomGene);
//                            duplicate++;
//                        }
                        duplicate=0;
//                        if (entry.getKey().equalsIgnoreCase("batsman") && entry.getValue() == randomGene) {
                            if(Integer.parseInt( bat.get(k).getId())==randomGene){
                        randomGene = r.nextInt(50);
//                              System.out.println("i <6 duplicate found new Random No "+randomGene);
//                                a.add(randomGene);
                            
//                            h.put("batsman", randomGene);
                              bat.add(batsman.get(randomGene));
                            duplicate++;
                            break;
                        }
                    }
                    if (duplicate == 0) {
//                            a.add(randomGene);
//                        h.put("batsman", randomGene);
                        bat.add(batsman.get(randomGene));
                    }

                }
                if(i==5){
                    h.put("batsman",bat);
                }
            }
            // Random r = new Random();

//                if (a.size() > 0) {
//                    do{
//                    for (int k = 0; k < 6; k++) {
//                        if(a.get(k)==randomGene){
//                            
//                        }
//                    }
//                    }while(a.size()!=6);
//                    a.add(randomGene);
//                }
//                else{
//                    randomGene = r.nextInt(50);
//                     a.add(randomGene);
//                }
//            }

            //bowlers=6
            
            
            if (i > 5 && i < 12) {
//             System.out.println("Bowler No : "+i);
                if (i==6) {
//                    System.out.println("Bowler list Size : "+bowler.size());
                    randomGene = r.nextInt(bowler.size());
//                        a.add(randomGene);
                   // System.out.println("i <6 first random number "+randomGene);
//                    h.put("batsman", randomGene);
                   // System.out.println(randomGene);
                    bat.add(bowler.get(randomGene));

                } else {
                      
                    randomGene = r.nextInt(bowler.size());
//                     System.out.println("i <6  random number "+randomGene);
//                    for (int b = 0; b < 6; b++) {
                    for (int k=0;k<bowl.size();k++) {
//                        if (a.get(i) == randomGene) {
//                            randomGene = r.nextInt(50);
////                                a.add(randomGene);
//                            h.put("batsman", randomGene);
//                            duplicate++;
//                        }
                        duplicate=0;
//                        if (entry.getKey().equalsIgnoreCase("batsman") && entry.getValue() == randomGene) {
                            if(Integer.parseInt( bowl.get(k).getId())==randomGene){
                        randomGene = r.nextInt(50);
//                              System.out.println("i <6 duplicate found new Random No "+randomGene);
//                                a.add(randomGene);
                            
//                            h.put("batsman", randomGene);
                              bowl.add(bowler.get(randomGene));
                            duplicate++;
                            break;
                        }
                    }
                    if (duplicate == 0) {

                        bowl.add(bowler.get(randomGene));
                    }

                }
                if(i==11){
                    h.put("bowler",bowl);
                }
            }
////            
////            
////            
////
////
////////            All rounders=2
             if (i > 11 && i < 14) {
             // System.out.println("All Rounder No : "+i);
                if (i==12) {
                    randomGene = r.nextInt(allRounder.size());
//                        a.add(randomGene);
//                    System.out.println("i <6 first random number "+randomGene);

//                    System.out.println(randomGene);
                    all.add(allRounder.get(randomGene));

                } else {
//                    System.out.println("Allrounder list size : "+allRounder.size());
                      
                    randomGene = r.nextInt(allRounder.size());
//                     System.out.println("i <6  random number "+randomGene);
//                    for (int b = 0; b < 6; b++) {
                    for (int k=0;k<all.size();k++) {
//                    
                        duplicate=0;
                   
                            if(Integer.parseInt( all.get(k).getId())==randomGene){
                        randomGene = r.nextInt(50);
//                              System.out.println("i <12 duplicate found new Random No "+randomGene);


                              all.add(allRounder.get(randomGene));
                            duplicate++;
                            break;
                        }
                    }
                    if (duplicate == 0) {

                        all.add(allRounder.get(randomGene));
                    }

                }
               if(i==13){
                    h.put("allRounders",all);
                }
            }
            
//            
//            
//            
////
//////            //wicket keepers=2
            if (i > 13 && i < 16) {
//             System.out.println("wicket keepers : "+i);
                if (i==14) {
                    randomGene = r.nextInt(wicketKeeper.size());
//                        a.add(randomGene);
//                    System.out.println("i  1 random wikcetKeeper "+randomGene);
//
//                    System.out.println(randomGene);
                    wick.add(wicketKeeper.get(randomGene));

                } else {
                      
                    randomGene = r.nextInt(wicketKeeper.size());
//                     System.out.println("  random wikcetKeeper 2 "+randomGene);
//                    for (int b = 0; b < 6; b++) {
                    for (int k=0;k<wick.size();k++) {
//                    
                        duplicate=0;
                   
                            if(Integer.parseInt( all.get(k).getId())==randomGene){
                        randomGene = r.nextInt(50);
//                              System.out.println("i <12 duplicate found new Random No "+randomGene);


                              wick.add(wicketKeeper.get(randomGene));
                            duplicate++;
                            break;
                        }
                    }
                    if (duplicate == 0) {

                        wick.add(wicketKeeper.get(randomGene));
                    }

                }
               if(i==15){
                   h.put("wicketKeepers", wick);
                }  
//               
            }
    
        
        }

        
    
        return h;
    }

//    public void getTeam(HashMap< String, List<Integer>> v) {
//        
////        
//        
//
////        HashMap< String, List<Integer>> randTeam = v;
//        System.out.println(v.size());
//         for(Map.Entry<String, List<Integer>> entry : v.entrySet())
//         {
//             List<Player> p=new ArrayList<Player>();
//            if(entry.getKey().equalsIgnoreCase("Batsman"))
//            {
//                
//                List<Integer> li=entry.getValue();
//                for(int k=0;k<li.size();k++){
//                    int f=li.get(k);
//                    for(int g=0;g<batsman.size();g++){
//                        if(Integer.parseInt(batsman.get(g).getId())==f){
//                           p.add(batsman.get(g));
//                           System.out.println(batsman.get(g).getName());
//                           System.out.println(batsman.get(g).getId());
//                           break;
//                        }
//                    }
//                }
//            
//            }
//            
//            if(entry.getKey().equalsIgnoreCase("Bowler"))
//            {
//                
//                List<Integer> li=entry.getValue();
//                for(int k=0;k<li.size();k++){
//                    int f=li.get(k);
//                    for(int g=0;g<bowler.size();g++){
//                        if(Integer.parseInt(bowler.get(g).getId())==f){
//                           p.add(bowler.get(g));
//                           System.out.println(bowler.get(g).getName());
//                           System.out.println(bowler.get(g).getId());
//                           break;
//                        }
//                    }
//                }
//            
//            }
//            
//            
//                
//            
//         }
        
//        List<Player> populatedRanTeam = new ArrayList<Player>();
//
//        for (int i =0; i<16;i++) {
//            if (entry.getKey().equalsIgnoreCase("batsman")) {
//                int x = entry.getValue();
//                for (int i = 0; i < batsman.size(); i++) {
//                    if (x == batsman.get(i).getPlayerID()) {
//                        populatedRanTeam.add(batsman.get(i));
//                    }
//                }

//            } else if (entry.getKey().equalsIgnoreCase("bowlers")) {
//                int x = entry.getValue();
//                for (int i = 0; i < bowler.size(); i++) {
//                    if (x == bowler.get(i).getPlayerID()) {
//                        populatedRanTeam.add(bowler.get(i));
//                    }
//                }
//            }
//            else if (entry.getKey().equalsIgnoreCase("allRounders")) {
//                int x = entry.getValue();
//                for (int i = 0; i < allRounder.size(); i++) {
//                    if (x == allRounder.get(i).getPlayerID()) {
//                        populatedRanTeam.add(allRounder.get(i));
//                    }
//                }
//            }
//            else if (entry.getKey().equalsIgnoreCase("wicketKeepers")) {
//                int x = entry.getValue();
//                for (int i = 0; i < wicketKeeper.size(); i++) {
//                    if (x == wicketKeeper.get(i).getPlayerID()) {
//                        populatedRanTeam.add(wicketKeeper.get(i));
//                    }
//                }
//            }
//        }
//
//
//
        
    

    
    public static void generateTeam()
    {
       
       
        
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
         Chromosome obj1 = new Chromosome();
//         System.out.println("BATSMEN in the DB : "+obj1.batsman.size());
//         System.out.println("BOWLERS in the DB : "+obj1.bowler.size());
//         System.out.println("WICKET KEEPERS in the DB : "+obj1.wicketKeeper.size());
//         System.out.println("ALL-ROUNDERS in the DB : "+obj1.allRounder.size());
//         System.out.println("END PRINTING THE DB LISTS");
         HashMap< String, List<Player> >obj   = obj1.generatePlayer();
//        obj1.getTeam(obj);
//          System.out.println("Starting to print the random PLAYERS  from THE LIST");
//          System.out.println("********************************************");
//          System.out.println("tEAM CONSIST : "+obj.size());
//          System.out.println("********************************************");
        for(Map.Entry<String, List<Player>> entry : obj.entrySet())
        {
              
            System.out.println("-------------------------------");     
            System.out.println("key is: "+entry.getKey());
            
            System.out.println("value is: "+entry.getValue());
             
            List<Player> p=entry.getValue();
            for(int y=0;y<entry.getValue().size();y++){
                 
//                 System.out.println(p.get(y).getId());
                 System.out.println(p.get(y).getName());
                 System.out.println(p.get(y).getSpeciality());
//                 System.out.println(p.get(y).getName());
            }
            System.out.println("-------------------------------");
            
        }
         System.out.println("end printing the TEAM from LIST ");
         
//         System.out.println("players");
//         obj1.getTeam(obj);
    
        }
       }
    

