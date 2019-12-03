import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
@SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.Vector<E> {
    java.util.Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!
    
    // The title of the playlist
    private String title;
    
    // Constructor
    public Playlist(String title) {
        // Set title to the title
    	this.title = title;
    }
    
    // Adds a song to the playlist
    // @param  {@code E}       The song to add to the playlist
    // @return {@code boolean} true if song was added succesfully
    public boolean addtoPlist(E song) {
        // Check if song is null
    	if(song == null)
    		return false;
        // Check if song is already in the playlist
    	if(this.contains(song))
    		return false;
    	
        // Add the song and return true
    	this.add(song);
    	return true;
    }
    
    // Removes a song to the playlist
    // @param  {@code E}       The song to remove from the playlist
    // @return {@code boolean} true if song was removed succesfully
    public boolean removeFromPlist(E song) {
        // Check if song is null
    	if(song == null)
    		return false;
        // Check if the song is in the playlist
    	if(!this.contains(song))
    		return false;
    	// Remove song from the playlist
    	this.remove(song);
    	return true;
    }
    

    // Getter method for title
    // @return {@code String}  The title of the playlist
    public String getTitle() {
    	return this.title;
    }
    
    // Getter method for song
    // @param  {@code int}     The number of the song in the playlist
    // @return {@code String}  The artist of the song
    public Song getSong(int index) {
    	return this.get(index);
    }
    
    // Checks if the title of the playlist is the title
    // @param  {@code String}   The title of the song
    // @return {@code boolean} true if title is the title
    public boolean hasTitle(String title) {
    	return this.title.equalsIgnoreCase(title);
    	
    }
    
    // Checks if the artist has a song in the playlist
    // @param  {@code String}  The artist to check for
    // @return {@code boolean} true if artist has a song in the playlist
    public boolean hasArtist(String artist) {
    	for(int i = 0; i < this.size(); i++) {
    		if(this.get(i).getArtist().equalsIgnoreCase(artist))
    			return true;
    	}
    	return false;
    }
    
    // Returns the number of song in the playlist
    // @return {@code int} The number of songs in the playlist
    public int numberOfSongs() {
    	return this.size();
    }
    
    // Calculates the total duration of the playlist
    // @return {@code double} The total play time of the playlist
    public double playTime () {
    	double playTime = 0;
    	for (E song : this)
    		playTime += song.getLength();
    	
    	return playTime;
    }
    
    // Find the index of a particular song
    // @param  {@code E}       The song to find in the playlist
    // @return {@code int} The index of the song in the playlist
    //                     returns -1 if not found
    public int findSong(E song) {
    	return this.indexOf(song);
    }
    
    // Finds the number of different artists in the playlist
    // @return {@code int} The number of artists in the playlist
    public int numberOfArtists() {
        // Create a hashset since it doens't allow duplicates
    	HashSet<String> uniqueArtists = new HashSet<String>();
        // Add all artist the the hashset, duplicates won't be added
    	for (E song : this)
    		uniqueArtists.add(song.getArtist());
        // Return the size of the HashSet
    	return uniqueArtists.size();
    }
    
    // Finds the number of different titles in the playlist
    // @return {@code int} The number of titles in the playlist   
    public int numberOfTitles() {
        // Create a hashset since it doens't allow duplicates
    	HashSet<String> uniqueTitles = new HashSet<String>();
        // Add all titles the the hashset, duplicates won't be added
    	for (E song : this)
    		uniqueTitles.add(song.getTitle());
        // Return the size of the HashSet
    	return uniqueTitles.size();
    }
    
    // Sorts the playlist by the name of the artist
    public void sortByArtist() {
    	Collections.sort(this, new Comparator<Song>() {
    		  @Override
    		  public int compare(Song song1, Song song2) {
    		    return song1.getArtist().compareTo(song2.getArtist());
    		  }
    		});
    }
    
    // Sorts the playlist by the title
    public void sortByTitle() {
    	Collections.sort(this, new Comparator<Song>() {
    		  @Override
    		  public int compare(Song song1, Song song2) {
    		    return song1.getTitle().compareTo(song2.getTitle());
    		  }
    	});
    	
    }
}
