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
public class Song {
private int id;   
private String SongName;


public Song(int id, String SongName)
{
    this.id = id;
    this.SongName = SongName;
    
    }

        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String SongName) {
        this.SongName = SongName;
    }

    
}
