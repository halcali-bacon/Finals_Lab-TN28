package finals_lab.tn28;

import java.util.*;

public class Album {
    private String albumTitle;
    private int year;
    private final Queue<String> tracklist;
    
    Album (String albumTitle, int year) {
        this.albumTitle = albumTitle;
        this.year = year;
        
        tracklist = new ArrayDeque<>();
    }

    // GETTERS AND SETTERS
    
    public String getAlbumTitle() {
        return albumTitle;
    }

    public int getYear() {
        return year;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    // CUSTOM METHODS

    @Override
    public String toString() {
//        return "Album{" + "albumTitle=" + albumTitle + ", year=" + year + '}';
        return (albumTitle + " (" + year + ")");
    }
    
}
