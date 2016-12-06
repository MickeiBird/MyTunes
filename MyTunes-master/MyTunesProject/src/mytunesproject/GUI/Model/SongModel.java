/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.GUI.Model;

import java.io.File;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import mytunesproject.BE.Song;

/**
 *
 * @author simon
 */
public class SongModel
{
   
    private final ObservableList<Song> songList;

    public SongModel()
    {
        this.songList = FXCollections.observableArrayList();
    }

    public ObservableList<Song> getSongList()
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
        System.out.println(song);
    }
      public void play(Song song)
    {
        File soundfile = new File(song.getLocation());
        Media media = new Media(soundfile.toURI().toString());
        MediaPlayer mediaplayer = new MediaPlayer(media);
        mediaplayer.play();
    }
      
       public void pause(Song song)
    {
        File soundfile = new File(song.getLocation());
        Media media = new Media(soundfile.toURI().toString());
        MediaPlayer mediaplayer = new MediaPlayer(media);
        mediaplayer.pause();
    }

}
