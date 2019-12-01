/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 */
public class Song {
    // TODO: Assignment 6 -- complete this Song class to pass the tests
	private double length;
	private String title;
	private String artist;
	
	public Song (String artist, String title, double length) {
		this.length = length;
		this.artist = artist;
		this.title = title;
	}
	
	public Song (String artist, String title, float length) {
		this.length = (double) length;
		this.artist = artist;
		this.title = title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public boolean equals(Object obj) {
		// First check if the object is itself
	    if (obj == this)
	      return true;
	  	// Check if obj is an instance of Song
	    if (!(obj instanceof Song)) {
	        return false;
	    }
	    // Assign obj as a Song
	    Song song = (Song) obj;
	    // Check if every attribute is the same
	    return getTitle().toLowerCase().equals(song.getTitle().toLowerCase()) &&
	    		getArtist().toLowerCase().equals(song.getArtist().toLowerCase()) &&
	    		getLength() == song.getLength();
	    		

	}
	
	public boolean isArtist(String artist) {
		return getArtist().toLowerCase().equals(artist.toLowerCase());
	}
	
	public boolean isTitle(String title) {
		return getTitle().toLowerCase().equals(title.toLowerCase());
	}
	
	
}
