import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public abstract class SpielView extends View {
	protected Map<String, String> keys = new HashMap<>();
//	protected ArrayList< String> statusAnzeige = new ArrayList<>();
	protected String letzteZeile = ("╚══════════════════════════════╝");
	protected Spieler spieler;
	protected SpielView(){
		
	}
	
	protected SpielView(Spieler spieler) {
		super();
		keys.put( "F1", "HILFE" );
		keys.put( "F2", "ÜBERSICHT" );
		//usw.
		
		
		
	}
	
	protected ArrayList<String> createStatusAnzeige(Spieler spieler){
		ArrayList<String> statusAnzeige = new ArrayList<String>();
		statusAnzeige.add( "╔══════════════════════════════╗" );
		statusAnzeige.add( "║         "+spieler.getTitel() +" "+spieler.getName() +"      ║" );
		//usw.
		return statusAnzeige;
	}
	
	public String addLeerzeichen(String string, int benoetigteLaenge){
		
		return "";
	}
	
	
	
}
