/**
 * 
 */

/**
 * @author Timo
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public abstract class View {
	protected int viewIndex;
	
	protected Map<String, String> generalKeys = new HashMap<>();
	protected ArrayList<Map<String, String>> viewkeys = new ArrayList<>();
	
	protected ArrayList<String> statusAnzeige = new ArrayList<>(20);
//	protected ArrayList<String> spielAnzeige = new ArrayList<>();
	protected ArrayList<ArrayList<String>> anzeigen = new ArrayList<>();
	
//	protected View SubView;
	
	protected String letzteZeile = ("╚══════════════════════════════════════════════════════════════════════════════╝");
	
	public abstract void generateKeys();
	public abstract void generateScreens();
	
	
	
	
	protected void addScreen(ArrayList<String> screen, int index){
		ArrayList<String> tempScreen = new ArrayList<>();
		tempScreen.addAll(screen);
		anzeigen.add(index, tempScreen);
	}
	
	protected void addKeys(Map<String, String> keys, int index){
		Map<String, String> tempKeys = new HashMap<>();
		tempKeys.putAll(keys);
		viewkeys.add(index, tempKeys);
	}
	
	public ArrayList<String> getScreen(){
		ArrayList<String> ausgabe = new ArrayList<>();
		ausgabe.addAll(statusAnzeige);
		ausgabe.addAll(anzeigen.get(viewIndex));
		return ausgabe;
	}
	
	
	public Map<String, String> getKeys(){
		Map<String, String> returnKeys = new HashMap<>();
		returnKeys.putAll(generalKeys);
		returnKeys.putAll(viewkeys.get(viewIndex));
		return returnKeys;
	}
	
	
	
	
//	public Spieler getSpieler(){
//		return spieler;
//	}
	
	public void setViewIndex(int viewIndex){
		this.viewIndex = viewIndex;
	}
	
	
	/**
	 * Generiert Leerzeichen
	 * @param anzahl Anzahl der zu generierenden Leerzeichen
	 * @return String mit der angegebenen Anzahl von Leerzeichen
	 */
	protected String addLeerzeichen(int anzahl){
		String string = new String();
		for (int i = 0; i < anzahl; i++){
			string+= " ";
		}
		return string;
	}
	
	/**
	 * Bettet den übergebenen String mittig zwischen Leerzeichen ein. Die Gesamtlänge beträgt 78 Zeichen.
	 * @param string der übergebene String
	 * @return String mit umbegenden Leerzeichenn
	 */
	protected String addUmgebendeLeerzeichen(String string){
		int length = 78 - string.length();
		return addLeerzeichen(length / 2) +string + addLeerzeichen(length / 2);
	}
	
	
	/**
	 * Erweitert den übergebenen String um voranstehende Leerzeichen um ihn auf die gewünschte Länge zu bringen.
	 * @param string der übergebene String
	 * @param benoetigteLaenge Gesamtlänge des zu erzeugenden Strings
	 * @return String mit der gewünschten Gesamtlänge
	 */
	protected String addVoranstehendeLeerzeichen(String string, int benoetigteLaenge){
		int length = benoetigteLaenge - string.length();
		return addLeerzeichen(length) + string;
	}
	
	
	
	/**
	 * Erzeugt eine View-Leerzeile mit beginnendem und abschließendem ║
	 * @return die View-Leerzeile
	 */
	protected String addLeerzeile(){
		return "║" +addLeerzeichen(78) +"║";
	}
	
	/**
	 * Erzeugt View-Leerzeilen, inkl. einer abschließenden Zeile
	 * @param anzahlVorhandenerZeilen Anzahl der schon vorhandenen View-Zeilen
	 * @return ArrayList<String> mit den generierten View-Leerzeilen
	 */
	protected ArrayList<String> generateLeerzeilen(int anzahlVorhandenerZeilen){
		ArrayList<String> leerzeilen = new ArrayList<>();
		for (int i = 0; i < (25 - anzahlVorhandenerZeilen - 3); i++){
			leerzeilen.add(addLeerzeile());
		}
		leerzeilen.add(letzteZeile);
		return leerzeilen;
	}
}
