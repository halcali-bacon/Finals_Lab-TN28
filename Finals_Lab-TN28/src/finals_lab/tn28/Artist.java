package finals_lab.tn28;
import java.util.*;

public class Artist implements Catalogueable{
    private String artistName;
    private final Queue<Album> discography;
    
    Artist (String artistName) {
        this.artistName = artistName;
        discography = new PriorityQueue<>();
    }

    // GETTERS AND SETTERS
    
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
    // CUSTOM METHODS
    
    @Override
    public void displayList () {
        Queue<Album> temp = this.discography;
        while (temp.peek() != null) {
            System.out.println(temp.poll());
        }
    }
    
    @Override
    public void addToLibrary() {
        
    }
    
    @Override
    public void removeFromLibrary() {
        
    }
}
