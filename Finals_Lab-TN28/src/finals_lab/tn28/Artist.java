package finals_lab.tn28;
import java.util.*;

public class Artist {
    private String artistName;
    private final List<Album> discography;
    
    Artist (String artistName) {
        this.artistName = artistName;
        discography = new ArrayList<>();
    }

    // GETTERS AND SETTERS
    
    public String getArtistName () {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    
    // CUSTOM METHODS

    @Override
    public String toString() {
//        return "Artist{" + "artistName=" + artistName + ", discography=" + discography + '}';
        return (artistName + " (" + discography.size() + " Albums)");
    }
    
}
