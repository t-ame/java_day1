package assignments;

public class Voter {
	private int id;
	private boolean isPresident = false;
	private boolean inFavour =false;
	
	
	public Voter(int id, boolean president) {
		super();
		this.id = id;
		this.isPresident = president;
//		this.inFavour = inFavour;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isPresident() {
		return isPresident;
	}
	public void setPresident(boolean isPresident) {
		this.isPresident = isPresident;
	}
	
	public boolean isInFavour() {
		return inFavour;
	}
	
	public void setInFavour(boolean inFavour) {
		this.inFavour = inFavour;
	}
	
}
