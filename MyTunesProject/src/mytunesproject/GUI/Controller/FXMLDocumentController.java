/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesproject.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JFileChooser;
import mytunesproject.BE.Song;
import mytunesproject.BLL.SongManager;
import mytunesproject.GUI.Model.SongModel;
import sun.plugin.javascript.navig.Anchor;

/**
 * FXML Controller class
 *
 * @author Domea
 */
public class FXMLDocumentController implements Initializable
{

    private SongModel model;
    
    @FXML
    private Button Playbtn;

    @FXML
    private Button newSongBtn;

    final JFileChooser fc = new JFileChooser();
    private Window stage;
    private Object FXMLController;
    @FXML
    private TableColumn<Song, Anchor> IdClm;
    @FXML
    private TableColumn<Song, String> TitleClm;
    @FXML
    private TableColumn<Song, String> ArtistClm;
    @FXML
    public TableView<Song> TableSongs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new SongModel();
    }

    @FXML
    private void btnPlay(ActionEvent event)
    {
        //model.play();
    }

    @FXML
    private void btnPause(ActionEvent event)
    {
        //song.pause();
    }

    @FXML
    private void AddNewSong(ActionEvent event) throws IOException
    {
        Stage primStage = (Stage) TableSongs.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/mytunesproject/GUI/View/FXML.fxml"));
        Parent root = loader.load();

        // Fetches controller 
        FXMLController controller = loader.getController();
        controller.setModel(model);
        // Sets new stage as modal window
        Stage stagePatientView = new Stage();
        stagePatientView.setScene(new Scene(root));

        stagePatientView.initModality(Modality.WINDOW_MODAL);
        stagePatientView.initOwner(primStage);

        stagePatientView.show();
    }

    @FXML
    public void readDataIntoList()
    {
        
    }

}
