package finals_lab.tn28;

public interface Catalogueable {
    
    //For Artists
    boolean isArtistHere(String name);
    void addArtist(String name);
    void removeArtist(String name);
    void displayArtists();
    
    // For Albums
    boolean isAlbumHere(String artist, String title);
    void addAlbum(String name, String title, int year);
    void removeAlbum(String name, String title);
    void displayAlbums();
    
    
}
