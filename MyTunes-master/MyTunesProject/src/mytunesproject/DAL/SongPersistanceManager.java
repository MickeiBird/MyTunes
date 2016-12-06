/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.DAL;

import java.io.IOException;
import java.util.List;
import mytunesproject.BE.Song;
import mytunesproject.Util.FileType;

/**
 *
 * @author simon
 */
public class SongPersistanceManager {
 private RandomSaver fileHandler;
 private String fileName;
    
    public void setFileType(FileType type)
    {   
       
          
          
       fileHandler = new RandomSaver(fileName); 
       
    }
    
    public SongPersistanceManager(String fileName)
    {
        this(fileName, FileType.RANDOM_BINARY);
    }
    
    public SongPersistanceManager(String fileName, FileType type)
    {
        this.fileName = fileName;
        setFileType(type);
    }

    public void addSong(Song s) throws IOException
    {
        fileHandler.addSong(s);
    }

    public List<Song> getAll() throws IOException
    {
        return fileHandler.getAll();
    }

    public Song getById(int songId) throws IOException
    {
        return fileHandler.getById(songId);
    }

    public void deleteById(int id) throws IOException
    {
        fileHandler.deleteById(id);
    }
    public void clearAll() throws IOException
    {
        fileHandler.clearAll();
    }

    public void addAll(List<Song> songs) throws IOException
    {
        fileHandler.saveAll(songs);
    } 
  
  
}
