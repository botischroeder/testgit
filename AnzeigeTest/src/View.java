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
	protected Map<Integer, Map<String, String>> viewkeys = new HashMap<>();
	protected ArrayList<String> statusAnzeige = new ArrayList<>();
	protected Map<Integer, ArrayList<String>> screens = new HashMap<>();
	protected String ersteZeile = "╔══════════════════════════════════════════════════════════════════════════════╗";
	protected String letzteZeile = "╚══════════════════════════════════════════════════════════════════════════════╝";
	
	public abstract void generateKeys();
	public abstract void generateScreens();
	
	
	
	
	/**Fügt einen Screen (exkl. Statusanzeige) für den entsprechenden Viewindex der screens-Map hinzu. 
	 * @param index Der Viewindex
	 * @param screen Der hinzuzufügende Screen 
	 */
	protected void addScreen(int index, ArrayList<String> screen ){
		ArrayList<String> tempScreen = new ArrayList<>();
		tempScreen.addAll(screen);
		screens.put(index, tempScreen);
	}
	
	/**Fügt eine Map mit den gültigen Keys für den entsprechenden Viewindex der viewkeys-Map hinzu.
	 * @param index Der Viewindex
	 * @param keys Die hinzuzufügende Map mit den Keys
	 */
	protected void addKeys(int index, Map<String, String> keys ){
		Map<String, String> tempKeys = new HashMap<>();
		tempKeys.putAll(keys);
		viewkeys.put(index, tempKeys);
	}
	
	/**Liefert den Screen für den aktuellen Viewindex zurück
	 * @return ArrayList mit dem Screen
	 */
	public ArrayList<String> getScreen(){
		ArrayList<String> ausgabe = new ArrayList<>();
		ausgabe.addAll(statusAnzeige);
		ausgabe.addAll(screens.get(viewIndex));
		return ausgabe;
	}
	
	
	/**Liefert die gültigen Eingaben für den aktuellen Screen zurück.
	 * @return Map mit gültigen Eingaben
	 */
	public Map<String, String> getKeys(){
		Map<String, String> returnKeys = new HashMap<>();
		returnKeys.putAll(generalKeys);
		returnKeys.putAll(viewkeys.get(viewIndex));
		return returnKeys;
	}
	
	
	
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
		for (int i = 0; i < (25 - anzahlVorhandenerZeilen - 10); i++){
			leerzeilen.add(addLeerzeile());
		}
		leerzeilen.add(letzteZeile);
		return leerzeilen;
	}
}
