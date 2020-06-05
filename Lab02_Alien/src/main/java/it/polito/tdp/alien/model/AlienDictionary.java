package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;
	
	public AlienDictionary() {
		dictionary=new ArrayList<>();
	}
	
	/**
	 * Questo metodo resetta il dizionario.
	 */
	public void resetDictionary() {
		this.dictionary.clear();
	}

	/**
	 * Questo metodo associa la traduzione tra due parole passate come parametro,
	 * rispettivamente la {@code parola aliena} e la sua {@code traduzione}.
	 */
	public void addWord(String alien, String translation) {
		Word w= new Word(alien, translation);
		if(dictionary.contains(w)) {
			//se il dizionario contiene già la parola, vado a modificarne la traduzione.
			//Ovvero cerco la posizione della parola con indexOf, poi accedo a quella parola
			//con get(tale poiszione) e poi setto la nuova traduzione.
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
			return;
		}
		dictionary.add(w);
		return;
	}
	
	/**
	 * Il metodo restituisce la traduzione di una parola aliena passata come parametro
	 * se questa è presente nel dizionario.
	 * @param alien è la parola aliena da tradurre
	 * @return la traduzione ({@link null} in caso non sia prensente nel dizionario)
	 */
	public String translateWord(String alien) {
		Word w=new Word(alien);
		if(dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
}
