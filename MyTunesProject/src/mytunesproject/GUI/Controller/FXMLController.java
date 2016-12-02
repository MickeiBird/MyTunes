/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.GUI.Controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import mytunesproject.BE.Song;
import mytunesproject.BLL.SongManager;
import mytunesproject.DAL.RandomSaver;
import mytunesproject.GUI.Model.SongModel;
import mytunesproject.Util.SongException;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class FXMLController implements Initializable
{

    private Window stage;
    @FXML
    public TextField TitleField;
    private  SongModel model;
    
    @FXML
    private ComboBox<?> CategoryBox;
    @FXML
    public TextField FileField;
    @FXML
    public TextField IdField;
    @FXML
    public TextField ArtistField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    public void setModel(SongModel model)
    {
        this.model = model;
    }

    
    @FXML
    private void btnOpen(ActionEvent event)
    {

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File");

        File selectedFile = fileChooser.showOpenDialog(stage);

        FileField.setText(selectedFile.getAbsolutePath());

    }

    @FXML
    private void btnSave(ActionEvent event)
    {
        model.addSong(Integer.parseInt(IdField.getText()), TitleField.getText(), ArtistField.getText(), FileField.getText());
        //model.setText(textEnter.getText());
////manager.addAll(new ArrayList(FXMLDocumentController.TableSongs.getItems()));
//          
//      }
//      catch (SongException ex)
//      {
//          showAndLogError(ex);
//      }
//      //Song newSong = new Song(Integer.parseInt(IdField.getText()), TitleField.getText(), ArtistField.getText(), FileField.getText());  
//      //System.out.println(newSong);
    }

    private static void showAndLogError(SongException ex)
    {
        Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);

        Alert alert = new Alert(AlertType.ERROR,
                ex.getMessage()
                + String.format("%n")
                + "See error log for technical details."
        );
        alert.showAndWait();

    }
}
