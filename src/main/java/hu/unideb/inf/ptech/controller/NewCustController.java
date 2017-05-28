package hu.unideb.inf.ptech.controller;

import hu.unideb.inf.ptech.model.Ugyfel;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NewCustController implements Initializable 
{

    SqlLekerdezesek sql = new SqlLekerdezesek();

    @FXML
    private Label label;

    @FXML
    private TextField nev;
    ;

    @FXML
    private TextField email;
    ;

    @FXML
    private TextField lakcim;
    ;

    @FXML
    private TextField telefonszam;
    ;

    @FXML
    private void megseButtonAction(ActionEvent event) {
        thisStage.close();
    }

    @FXML
    private void okButtonAction(ActionEvent event) 
    {

        Ugyfel ugyfel = new Ugyfel();
        System.out.println(nev.getText() + " " + nev.getSelectedText() + " " + nev.toString());
        ugyfel.setNev(nev.getText());
        ugyfel.setLakcim(lakcim.getText());
        ugyfel.setEmail(email.getText());
        ugyfel.setTelefonszam(telefonszam.getText());
        ugyfel.setSzazon(0);
        ugyfel.setMegkereses(0);
        System.out.println(ugyfel.toString());
        sql.ujUgyfel(ugyfel);
        thisStage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }

    Stage thisStage;

    public void setStage(Stage stage) 
    {
        thisStage = stage;
    }

    public void showStage() 
    {


    }
}
