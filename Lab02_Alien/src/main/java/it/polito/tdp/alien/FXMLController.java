package it.polito.tdp.alien;
import it.polito.tdp.alien.model.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dictionary=new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtInsert.clear();
    	txtResult.clear();
    	dictionary.resetDictionary();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	
    	String riga=txtInsert.getText().toLowerCase(); //ACQUISISCO L'INPUT
    	//VERIFICO CHE L'INPUT NON SIA VUOTO
    	if(riga==null||riga.length()==0) {
    		txtResult.setText("Inserire una o due parole");
    		return;
    	}
    	
    	//Uso un tokenizer
    	StringTokenizer st= new StringTokenizer(riga," ");
    	
    	if(!st.hasMoreElements()) {
    		txtResult.setText("Inserire una o due parole");
    	}
    	
    	String alienWord=st.nextToken(); //SALVO LA PRIMA PARTE DELL'INPUT COME PAROLA ALIENA
    	//CONTROLLO SE HO SOLO UNA O DUE PAROLE
    	if(st.hasMoreTokens()) { 
    		String translation= st.nextToken(); //SALVO LA SECONDA PARTE COME TRADUZIONE
    		//ORA CONTROLLO CHE I FORMATI SIANO GIUSTI, CON REGEX
    		if(!alienWord.matches("[a-zA-Z]*")||!translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		dictionary.addWord(alienWord, translation);
    		txtResult.setText("La parola \""+alienWord+"\", con traduzione \""+translation+"\" è stata aggiunta al dizionario");
    	}else { //ALTRIMENTI HO UNA SOLA PAROLA, QUINDI STO CERCANDO LA TRADUZIONE
    	//CONTROLLO IL FORMATO, INNANZITUTTO
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		String translation= dictionary.translateWord(alienWord);
    		if(translation!=null) {
    			txtResult.setText(translation);
    		}else {
    			txtResult.setText("La parola inserita non è presente nel dizionario");
    		}
    	}
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

