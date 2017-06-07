/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seniorassassinv2;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Sean
 */
public class Team {
    private String name;
    private int id;
    private List<Player> players;
    private boolean in;
    private Properties properties;
    private FileOutputStream os;
    
    public Team(String initName, int initID)
    {
        name = initName;
        id = initID;
        in = true;
        players = new ArrayList<>();
        properties = null;
        os = null;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean newIn) {
        in = newIn;
        properties.setProperty("is playing", ((Boolean)in).toString());
        try
        {
            properties.storeToXML(os, properties.getProperty("name"));
        }
        catch(Exception ex){}
    }
    
    public void setProperties(Properties newProperties)
    {
        properties = newProperties;
        properties.setProperty("team", name);
        properties.setProperty("team ID", ((Integer)id).toString());
        try
        {
            os = new FileOutputStream(properties.getProperty("name") + ".xml");
            properties.storeToXML(os, properties.getProperty("name"));
        }
        catch(Exception ex){}
    }
}
