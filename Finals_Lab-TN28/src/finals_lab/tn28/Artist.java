package finals_lab.tn28;

import java.util.*;

public class Artist {
    private String name;
    private Queue<Album> discography;
    
    // CONSTRUCTOR
    
    // This constructor is for Artists that are copied from previous sessions
    Artist(String name, Queue<Album> discography) {
        this.name = name;
        this.discography = new ArrayDeque<>(discography);
    }
    
    // This constructor is for Artists that are added during runtime.
    Artist(String name) {
        this.name = name;
        discography = new ArrayDeque<>();
    }
    
    // SETTERS AND GETTERS
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDiscography(Queue<Album> discography) {
        this.discography = new ArrayDeque<>(discography);
    }
    
    public String getName() {
        return this.name;
    }
    
    public Queue<Album> getDiscography() {
        return this.discography;
    }
    
    // CUSTOM METHODS
    
    // This prints the titles of all the albums in the discography
    public void displayDiscography() {
        for(Album a : this.discography) {
            System.out.println(a.getTitle() + "(" + a.getYear() + ")");
        }
    }
    public void addAlbum(Album album) {
        this.discography.add(album);
    }
    
    public void removeAlbum(String title) {
        Iterator<Album> itr = this.discography.iterator();
        while(itr.hasNext()) {
            Album a = itr.next();
            if(a.getTitle().equals(title)) {
                itr.remove();
            }
        }
    }
}
