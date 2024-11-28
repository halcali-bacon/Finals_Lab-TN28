package finals_lab.tn28;

import java.util.*;

public class Catalogue {
    ArrayDeque<Artist> catalogue;
    
    // CONSTRUCTORS
    
    // This is the constructor for Catalogues that were retrieved from previous sessions
    Catalogue(Collection<Artist> catalogue) {
        this.catalogue = new ArrayDeque<>(catalogue);
    }
    
    // This is the constructor for Catalogues created at runtime
    Catalogue() {
        catalogue = new ArrayDeque<>();
    }
    
    // SETTERS AND GETTERS
    
    public void setCatalogue(Collection<Artist> c){
        this.catalogue = new ArrayDeque<>(c);
    }
    
    public ArrayDeque<Artist> getCatalogue() {
        return this.catalogue;
    }
    
    // CUSTOM METHODS
    
    public boolean isArtistHere(String name) {
        TreeSet<String> temp = new TreeSet<>();
        for(Artist a : this.catalogue) {
            temp.add(a.getName());
        }
        for(String a : temp) {
            if(a.equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void addArtist(Artist artist) {
        this.catalogue.add(artist);
    }
    
    public void removeArtist(String name) {
        Iterator<Artist> itr = this.catalogue.iterator();
        while(itr.hasNext()) {
            Artist a = itr.next();
            if(a.getName().equals(name)) {
                itr.remove();
            }
        }
    }
    
   /*
    * This method adds the names of the artist in our catalogue into a temporary tree set
    * All of the elements in temp are printed, vomits out a sorted list of the names of the artists
    *
    * (Note: Probably may better solution... Nitry ko gawing tree set yung catalogue kaso nagcoconflict siya sa ibang code)
    */
    public void displayArtists() {
        TreeSet<String> temp = new TreeSet<>();
        for(Artist a : this.catalogue) {
            temp.add(a.getName());
        }
        for(String a : temp) {
            System.out.println(a);
        }
        temp.clear();
    }
    
    public boolean isAlbumHere(Artist artist, String album) {
        TreeSet<String> temp = new TreeSet<>();
        for(Album a : artist.getDiscography()) {
            temp.add(a.getTitle());
        }
        for(String a : temp) {
            if(a.equals(album)) {
                return true;
            }
        }
//        artist.getDiscography()
        return false;
    }
    
    public void addAlbum(String artist, String album, int year) {
        // early exit if artist is not on the catalogue
        if(!isArtistHere(artist)) {
            System.out.println("Artist is not on catalogue.");
            return;
        }
        // Retrieve a reference of the artist from the catalogue
        
        // Early exit if album is already on catalogue
        if(!isAlbumHere(a, album)) {
            System.out.println("Album is already on the discography.");
            return;
        }
        // Add Album
        a.addAlbum(new Album(album, year));
    }
    
    public void removeAlbum(String artist, String album) {
        
    }
    
    public void displayAlbums() {
        
    }
    
    
}
