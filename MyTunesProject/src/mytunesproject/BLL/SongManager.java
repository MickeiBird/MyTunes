/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.BLL;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author simon
 */
public class SongManager {
    
public void play()
{
    File soundfile = new File("C:\\Users\\simon\\Documents\\GitHub\\MyTunes\\MyTunesProject\\src\\mytunesproject\\AllSongs\\gameover2.mp3");
    Media media = new Media(soundfile.toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);
    mediaplayer.play();
}

    
}
