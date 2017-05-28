package hu.unideb.inf.ptech.controller;

import hu.unideb.inf.ptech.model.Szerzodes;
import hu.unideb.inf.ptech.model.Ugyfel;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ContractController implements Initializable 
{
    SqlLekerdezesek sql = new SqlLekerdezesek();
    Stage thisStage;
    Szerzodes szerzodes;
    Ugyfel ugyfel;
    @FXML
    private Label label;
    @FXML
    private Label azonosito;
    @FXML
    private Label kezdoDatum;
    @FXML
    private Label vegDatum;
    @FXML
    private Label terulet;
    @FXML
    private Label ar;

    public ContractController() 
    {
        
    }

    @FXML
    private void megseButtonAction(ActionEvent event) 
    {
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }

    public void setStage(Stage stage) 
    {
        thisStage = stage;
    }

    public void setUgyfel(Ugyfel ugyfel) 
    {
        this.ugyfel = ugyfel;
    }
    
    public void getSzerzodes()
    {
        Integer szAzon = ugyfel.getSzazon();
        szerzodes = sql.getSzerzodes(szAzon);
    }
    
    public void fillLabels()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        azonosito.setText(Integer.toString(szerzodes.getAzon()));
        kezdoDatum.setText(sdf.format(szerzodes.getKezdoDatum()));
        vegDatum.setText(sdf.format(szerzodes.getVegDatum()));
        terulet.setText(Integer.toString(szerzodes.getTerulet()));
        ar.setText(Integer.toString(szerzodes.getAr()));
    }
    
    public void work (Ugyfel ugyfel)
    {
        setUgyfel(ugyfel);
        getSzerzodes();
        fillLabels();
    }
}
