package finals_lab.tn28;

import java.util.*;

public class Album implements Catalogueable {
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
    public void displayList() {
        Queue<String> temp = this.tracklist;
        while (temp.peek() != null) {
            System.out.println(temp.poll() + "\n");
        }
    }
    
    @Override
    public void addToLibrary() {
        
    }
    
    @Override
    public void removeFromLibrary() {
        
    }
}
