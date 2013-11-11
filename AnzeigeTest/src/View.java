import java.util.ArrayList;
import java.util.Map;


public abstract class View {
	protected int viewIndex;
	public abstract Map<String, String> getKeys();
	public abstract ArrayList<String> getScreen();
	public abstract void setViewIndex(int viewIndex);
	public abstract void setSpieler( Spieler spieler );
	public abstract Spieler getSpieler();
	
}
