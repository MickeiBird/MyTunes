/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author simon
 */
public class Song
{

    private final IntegerProperty id;
    private final StringProperty SongName;

    private final StringProperty Artist;
    private final StringProperty Location;

    public Song(int id, String SongName, String Artist, String Location)
    {
        this.id = new SimpleIntegerProperty(id);
        this.SongName = new SimpleStringProperty(SongName);
        

        this.Artist = new SimpleStringProperty(Artist);
        this.Location = new SimpleStringProperty(Location);
    }


    public String getArtist()
    {
        return Artist.get();
    }

    public void setArtist(String Artist)
    {
        this.Artist.set(Artist);
    }
    
    public StringProperty artistProperty()
    {
        return Artist;
    }

    public String getLocation()
    {
        return Location.get();
    }

    public void setLocation(String Location)
    {
        this.Location.set(Location);
    }
    
    public StringProperty locationProperty()
    {
        return Location;
    }


    public int getId()
    {
        return id.get();
    }

    public void setId(int id)
    {
        this.id.set(id);
    }
    
    public IntegerProperty idProperty()
    {
        return id;
    }


    public String getSongName()
    {
        return SongName.get();
    }

   

    public void setSongName(String SongName)
    {
        this.SongName.set(SongName);
    }
    
    public StringProperty songNameProperty()
    {
        return SongName;
    }


}
