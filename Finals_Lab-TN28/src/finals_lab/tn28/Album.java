package finals_lab.tn28;

import java.util.*;

public class Album {
    private String title;
    private int year;
    private Queue<String> tracklist;
    
    // CONSTRUCTORS
    
    // This constructor is for Albums that are copied from previous sessions
    Album(String title, int year, Queue<String> tracklist) {
        this.title = title;
        this.year = year;
        this.tracklist = tracklist;
    }
    
    // This constructor is for Albums that are added during runtime
    Album(String title, int year) {
        this.title = title;
        this.year = year;
        tracklist = new ArrayDeque<>();
    }
    
    // SETTERS AND GETTERS
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setTracklist(Queue<String> tracklist) {
        this.tracklist = new ArrayDeque<>(tracklist);
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public Queue<String> getTracklist() {
        return this.tracklist;
    }
    
    // CUSTOM METHODS
    
    // This prints the whole tracklist into the *console
    public void displayTracklist() {
        for (String t : this.tracklist) {
            System.out.println(t); // may be modified to print t into a .txt file
        }
    }
    
    // This adds a track into the tracklist
    public void addTrack(String track) {
        this.tracklist.add(track);
    }
    
    // This remove a track from the tracklist if it finds a match.
    // Using iterators over for each is important here so that we can remove from the list.
    public void removeTrack(String track) {
        Iterator<String> itr = this.tracklist.iterator();
        while(itr.hasNext()) {
            String t = itr.next();
            if(t.equals(track)) {
                itr.remove();
            }
        }
    }
}
