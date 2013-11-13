/**
 * 
 */

/**
 * @author Timo
 *
 */

import java.util.ArrayList;

public abstract class SpielView extends View {

	// protected ArrayList< String> statusAnzeige = new ArrayList<>();
	protected Spieler spieler;
	protected Spiel spiel;
	protected String menueUnterZeile = "╠═════════════╩══════════╩══════════════╩═════════════╩═════════════╩══════════╣";

//	protected SpielView() {
//
//	}

	protected SpielView(Spiel spiel) {
		super();
		this.spiel = spiel;
		// keys.put( "F1", "HILFE" );
		generalKeys.put( "F2", "UEBERSICHT" );
		generalKeys.put( "F3", "AKTION" );
		generalKeys.put( "F4", "MARKTPLATZ" );
		generalKeys.put( "F5", "STATISTIK" );
		generalKeys.put( "F6", "SPIELMENUE" );
		generalKeys.put( "F7", "CHAT" );
		generalKeys.put( "ESC", "ZURUECK" );
		// usw.

	}

	/** Erstellt die Statusanzeige für den gesetzten Spieler.
	 * @param spieler Der Spieler, für den die Statusanzeige erstellt werden soll
	 *            
	 */
	protected void createStatusAnzeige( Spieler spieler ) {
//		ArrayList<String> statusAnzeige = new ArrayList<>();
//		statusAnzeige.add( "╔══════════════════════════════════════════════════════════════════════════════╗" );
		statusAnzeige.add( ersteZeile );
		statusAnzeige.add( "║" + addUmgebendeLeerzeichen( spieler.getTitel() + " " + spieler.getName() ) + "║" );
		statusAnzeige.add( "╠══════════════════════════════════════════════════════════════════════════════╣" );
		statusAnzeige.add( "║Ländereien: "+addVoranstehendeLeerzeichen( "XXX", 3 ) +"  Felder: "+addVoranstehendeLeerzeichen( "XX", 3 )+"  Mühlen: "+addVoranstehendeLeerzeichen( "XX", 3 )+"  Speicher(Kapazität): "+addVoranstehendeLeerzeichen( "XX", 3 )+ "("+addVoranstehendeLeerzeichen( "XXX", 4 )+")     ║");
		statusAnzeige.add( "║Einwohner: "+addVoranstehendeLeerzeichen( "XXX", 3 ) +" Soldaten: "+addVoranstehendeLeerzeichen( "XXX", 3 ) +" Korn: "+addVoranstehendeLeerzeichen( "XXX", 3 ) +" Mehl: "+addVoranstehendeLeerzeichen( "XXX", 3 ) +" Dünger: "+addVoranstehendeLeerzeichen( "XXX", 3 ) +" Gold: "+addVoranstehendeLeerzeichen( "XXX", 4 ) +"       ║" );
		statusAnzeige.add( "╠═════════════╦══════════╦══════════════╦═════════════╦═════════════╦══════════╣" );
		statusAnzeige.add( "║Übersicht(F2)║Aktion(F3)║Marktplatz(F4)║Statistik(F5)║Spielmenü(F6)║Chat(F7)  ║" );
//		statusAnzeige.add( "╠═════════════╩══════════╩══════════════╩═════════════╩═════════════╩══════════╣" );
		// usw.
	}
	
//	/**
//	 * @param spieler
//	 *            Der Spieler, für den die Statusanzeige erstellt werden soll
//	 * @return Die Statusanzeige
//	 */
//	protected ArrayList<String> createStatusAnzeige( Spieler spieler ) {
//		ArrayList<String> statusAnzeige = new ArrayList<>();
//		statusAnzeige.add( "╔══════════════════════════════════════════════════════════════════════════════╗" );
//		statusAnzeige.add( "║" + addUmgebendeLeerzeichen( spieler.getTitel() + " " + spieler.getName() ) + "║" );
//		// usw.
//		return statusAnzeige;
//	}

