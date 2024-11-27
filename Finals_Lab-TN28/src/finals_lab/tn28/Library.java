package finals_lab.tn28;

import java.util.*;

public class Library implements Catalogueable {
    // These lists are for the user library
    Queue<Album> myAlbums;
    Queue<Artist> myArtists;
    String username;
    
    Library () {
        this.username = "User";
        
        // Initializes the lists for the user library
        myAlbums = new PriorityQueue<>();
        myArtists = new PriorityQueue<>();
    }
    
    public boolean isArtistOnList(String name) {
        boolean found = false;
        
        for (Artist a : myArtists) {
            if(a.getArtistName().equals(name)) {
                found = true;
            }
        }
        
        return found;
        }
}
