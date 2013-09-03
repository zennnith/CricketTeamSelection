/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketteamselection;

import Genes.Player;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ZenitH
 */
public class Population {

    public static void main(String a[]) {
        
        
        for ( int i = 0; i <100; i++)
        {
            System.out.println("TEAM NUMBER  :"+i);
            
            Chromosome.generateTeam();
            
           
            
       }
        

        




    }
//        List <Chromosome> team =  new ArrayList<Chromosome>();
}
