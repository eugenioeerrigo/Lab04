package it.polito.tdp.lab04.controller;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	private CorsoDAO corso;
	
	   @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="choiceBox"
	    private ChoiceBox<String> choiceBox; // Value injected by FXMLLoader

	    @FXML // fx:id="txtLog"
	    private TextField txtLog; // Value injected by FXMLLoader

	    @FXML // fx:id="nome"
	    private TextField nome; // Value injected by FXMLLoader

	    @FXML // fx:id="cognome"
	    private TextField cognome; // Value injected by FXMLLoader

	    @FXML
	    void handleButtonSqrt(ActionEvent event) {

	    }

	    @FXML
	    void handleCercaCorsi(ActionEvent event) {

	    }

	    @FXML
	    void handleCercaIscritti(ActionEvent event) {

	    }

	    @FXML
	    void handleIscrivi(ActionEvent event) {

	    }

	    @FXML
	    void handleReset(ActionEvent event) {

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
	        
	        //choiceBox.getItems().add(" ");
	        //for(int i=0; i<corso.getTuttiICorsi().size(); i++) {
	        	//choiceBox.setItems(corso.getTuttiICorsi().get(i).getNome());
	        //}
	        	
	    }
	
	public void setModel(Model model) {
		this.model = model;
		
	}

}
