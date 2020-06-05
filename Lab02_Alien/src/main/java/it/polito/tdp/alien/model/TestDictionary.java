package it.polito.tdp.alien.model;

public class TestDictionary {
	
	public void run() {
		AlienDictionary ad=new AlienDictionary();
		ad.addWord("Wasser", "Acqua");
		System.out.println("La parola aliena Wasser significa "+ad.translateWord("Mutter"));
	}

	public static void main(String[] args) {
		TestDictionary test= new TestDictionary();
		test.run();

	}

}
