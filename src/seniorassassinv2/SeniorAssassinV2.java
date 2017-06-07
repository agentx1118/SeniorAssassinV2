/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorassassinv2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class SeniorAssassinV2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean first = true;
        List<Player> players= new ArrayList<>();
        List<Team> teams = new ArrayList<>();
        if(first)
        {
            String line = "";
            try{
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader("players.txt");
                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);
                int count = 1;
                while((line = bufferedReader.readLine()) != null)
                {
                    players.add(new Player((line), count));
                    count++;
                }
            }
            catch(Exception ex){}
            try{
                // FileReader reads text files in the default encoding.
                FileReader fileReader = 
                    new FileReader("team names.txt");
                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = 
                    new BufferedReader(fileReader);
                int count = 1;
                while((line = bufferedReader.readLine()) != null)
                {
                    teams.add(new Team((line), count));
                    count++;
                }
            }
            catch(Exception ex){}
            int run = 1;
            for(int i = 0; i < players.size(); i++)
            {
                
            }
            Player alice = new Player("Alice", 1);
            Team wonderland = new Team("wonderland",1);
            alice.setTeam(wonderland);
            System.out.println(alice.getName());
            System.out.println(alice.getId());
            System.out.println(alice.getTeam().getName());
            System.out.println(alice.getRank().getTitle());
            System.out.println(alice.getTeam().isIn());
        }
        else
        {
            try
            {
                //java.util.Properties one = new java.util.Properties();
                //one.loadFromXML(new java.io.FileInputStream("Alice.xml"));
                //one.list(System.out);
            }
            catch(Exception ex){}
            Player alice = new Player("Alice");
            System.out.println(alice.getName());
            System.out.println(alice.getId());
            System.out.println(alice.getTeam().getName());
            System.out.println(alice.getRank().getTitle());
            System.out.println(alice.getTeam().isIn());
        }
        // TODO code application logic here
    }
    
    
}

