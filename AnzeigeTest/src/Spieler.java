
public class Spieler {
	
	private String titel;
	private String name;
	private final String vorname;
	
	public Spieler( String _titel, String _name ) {
		super();
		titel = _titel;
		name = _name;
		vorname = "";
	}

	public String getTitel() {
		return titel;
	}

	public String getName() {
		return name;
	}
	
	
	
}
