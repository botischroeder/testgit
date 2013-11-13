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




public class MarktplatzView extends SpielView{
	
	
	public MarktplatzView(Spiel spiel) {
		super(spiel);
		generateKeys();
		generateScreens();
	}
	

	@Override
	public void generateKeys() {
		
		addKeys(0, new HashMap<String, String>(){{put( "K", "KAUFEN"); put( "V", "VERKAUFEN");}});
		addKeys(1, new HashMap<String, String>(){{put( "K", "KORN_KAUFEN"); put( "F", "FELD_KAUFEN");}});
		
	}
	

	@Override
	public void generateScreens() {

		addScreen(0, createMenuePunktAnsicht(new ArrayList<>( Arrays.asList( "(K)aufen oder (v)erkaufen", "(K)aufen oder (s)aufen   " ) ), "Soll gekauft oder verkauft werden?", 14, 40) );	
		addScreen(1, createMenuePunktAnsicht(new ArrayList<>( Arrays.asList( "(K)orn      ", "(M)ehl      ", "(D)ünger    ", "(S)oldaten  ", "(L)ändereien" ) ), "Soll gekauft oder verkauft werden?", 14, 27) );
	}
	
}
