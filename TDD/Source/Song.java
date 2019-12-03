/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 */
public class Song {
    // Song variables
	private double length;
	private String title;
	private String artist;
	
	// Constructor
	public Song (String artist, String title, double length) {
		// Set each parameter to its respective variable
		this.length = length;
		this.artist = artist;
		this.title = title;
	}
	
	// 2nd Constructor when a float is passed in instead of a double
	// for length of the song
	public Song (String artist, String title, float length) {
		// Set each parameter to its respective variable
		this.length = (double) length;
		this.artist = artist;
		this.title = title;
	}
	
	// Getter method for artist
	// @return {@code String}  The artist of the song
	public String getArtist() {
		return this.artist;
	}
	
	// Getter method for length
	// @return {@code double}  The duration of the song
	public double getLength() {
		return this.length;
	}
	
	// Getter method for title
	// @return {@code String}  The title of the song
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
	    // Check if every attribute is the same ignoring case
	    return getTitle().toLowerCase().equals(song.getTitle().toLowerCase()) &&
	    		getArtist().toLowerCase().equals(song.getArtist().toLowerCase()) &&
	    		getLength() == song.getLength();
	}
	
	// Checks if artist is the artist of the song
	// @param  {@code String}  The name to check against artist of the song
	// @return {@code boolean} true if artist is the artist
	public boolean isArtist(String artist) {
		return getArtist().toLowerCase().equals(artist.toLowerCase());
	}
	
	// Checks if title is the title of the song
	// @param  {@code String}  The title to check against title of the song
	// @return {@code boolean} true if title is the title
	public boolean isTitle(String title) {
		return getTitle().toLowerCase().equals(title.toLowerCase());
	}
	
	
}
