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

public class Ausgabe {

	private View				currentView;
	private Map<String, View>	views		= new HashMap<>();
	private ArrayList<Integer>	viewHistory	= new ArrayList<>();


	public Map<String, String> show( String viewString, int viewIndex, Spieler spieler ) {
		View view = views.get( viewString );

		//falls die "�bergebene" View ungleich der letzten View ist oder wenn sie gleich ist und zus�tzlich der viewIndex 1 �bergeben wurde, 
		//muss die viewHistory gel�scht werden und currentView gesetzt werden
		if ( ( view == currentView && viewIndex == 1 ) || ( view != currentView ) ) {
			this.currentView = view;
			viewHistory.clear();
		}

		//Pr�fung, ob per ESC die vorherige View aufgerufen werden soll. Dann muss der letzte Eintrag der History entfernt werden,
		//ansonsten wird der akutelle viewIndex hinzugef�gt.
		//ggf. Fehlerscreeens nicht mit eintragen
		try {
			if ( viewHistory.get( viewHistory.size() - 2 ) == viewIndex ) {
				viewHistory.remove( viewHistory.size() - 1 );
			}else{
				viewHistory.add( viewIndex );
			}
		} catch ( IndexOutOfBoundsException e ) {
			viewHistory.add( viewIndex );
			
		}

		view.setSpieler( spieler );
		view.setViewIndex( viewIndex );
		ArrayList<String> ausgabe = view.getScreen();
		// Ausgabemethode fehlt noch
		for ( String s : ausgabe ) {
			System.out.println( s );
		}
		return view.getKeys();

	}
	
	public Map<String, String> showPreviousView() throws IndexOutOfBoundsException{
		String viewString = currentView.getClass().getName();
		
		int viewIndex = viewHistory.get( viewHistory.size() - 2 );
			
		
		return show( viewString, viewIndex, currentView.getSpieler() );
	}

	public View currentView() {
		return currentView;
	}

	public int getLastViewIndex() {
		// den vorherigen Index zur�ckgeben
		//try catch f�r IndexOutOfBounds fehlt noch
		return viewHistory.get( viewHistory.size() - 2 );
	}

	
}
