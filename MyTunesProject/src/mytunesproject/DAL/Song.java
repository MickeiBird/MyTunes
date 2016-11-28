/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.DAL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Domea
 */
public class Song {
    
    public void play()
    {
    String HMM = "HMM.mp3";
    Media hit = new Media(HMM);
    MediaPlayer mediaplayer = new MediaPlayer(hit);
    mediaplayer.play();
    }

            
}
