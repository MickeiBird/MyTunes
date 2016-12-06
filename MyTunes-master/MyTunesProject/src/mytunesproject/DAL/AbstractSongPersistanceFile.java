/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.DAL;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import mytunesproject.BE.Song;

/**
 *
 * @author simon
 */
public abstract class AbstractSongPersistanceFile {
    protected final String fileName;

    public AbstractSongPersistanceFile(String fileName)
    {
        this.fileName = fileName;
    }
    
    public void clearAll() throws IOException
    {
        // Ereases the content of the file without deleting it.
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.setLength(0);
    }
    
    public abstract void saveAll(List<Song> songs) throws IOException;
    public abstract void addSong(Song s) throws IOException;
    public abstract void deleteById(int id) throws IOException;
    public abstract Song getById(int departmentId) throws IOException;
    public abstract List<Song> getAll() throws IOException;
    
}
