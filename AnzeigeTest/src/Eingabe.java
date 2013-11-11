import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Eingabe {
	private Spieler				spieler;
	private Ausgabe				ausgabe;
	private String				eingabe;
	private Map<String, String>	validKeys	= new HashMap<>();

	public Eingabe() {
		super();
		spieler = new Spieler( "Herzog", "Andreas" );
		ausgabe = new Ausgabe();
		// ausgabe.getViews().put( "Marktplatz", MarktplatzView.getInstance() );

	}

	public void test() {
		ausgabe.show( "Marktplatz", 1, spieler );
		loopRunde();
		// ausgabe.setView( ausgabe.getViews().get( "Marktplatz" ) );
		// ausgabe.getView().setViewIndex( 1 );
		// validKeys = ausgabe.show( spieler );
		// analyzeEingabe();
		// for ( String s : ausgabe.showMarktplatz( spieler, 1 ).values() ) {
		// System.out.println( s );
		// }
		// System.out.println();
		// Map<String, String> map = ausgabe.showMarktplatz( spieler, 2 );
		// System.out.println( map );

	}

	private void loopRunde() {
		boolean stop = false;
		String eingabeAusUntererEbene = null;
		do {
			if ( eingabeAusUntererEbene != null ) {
				eingabe = eingabeAusUntererEbene;
				eingabeAusUntererEbene = null;
			} else {
				eingabe = getEingabe();
			}
			// Ignore Case fehlt noch
			if ( validKeys.keySet().contains( eingabe ) ) {
				switch ( validKeys.get( eingabe ) ) {
					case "MARKTPLATZ_KAUFEN":
						
						ausgabe.show( "Marktplatz", 2, spieler );
						
						boolean innerStop = false;
						do {
							eingabe = getEingabe();

							if ( !stringToInt( eingabe ) || !kaufekorn() ) {

								// falls F-Taste anstatt erwarteter Zahl
								if ( validKeys.keySet().contains( eingabe ) ) {
									eingabeAusUntererEbene = validKeys.get( eingabe );
									innerStop = true;
								}
								ausgabe.show( "Marktplatz", 4, spieler );
							}else{
								innerStop = true;
							}

						} while ( !innerStop );
						ausgabe.show( "Marktplatz", 1, spieler );
						break;
					case "MARKTPLATZ_KAUFEN_ERROR":

					case "MARKTPLATZ_KAUFEN_KORN":
						// ausgabe.setView( ausgabe.getViews().get( "Marktplatz" ) );
						// ausgabe.getView().setViewIndex( 3 );
						// ausgabe.show( spieler );
						eingabe = getEingabe();

						break;

					
					
					case "ESC":
						try {
							ausgabe.showPreviousView();
						} catch ( IndexOutOfBoundsException e ) {
						}
						break;

					default:

				}
			} else {
				System.out.println( "Ungültige Eingabe" );
				// ausgabe.show( spieler );
			}
		} while ( !stop );

	}

	private String getEingabe() {
		String line = null;
		BufferedReader bufferedReader;
		InputStreamReader inputStreamReader;

		inputStreamReader = new InputStreamReader( System.in );
		bufferedReader = new BufferedReader( inputStreamReader );

		try {
			line = bufferedReader.readLine();
		} catch ( IOException e ) {

		}

		return line;
	}
}
