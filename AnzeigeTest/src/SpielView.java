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


public abstract class SpielView extends View {
	
//	protected ArrayList< String> statusAnzeige = new ArrayList<>();
	
	
	
	protected SpielView(){
		
	}
	
	protected SpielView(Spieler spieler) {
		super();
//		keys.put( "F1", "HILFE" );
		generalKeys.put( "F2", "UEBERSICHT" );
		generalKeys.put( "F3", "AKTION" );
		generalKeys.put( "F4", "MARKTPLATZ" );
		generalKeys.put( "F5", "STATISTIK" );
		generalKeys.put( "F6", "SPIELMENUE" );
		generalKeys.put( "F7", "CHAT" );
		generalKeys.put( "ESC", "ZURUECK" );
		//usw.
		
		
		
	}
	
	/**
	 * @param spieler Der Spieler, für den die Statusanzeige erstellt werden soll
	 * @return Die Statusanzeige
	 */
	protected ArrayList<String> createStatusAnzeige(Spieler spieler){
		ArrayList<String> statusAnzeige = new ArrayList<>();
		statusAnzeige.add( "╔══════════════════════════════════════════════════════════════════════════════╗" );
		statusAnzeige.add( "║"+addUmgebendeLeerzeichen(spieler.getTitel() +" "+spieler.getName()) +"║" );
		//usw.
		return statusAnzeige;
	}
	
	/**
	 * Erzeugt eine View-Zeile mit beginnendem und abschließendem ║. Der übergebene String wird zwischen ║ als Menüpunkt eingebettet.
	 * @param vorlauf Anzahl Leerzeichen vor dem Menübeginn
	 * @param string der übergebene String
	 * @return die View-Zeile
	 */
	protected String generateZeile(int vorlauf, String string){
		return "║" +addLeerzeichen(vorlauf) +"║"+string+"║" +addLeerzeichen(76 - vorlauf - string.length()) +"║";
	}
	
	/**
	 * Erzeugt eine View-Zeile mit beginnendem und abschließendem ║ und einem Menüpunktabschluss, der bei "beginn" anfängt und bei "ende" endet.
	 * @param beginn Der Beginn des Menüs
	 * @param ende Das Ende des Menüs
	 * @return Die View-Zeile
	 */
	//TODO: beginn = 0 oder ende = 80
	protected String generateMenüpunktabschlusszeile(int beginn, int ende){
		String menueAbschluss = "╚";
		for (int i = 0; i < (ende - beginn); i++){
			menueAbschluss+="═";
		}
		menueAbschluss+="╝";
		return "║" +addLeerzeichen(beginn - 1) +"║"+menueAbschluss+"║" +addLeerzeichen(76 - ende) +"║";
	}
	
	/**
	 * Erzeugt die View-Zeile, die zwischen Menü und Menüpunkten ist. Bei "beginn" beginnt das Menü nach unten und bei "ende" endet es.
	 * @param beginn Der Beginn des Menüs
	 * @param ende Das Ende des Menüs
	 * @return Die View-Zeile
	 */
	protected String generateMenüpunktbeginnzeile(int beginn, int ende){
		char[] zeile = statusAnzeige.get(statusAnzeige.size() - 1).toCharArray();
		
		 
		if ( zeile[beginn] == '╩'){
			zeile[beginn] = '╬';
		}
		else{
			zeile[beginn] = '╦';
		}
		
		if ( zeile[ende] == '╩'){
			zeile[ende] = '╬';
		}
		else{
			zeile[ende] = '╦';
		}
		
		
		return zeile.toString();
	}
	
	
//	@Override
//	public ArrayList<String> getScreen(){
//		ArrayList<String> ausgabe = new ArrayList<>();
//		ausgabe.addAll(createStatusAnzeige(spieler));
//		return ausgabe;
//	}
//	
//	@Override
//	public Map<String, String> getKeys(){
//		setKeys( viewIndex );
//		return viewkeys;
//	}
	
	
	
	
	
	
}
