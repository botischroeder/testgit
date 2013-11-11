import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class MarktplatzView extends SpielView{
	
	
	//private ArrayList<Map> viewkeys = new ArrayList<>();
	private Map<String, String> viewkeys = new HashMap<>();
	//private ArrayList< String> spielAnzeige = new ArrayList<>();
	
	
	private static MarktplatzView marktplatzView;
	
	
	private MarktplatzView() {
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
	
	
	public static MarktplatzView getInstance() {
		if ( marktplatzView == null ) {
			marktplatzView = new MarktplatzView();
		}
		return marktplatzView;
	}
	
	
	
	private void setKeys(int viewIndex){
		viewkeys.clear();
		viewkeys.putAll( keys );
		switch(viewIndex)
		{
			case 1:
				viewkeys.put( "K", "KAUFEN");
				viewkeys.put( "V", "VERKAUFEN" );
				break;
				
			case 2:
				viewkeys.put( "K", "KORN_KAUFEN" );
				viewkeys.put( "F", "FELD_KAUFEN" );
				break;
				
		}
		
	}
	
	@Override
	public ArrayList<String> getScreen(){
		ArrayList<String> ausgabe = new ArrayList<>();
		ausgabe.addAll( createStatusAnzeige(spieler) );
		switch(viewIndex){
			
			case 1:
				ausgabe.add( "║             (K)aufen oder (v)erkaufen          ║" );
				ausgabe.add( "║                                                ║" );
				//usw.
				ausgabe.add( letzteZeile );
				ausgabe.add( "Soll gekauft oder verkauft werden?" );
				break;
			case 2:
				ausgabe.add( "║             (K)orn                             ║" );
				ausgabe.add( "║             (F)eld                             ║" );
				//usw.
				ausgabe.add( letzteZeile );
				ausgabe.add( "Welche Ware soll gehandelt werden?" );
				break;
			case 3:
				ausgabe.add( "║        Wieviel Korn soll gehandelt werden      ║" );
				
				//usw.
				ausgabe.add( letzteZeile );
				ausgabe.add( "Wieviel Ware soll gehandelt werden?" );
				break;
			default:
							
		}
		return ausgabe;
	}
	
	@Override
	public Map<String, String> getKeys(){
		setKeys( viewIndex );
		return viewkeys;
	}
	
	@Override
	public void setViewIndex(int viewIndex){
		this.viewIndex = viewIndex;
	}
	
	public void setSpieler( Spieler spieler ) {
		this.spieler = spieler;
		
	}

	@Override
	public Spieler getSpieler() {
		return spieler;
	}

	


	
}
