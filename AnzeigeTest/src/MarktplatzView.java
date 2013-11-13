/**
 * 
 */

/**
 * @author Timo
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;




public class MarktplatzView extends SpielView{
	
	
	//private ArrayList<Map> viewkeys = new ArrayList<>();
;
	//private ArrayList< String> spielAnzeige = new ArrayList<>();
	
	
//	private static MarktplatzView marktplatzView;
	
	
	public MarktplatzView(Spiel spiel) {
		super(spiel);
		generateKeys();
		generateScreens();
//		SubView = this;
//		viewString = "MARKTPLATZ"
	}
	
//	public MarktplatzView( Spieler spieler, int viewIndex ) {
//		super( spieler );
//		this.viewIndex = viewIndex;
//		
//		//usw.
//		
//		
//	}
	
	
//	public static MarktplatzView getInstance() {
//		if ( marktplatzView == null ) {
//			marktplatzView = new MarktplatzView();
//		}
//		return marktplatzView;
//	}
	
	
	
	
	

	
//	private void setKeys(int viewIndex){
//		viewkeys.clear();
//		viewkeys.putAll( generalKeys );
//		switch(viewIndex)
//		{
//			case 1:
//				viewkeys.put( "K", "KAUFEN");
//				viewkeys.put( "V", "VERKAUFEN" );
//				break;
//				
//			case 2:
//				viewkeys.put( "K", "KORN_KAUFEN" );
//				viewkeys.put( "F", "FELD_KAUFEN" );
//				break;
//				
//		}
//		
//	}

	@Override
	public void generateKeys() {
		Map<String, String> keys = new HashMap<>();
		
		keys.put( "K", "KAUFEN");
		keys.put( "V", "VERKAUFEN" );
		addKeys(0, keys);
		keys.clear();
		
		keys.put( "K", "KORN_KAUFEN" );
		keys.put( "F", "FELD_KAUFEN" );
		addKeys(1, keys);
		keys.clear();
		
	}
	

	@Override
	public void generateScreens() {
//		ArrayList<String> ausgabe = new ArrayList<>();
//		int menuVorlauf = 20;
//		int menuNachlauf = 30;
		
//		ausgabe.add( generateMenüpunktbeginnzeile( 14, 40 ) );
//		ausgabe.add(generateZeile(13, "(K)aufen oder (v)erkaufen"));
//		ausgabe.add(generateMenüpunktabschlusszeile(14, 40));
//		ausgabe.addAll(generateLeerzeilen(ausgabe.size()));
//		ausgabe.add( "Soll gekauft oder verkauft werden?" );
//		addScreen( ausgabe, 0 );
//		ausgabe.clear();
		
//		ArrayList<String> punkte = new ArrayList<String>();
		
//		punkte.add( "(K)aufen oder (v)erkaufen" );
//		punkte.add( "(K)aufen oder (s)aufen   " );
//		new ArrayList<>(  );
//		Arrays.asList( "(K)aufen oder (v)erkaufen", "(K)aufen oder (s)aufen   " );
		addScreen(0, createMenuePunktAnsicht(new ArrayList<>( Arrays.asList( "(K)aufen oder (v)erkaufen", "(K)aufen oder (s)aufen   " ) ), "Soll gekauft oder verkauft werden?", 14, 40) );
		
		addScreen(1, createMenuePunktAnsicht(new ArrayList<>( Arrays.asList( "(K)orn      ", "(M)ehl      ", "(D)ünger    ", "(S)oldaten  ", "(L)ändereien" ) ), "Soll gekauft oder verkauft werden?", 14, 27) );
//		punkte.clear();
		
//		ausgabe.clear();
		
		
		
	}
	
	
	
//	@Override
//	public ArrayList<String> getScreen(){
//		ArrayList<String> ausgabe = new ArrayList<>();
//		ausgabe.addAll( createStatusAnzeige(spieler) );
//		switch(viewIndex){
//			
//			case 1:
//				ausgabe.add( "║             (K)aufen oder (v)erkaufen          ║" );
//				ausgabe.add( "║                                                ║" );
//				//usw.
//				ausgabe.add( letzteZeile );
//				ausgabe.add( "Soll gekauft oder verkauft werden?" );
//				break;
//			case 2:
//				ausgabe.add( "║             (K)orn                             ║" );
//				ausgabe.add( "║             (F)eld                             ║" );
//				//usw.
//				ausgabe.add( letzteZeile );
//				ausgabe.add( "Welche Ware soll gehandelt werden?" );
//				break;
//			case 3:
//				ausgabe.add( "║        Wieviel Korn soll gehandelt werden      ║" );
//				
//				//usw.
//				ausgabe.add( letzteZeile );
//				ausgabe.add( "Wieviel Ware soll gehandelt werden?" );
//				break;
//			default:
//							
//		}
//		return ausgabe;
//	}
	
	

	


	
}
