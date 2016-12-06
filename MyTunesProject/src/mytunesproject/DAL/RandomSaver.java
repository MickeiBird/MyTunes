/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.DAL;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import mytunesproject.BE.Song;
import mytunesproject.GUI.Controller.FXMLController;

/**
 *
 * @author simon
 */
public class RandomSaver extends AbstractSongPersistanceFile{
     private static final int ID_SIZE = Integer.BYTES;
    private static final int NAME_SIZE = 50;
    private static final int ARTIST_SIZE = 300;
    private static final int LOCATION_SIZE = 300;
    private static final int RECORD_SIZE = ID_SIZE + NAME_SIZE;
    
    
    //Song song = new Song(Integer.parseInt(FXMLController.IdField.getText()), FXMLController.TitleField.getText(), FXMLController.ArtistField.getText(), FXMLController.FileField.getText());
 
    public RandomSaver(String fileName)
    {
        super(fileName + ".dat");
    }

    @Override
    public void addSong(Song s) throws IOException
    {
        try (RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw"))
        {
            raf.seek(raf.length());  // place the file pointer at the end of the file.
            raf.writeInt(s.getId());
            raf.writeBytes(String.format("%-" + NAME_SIZE + "s", s.getSongName()).substring(0, NAME_SIZE));
        }
    }

    @Override
    public List<Song> getAll() throws IOException
    {
        try (RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw"))
        {
            List<Song> departments = new ArrayList<>();

            while (raf.getFilePointer() < raf.length())
            {
                departments.add(getOneSong(raf));
            }
            return departments;
        }
    }

    @Override
    public Song getById(int departmentId) throws IOException
    {
        try (RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw"))
        {
            for (int pos = 0; pos < raf.length(); pos += RECORD_SIZE)
            {
                raf.seek(pos);
                int id = raf.readInt();
                if (id == departmentId)
                {
                    raf.seek(pos);
                    return getOneSong(raf);
                }
            }
            return null;
        }
    }

    @Override
    public void deleteById(int id) throws IOException
    {
        try (RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw"))
        {
            for (int pos = 0; pos < raf.length(); pos += RECORD_SIZE)
            {
                raf.seek(pos);
                int currentId = raf.readInt();
                if (currentId == id)
                {
                    raf.seek(pos);
                    raf.write(new byte[RECORD_SIZE]); // write as many blank bytes as one record
                }
            }
        }
    }

    private Song getOneSong(final RandomAccessFile raf) throws IOException
    {
        byte[] bytes = new byte[NAME_SIZE];
        int id = raf.readInt();
        raf.read(bytes);
        String name = new String(bytes).trim();
        String artist = new String(bytes).trim();
        String location = new String(bytes).trim();
        return new Song(id, name, artist, location);
    }

    @Override
    public void saveAll(List<Song> songs) throws IOException
    {
        
        
        try (RandomAccessFile raf = new RandomAccessFile(new File(fileName), "rw"))
        {
            for (Song song : songs)
            {
                raf.seek(raf.length());  // place the file pointer at the end of the file.
                raf.writeInt(song.getId());
                raf.writeBytes(String.format("%-" + NAME_SIZE + "s", song.getSongName()).substring(0, NAME_SIZE));
                raf.writeBytes(String.format("%-" + ARTIST_SIZE + "s", song.getArtist()).substring(0, NAME_SIZE));
                raf.writeBytes(String.format("%-" + LOCATION_SIZE + "s", song.getArtist()).substring(0, NAME_SIZE));
            }
        }
    }
}
    

