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
    
    private String title;
    
    public Playlist(String title) {
    	this.title = title;
    }
    
    public boolean addtoPlist(E song) {
    	if(song == null)
    		return false;
    	if(this.contains(song))
    		return false;
    	
    	this.add(song);
    	return true;
    }
    
    public boolean removeFromPlist(E song) {
    	if(song == null)
    		return false;
    	if(!this.contains(song))
    		return false;
    	
    	this.remove(song);
    	return true;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public Song getSong(int index) {
    	return this.get(index);
    }
    
    public boolean hasTitle(String title) {
    	return this.title.equalsIgnoreCase(title);
    	
    }
    
    public boolean hasArtist(String artist) {
    	for(int i = 0; i < this.size(); i++) {
    		if(this.get(i).getArtist().equalsIgnoreCase(artist))
    			return true;
    	}
    	return false;
    }
    
    public int numberOfSongs() {
    	return this.size();
    }
    
    public double playTime () {
    	double playTime = 0;
    	for (E song : this)
    		playTime += song.getLength();
    	
    	return playTime;
    }
    
    public int findSong(E song) {
    	return this.indexOf(song);
    }
    
    public int numberOfArtists() {
    	HashSet<String> uniqueArtists = new HashSet<String>();
    	for (E song : this)
    		uniqueArtists.add(song.getArtist());
    	return uniqueArtists.size();
    }
    
    public int numberOfTitles() {
    	HashSet<String> uniqueTitles = new HashSet<String>();
    	for (E song : this)
    		uniqueTitles.add(song.getTitle());
    	return uniqueTitles.size();
    }
    
    public void sortByArtist() {
    	Collections.sort(this, new Comparator<Song>() {
    		  @Override
    		  public int compare(Song song1, Song song2) {
    		    return song1.getArtist().compareTo(song2.getArtist());
    		  }
    		});
    }
    
    public void sortByTitle() {
    	Collections.sort(this, new Comparator<Song>() {
    		  @Override
    		  public int compare(Song song1, Song song2) {
    		    return song1.getTitle().compareTo(song2.getTitle());
    		  }
    	});
    	
    }
}
