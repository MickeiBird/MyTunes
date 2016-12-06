/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.BLL;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import mytunesproject.BE.Song;
import mytunesproject.DAL.AbstractSongPersistanceFile;
import mytunesproject.DAL.RandomSaver;
import mytunesproject.DAL.SongPersistanceManager;
import mytunesproject.Util.FileType;
import mytunesproject.Util.SongException;

/**
 *
 * @author simon
 */
public class SongManager {
  File soundfile = new File("C:\\Users\\simon\\Documents\\GitHub\\MyTunes\\MyTunesProject\\src\\mytunesproject\\AllSongs\\gameover2.mp3");
  Media media = new Media(soundfile.toURI().toString());
  MediaPlayer mediaplayer = new MediaPlayer(media);  

    private static final String FILE_NAME = "Songs";
    private final SongPersistanceManager spm;

    public SongManager()
    {
        spm = new SongPersistanceManager(FILE_NAME);
    }

    public void setFileType(FileType type)
    {
        spm.setFileType(type);
    }

    public void clearAll() throws SongException
    {
        try
        {
            spm.clearAll();
        }
        catch (IOException ioex)
        {
            throw new SongException("Cannot clear all songs", ioex);
        }
    }

    public void addDepartment(Song s) throws SongException
    {
        try
        {
            spm.addSong(s);
        }
        catch (IOException ioex)
        {
            throw new SongException("Cannot add department", ioex);
        }
    }

    public void addAll(List<Song> songs) throws SongException
    {
        try
        {
            spm.addAll(songs);
        }
        catch (IOException ioex)
        {
            throw new SongException("Cannot add all departments", ioex);
        }
    }

    public List<Song> getAll() throws SongException
    {
        try
        {
            return spm.getAll();
        }
        catch (IOException ioex)
        {
            throw new SongException("Cannot get all departments", ioex);
        }
    }

    public Song getById(int songId) throws SongException
    {
        try
        {
            return spm.getById(songId);
        }
        catch (IOException ioex)
        {
            throw new SongException("Cannot Song from id: " + songId, ioex);
        }
    }

    public void delete(Song s) throws SongException
    {
        try
        {
            spm.deleteById(s.getId());
        }
        catch (IOException ioex)
        {
            throw new SongException(
                    "Cannot Song"+ s.getSongName() + " with id: " + s.getId(), ioex);
        }
    }
  
  
  
  
 


    
}
