package hu.unideb.inf.ptech.controller;

import hu.unideb.inf.ptech.model.Szerzodes;
import hu.unideb.inf.ptech.model.Ugyfel;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController implements Initializable 
{

    SqlLekerdezesek sql = new SqlLekerdezesek();
    Stage thisStage;

    @FXML
    private Label label;
    @FXML
    private TableView<Ugyfel> tabla;
    @FXML
    TableColumn azon;
    @FXML
    TableColumn nev;
    @FXML
    TableColumn telefonszam;
    @FXML
    TableColumn email;
    @FXML
    TableColumn lakcim;
    @FXML
    TableColumn megkereses;
    @FXML
    TableColumn szazon;
    @FXML
    private ComboBox<String> evCombo;
    @FXML
    private TextField  terulet;
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        azon.setCellValueFactory(new PropertyValueFactory<Ugyfel, Integer>("azon"));
        nev.setCellValueFactory(new PropertyValueFactory<Ugyfel, String>("nev"));
        telefonszam.setCellValueFactory(new PropertyValueFactory<Ugyfel, String>("telefonszam"));
        email.setCellValueFactory(new PropertyValueFactory<Ugyfel, String>("email"));
        lakcim.setCellValueFactory(new PropertyValueFactory<Ugyfel, String>("lakcim"));
        megkereses.setCellValueFactory(new PropertyValueFactory<Ugyfel, Integer>("megkereses"));
        szazon.setCellValueFactory(new PropertyValueFactory<Ugyfel, Integer>("szazon"));

        ObservableList<Ugyfel> list = FXCollections.observableArrayList();

        list.addAll(sql.getUgyfelAll());

        tabla.setItems(list);
    }

    @FXML
    private void newCustButtonAction(ActionEvent event) throws IOException 
    {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newcust.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        NewCustController nwController = fxmlLoader.getController();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Új felhasználó");
        stage.setScene(scene);
        nwController.showStage();
        nwController.setStage(stage);
        stage.show();
    }
    
    @FXML
    private void contractButtonAction(ActionEvent event) throws IOException 
    {
        Ugyfel ugyfel = null;
        Integer ugyfelazon = 0;
        try {
            ugyfel = tabla.getSelectionModel().getSelectedItem();
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Kérem töltse ki az input mezőket helyesen");
            alert.setContentText("Kérem töltse ki az input mezőket helyesen!Amennyiben nem tölti ki helyen a mezőket, nem fog tudni árat kalkulálni.");
            alert.showAndWait();
        }
        
        if (ugyfel.getSzazon() != null && ugyfel.getSzazon() != 0) 
        {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/contract.fxml"));
            Pane root = (Pane) fxmlLoader.load();
            ContractController contractController = fxmlLoader.getController();
            contractController.work(ugyfel);
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            stage.setTitle("Szerződés");
            stage.setScene(scene);
            
            contractController.setStage(stage);
            stage.show();

        } 
        else 
        {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Válasszon olyan ügyfelet akinek van szerződése");
            alert.setContentText("Kérem olyan ügyfelet válasszon akinek van szerződése!");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void arSzamitasButtonAction(ActionEvent event) throws IOException 
    {
        Double ter =0.0;
        Integer ev = 0;
        Kalkulator kalkulator = new Kalkulator();
        Ugyfel ugyfel = null;
        String terStr = "";
        String kivalasztottEv = "";
        
        try {
            ugyfel = tabla.getSelectionModel().getSelectedItem();
            kivalasztottEv = evCombo.getSelectionModel().getSelectedItem();
            terStr = terulet.getText();
            ter = Double.valueOf(terulet.getText());
            
            switch(kivalasztottEv){
                case "1 év": ev = 1;break;
                case "2 év": ev = 2;break;
                case "3 év": ev = 3;
            }
            label.setText(Integer.toString(kalkulator.arSzamitas(ugyfel,ter,ev )));
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Kérem töltse ki az input mezőket helyesen");
            alert.setContentText("Kérem töltse ki az input mezőket helyesen!Amennyiben nem tölti ki helyen a mezőket, nem fog tudni árat kalkulálni.");
            alert.showAndWait();
        }
               
    }
    
    @FXML
    private void szerzodeskotesButtonAction(ActionEvent event) throws IOException 
    {
        Double ter =0.0;
        Integer ev = 0;
        Kalkulator kalkulator = new Kalkulator();
        Ugyfel ugyfel = null;
        String terStr = "";
        String kivalasztottEv = "";
        Integer ar = 0;
        try {
            ugyfel = tabla.getSelectionModel().getSelectedItem();
            kivalasztottEv = evCombo.getSelectionModel().getSelectedItem();
            terStr = terulet.getText();
            ter = Double.valueOf(terulet.getText());
            switch(kivalasztottEv){
                case "1 év": ev = 1;break;
                case "2 év": ev = 2;break;
                case "3 év": ev = 3;
            }
            ar = kalkulator.arSzamitas(ugyfel,ter,ev );
            Date date = new java.util.Date();
            
            Szerzodes szerzodes = new Szerzodes(new Timestamp(date.getTime()), ugyfel.getAzon(), ev, ter.intValue(), ar);
            sql.ujSzerzodesKotes(ugyfel, szerzodes);
            handleButtonAction(event);
            
            
            
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Kérem töltse ki az input mezőket helyesen");
            alert.setContentText("Kérem töltse ki az input mezőket helyesen!Amennyiben nem tölti ki helyen a mezőket, nem fog tudni árat kalkulálni.");
            alert.showAndWait();
        }
               
    }
    
    @FXML
    private void torlesButtonAction(ActionEvent event) 
    {
        Ugyfel ugyfel = null;
        try {
            ugyfel = tabla.getSelectionModel().getSelectedItem();
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Ügyfél törlés");
            dialog.setHeaderText("Biztosan törölni akarja az ügyfelet?");
            dialog.setContentText("Amennyiben törli az ügyfelet, úgy nem tud majd szerződést kötni neki.");
            final Optional<ButtonType> result = dialog.showAndWait();
            if ( result.get() == ButtonType.OK) {
                sql.deleteUgyfelById(ugyfel);
                handleButtonAction(event);
            }
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Kérem töltse ki az input mezőket helyesen");
            alert.setContentText("Kérem töltse ki az input mezőket helyesen!Amennyiben nem tölti ki helyen a mezőket, nem fog tudni árat kalkulálni.");
            alert.showAndWait();
        }

    }
    
    @FXML
    private void erestitesButtonAction(ActionEvent event) 
    {
        Ugyfel ugyfel = null;
        try {
            ugyfel = tabla.getSelectionModel().getSelectedItem();
            sql.ertesitesKikuldese(ugyfel);
            handleButtonAction(event);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Kérem töltse ki az input mezőket helyesen");
            alert.setContentText("Kérem töltse ki az input mezőket helyesen!Amennyiben nem tölti ki helyen a mezőket, nem fog tudni árat kalkulálni.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void tomegesErestitesButtonAction(ActionEvent event) 
    {
        sql.ertesitesekTomegesKikuldese();
          handleButtonAction(event);
    }
    
    @FXML
    private void szerzodesTorlesButtonAction(ActionEvent event) 
    {
        Ugyfel ugyfel = null;
        Szerzodes szerzodes = null;
        Integer ugyfelazon = 0;
        try {
            ugyfel = tabla.getSelectionModel().getSelectedItem();
            Integer szAzon = ugyfel.getSzazon();
            szerzodes = sql.getSzerzodes(szAzon);
            Kalkulator kalkulator = new Kalkulator();
            
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Szerződés törlés");
            dialog.setHeaderText("Biztosan törölni akarzja a szerződést?");
            final Optional<ButtonType> result = dialog.showAndWait();
            if (result.get() == ButtonType.OK) {
                sql.szerzodesFelbontasa(ugyfel,szerzodes);
                handleButtonAction(event);
            }
            
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Figyelmeztető ablak");
            alert.setHeaderText("Kérem töltse ki az input mezőket helyesen");
            alert.setContentText("Kérem töltse ki az input mezőket helyesen!Amennyiben nem tölti ki helyen a mezőket, nem fog tudni árat kalkulálni.");
            alert.showAndWait();
        }
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }

    public void setStage(Stage stage) 
    {
        thisStage = stage;
    }

    public void showStage() 
    {
        
        thisStage.show();
    }
}