	/**
	 * Erzeugt eine View-Zeile mit beginnendem und abschließendem ║. Der übergebene String wird zwischen ║ als Menüpunkt eingebettet.
	 * 
	 * @param vorlauf
	 *            Anzahl Leerzeichen vor dem Menübeginn
	 * @param string
	 *            der übergebene String
	 * @return die View-Zeile
	 */
	protected String generateZeile( int vorlauf, String string ) {
		return "║" + addLeerzeichen( vorlauf ) + "║" + string + "║" + addLeerzeichen( 76 - vorlauf - string.length() ) + "║";
	}

	/**
	 * Erzeugt eine View-Zeile mit beginnendem und abschließendem ║ und einem Menüpunktabschluss, der bei "beginn" anfängt und bei "ende" endet.
	 * 
	 * @param beginn
	 *            Der Beginn des Menüs
	 * @param ende
	 *            Das Ende des Menüs
	 * @return Die View-Zeile
	 */
	protected String generateMenüpunktabschlusszeile( int beginn, int ende ) {
		String menueAbschluss;
		if ( beginn != 1 ) {
			menueAbschluss = "╚";
		} else {
			menueAbschluss = "╠";
		}

		for ( int i = 0; i < ( ende - 1 - beginn ); i++ ) {
			menueAbschluss += "═";
		}
		if ( ende != 80 ) {
			menueAbschluss += "╝";
		} else {
			menueAbschluss += "╣";
		}
		return "║" + addLeerzeichen( beginn - 1 ) + menueAbschluss  +addLeerzeichen( 78 - ende ) + "║";
	}

	/**
	 * Erzeugt die View-Zeile, die zwischen Menü und Menüpunkten ist. Bei "beginn" beginnt das Menü nach unten und bei "ende" endet es.
	 * 
	 * @param beginn
	 *            Der Beginn des Menüs
	 * @param ende
	 *            Das Ende des Menüs
	 * @return Die View-Zeile
	 */
	protected String generateMenüpunktbeginnzeile( int beginn, int ende ) {
//		char[] zeile = statusAnzeige.get( statusAnzeige.size() - 1 ).toCharArray();
		char[] zeile = menueUnterZeile.toCharArray();
		if ( beginn != 1 ) {
			if ( zeile[beginn] == '╩' ) {
				zeile[beginn] = '╬';
			} else {
				zeile[beginn] = '╦';
			}
		}

		if ( ende != 80 ) {
			if ( zeile[ende] == '╩' ) {
				zeile[ende] = '╬';
			} else {
				zeile[ende] = '╦';
			}
		}
		return new String( zeile );
	}
	
	/**Erstellt einen Screen. Umfasst den gesammten Bereich von der Abschlusszeile des Ansichtmenüs bis zur letzten Zeile (Anweisung/Frage). 
	 * @param menuPunkte Liste mit den Punkten für das Untermenü
	 * @param anweisung Die Anweisung für die letzte Zeile
	 * @param beginn Ab welcher Stelle soll das Untermenü beginnen 
	 * @param ende An welcher Stelle soll das Untermenü enden
	 * @return
	 */
	protected ArrayList<String> createMenuePunktAnsicht(ArrayList<String> menuPunkte, String anweisung, int beginn, int ende){
		ArrayList<String> ausgabe = new ArrayList<>();
		ausgabe.add( generateMenüpunktbeginnzeile( beginn, ende ) );
		
		for (String menuPunkt: menuPunkte){
			ausgabe.add(generateZeile(beginn - 1, menuPunkt));
		}
		
		ausgabe.add(generateMenüpunktabschlusszeile(beginn, ende));
		ausgabe.addAll(generateLeerzeilen(ausgabe.size()));
		ausgabe.add( anweisung );
		
		return ausgabe;
	}

	public void setSpieler( Spieler spieler ){
		this.spieler = spieler;
		createStatusAnzeige( spieler );
	}
	
	public Spieler getSpieler( ) {
		return spieler;
	}

	

	// @Override
	// public ArrayList<String> getScreen(){
	// ArrayList<String> ausgabe = new ArrayList<>();
	// ausgabe.addAll(createStatusAnzeige(spieler));
	// return ausgabe;
	// }
	//
	// @Override
	// public Map<String, String> getKeys(){
	// setKeys( viewIndex );
	// return viewkeys;
	// }

}
