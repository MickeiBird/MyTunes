/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.GUI.Model;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mytunesproject.BE.Song;

/**
 *
 * @author simon
 */
public class SongModel {

//    private final StringProperty text = new SimpleStringProperty();
//    public StringProperty textProperty()
//    {
//        return text;
//    }
//    
//    public final String getText()
//    {
//        return textProperty().get();
//    }
//    
//    public final void setText(String text)
//    {
//        textProperty().set(text);
//    }
//    
//    
    
    
    
    
    
    
    
    
    
    
    private final ObservableList<Song> songList;

    public SongModel()
    {
        this.songList = FXCollections.observableArrayList();
    }

    public ObservableList<Song> getDepartmentList()
    {
        return songList;
    }
    
    public void setSongs(List<Song> songs)
    {
        songList.clear();
        songList.addAll(songs);
    } 
    public void addSong(int id, String title, String artist, String path)
    {
     Song song = new Song(id, title, artist, path);   
     songList.add(song);
    }
}
