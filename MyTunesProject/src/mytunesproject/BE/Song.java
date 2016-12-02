/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.BE;

import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class Song
{

    private int id;
    private String SongName;

    private String Artist;
    private String Location;

    public Song(int id, String SongName, String Artist, String Location)
    {
        this.id = id;
        this.SongName = SongName;

        this.Artist = Artist;
        this.Location = Location;
    }

    public String getArtist()
    {
        return Artist;
    }

    public void setArtist(String Artist)
    {
        this.Artist = Artist;
    }

    public String getLocation()
    {
        return Location;
    }

    public void setLocation(String Location)
    {
        this.Location = Location;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSongName()
    {
        return SongName;
    }

    public void setSongName(String SongName)
    {
        this.SongName = SongName;
    }

}
