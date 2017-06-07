package seniorassassinv2;

import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sean
 */
public class Rank {
    private static List<String> ranks;
    private String rank;
    private int rankID;
    private Properties properties;
    private FileOutputStream os;
    
    public Rank(String initRank)
    {
        ranks = new ArrayList<>();
        initRanks();
        rank = initRank;
        initRankID();
        properties = null;
        os = null;
    }
    
    private static void initRanks()
    {
        ranks.add("King");
    }
    
    private void initRankID()
    {
        rankID = -1;
        for(int i = 0; i < ranks.size(); i++)
        {
            if(rank.equals(ranks.get(i)))
                rankID = i+1;
        }
        if(rankID == -1)
            rank = "N/A";
    }
    
    public void incRank()
    {
        if(rankID != -1)
        {
            rankID++;
            rank = ranks.get(rankID-1);
            properties.setProperty("rank", rank);
            try
            {
                properties.storeToXML(os, properties.getProperty("name"));
            }
            catch(Exception ex){}
        }
    }

    public static List<String> getRanks() {
        return ranks;
    }

    public String getTitle() {
        return rank;
    }

    public int getRankID() {
        return rankID;
    }
    
    public void setProperties(Properties newProperties)
    {
        properties = newProperties;
        properties.setProperty("rank", rank);
        try
        {
            os = new FileOutputStream(properties.getProperty("name") + ".xml");
            properties.storeToXML(os, properties.getProperty("name"));
        }
        catch(Exception ex){}
    }
}
