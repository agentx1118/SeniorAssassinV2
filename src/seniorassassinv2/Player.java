/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorassassinv2;
import java.util.Properties;
import java.io.*;

/**
 *
 * @author Sean
 */
public class Player {
    private String name;
    private int id;
    private Team team;
    private Rank rank;
    private boolean in;
    private Properties properties;
    private FileOutputStream os;
    private FileInputStream is;
    
    public Player(String initName)
    {
        try
        {
            is = new FileInputStream((initName + ".xml"));
            properties = new Properties();
            properties.loadFromXML(is);
            name = properties.getProperty("name");
            id = Integer.parseInt(properties.getProperty("id"));
            in = Boolean.parseBoolean(properties.getProperty("is playing"));
            rank = new Rank(properties.getProperty("rank"));
            rank.setProperties(properties);
            team = new Team(properties.getProperty("team"),Integer.parseInt(properties.getProperty("team ID")));
            team.setProperties(properties);
            os = new FileOutputStream((name) + ".xml");
            properties.storeToXML(os,name);
        }
        catch(Exception ex){
        ex.printStackTrace();}
    }
    
    public Player(String initName, int initID)
    {
        name = initName;
        id = initID;
        in = true;
        rank = new Rank("King");
        properties = new Properties();
        rank.setProperties(properties);
        properties.setProperty("name", name);
        properties.setProperty("id", ((Integer)id).toString());
        properties.setProperty("is playing", ((Boolean)in).toString());
        try
        {
            File file = new File(name + ".xml");
            os = new FileOutputStream((name+".xml"));
            properties.storeToXML(os, name);
        }
        catch(Exception ex){}
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isIn() {
        return in;
    }
    
    public Properties getProperties()
    {
        return properties;
    }

    public void setIn(boolean newIn) {
        in = newIn;
        properties.setProperty("is playing", ((Boolean)in).toString());
        try
        {
            properties.storeToXML(os, name);
        }
        catch(Exception ex){}
    }

    public void setTeam(Team newTeam) {
        if(team != null)
        {
            team.getPlayers().remove(this);
        }
        team = newTeam;
        team.getPlayers().add(this);
        team.setProperties(properties);
    }
    
    
}
