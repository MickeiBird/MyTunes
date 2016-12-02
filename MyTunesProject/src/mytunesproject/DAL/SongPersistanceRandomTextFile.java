/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.DAL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mytunesproject.BE.Song;

/**
 *
 * @author simon
 */
public class SongPersistanceRandomTextFile extends AbstractSongPersistanceFile{
    public SongPersistanceRandomTextFile(String fileName)
    {
        super(fileName + ".txtdat");
    }

    @Override
    public void addSong(Song s) throws IOException
    {
        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(fileName, true)))
        {
            bw.append(s.getId() + "," + s.getSongName());
            bw.newLine();
        }
    }

    @Override
    public void deleteById(int Id) throws IOException
    {
        String newFileString = "";
        List<Song> depList = getAll();
        try (BufferedReader br
                = new BufferedReader(
                        new FileReader(fileName)))
        {
            Scanner scanner = new Scanner(br);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                if (id != Id)
                {
                    newFileString += line;
                }
            }
        }

        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(fileName)))
        {
            bw.write(newFileString);
        }
    }

    @Override
    public Song getById(int departmentId) throws IOException
    {
        try (BufferedReader br
                = new BufferedReader(
                        new FileReader(fileName)))
        {
            Scanner scanner = new Scanner(br);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                if (id == departmentId)
                {
                    return new Song(id, fields[1].trim(),fields[2].trim(),fields[3].trim());
                }
            }
        }
        return null;
    }

    @Override
    public List<Song> getAll() throws IOException
    {
        List<Song> depList = new ArrayList();

        try (BufferedReader br
                = new BufferedReader(
                        new FileReader(fileName)))
        {
            Scanner scanner = new Scanner(br);
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                depList.add(
                        new Song(
                                Integer.parseInt(fields[0].trim()),
                                fields[1].trim(),
                                fields[2].trim(),
                                fields[3].trim()
                        ));
            }
        }
        return depList;
    }

    @Override
    public void saveAll(List<Song> songs) throws IOException
    {
        super.clearAll(); // deletes contents of file
        try (BufferedWriter bw
                = new BufferedWriter(
                        new FileWriter(fileName, true)))
        {
            for (Song song : songs)
            {

                bw.append(song.getId() + "," + song.getSongName());
                bw.newLine();
            }
        }
    }
    
}
