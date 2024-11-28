package finals_lab.tn28;

import java.util.*;

public class Catalogue implements Catalogueable {
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
    
    @Override
    public void addArtist(String name) {
        // Early exit if artist is in catalogue
        if(isArtistHere(name)) {
            System.out.println("Artist is already on catalogue.");
            return;
        }
        this.catalogue.add(new Artist(name));
        System.out.println("Artist successfully added.");
    }
    
    @Override
    public void removeArtist(String name) {
        if(!isArtistHere(name)) {
            System.out.println("Artist is not in the catalogue.");
            return;
        }
        Iterator<Artist> itr = this.catalogue.iterator();
        while(itr.hasNext()) {
            Artist a = itr.next();
            if(a.getName().equals(name)) {
                itr.remove();
                System.out.println("Artist successfully removed.");
                break;
            }
        }
    }
    
   /*
    * This method adds the names of the artist in our catalogue into a temporary tree set
    * All of the elements in temp are printed, vomits out a sorted list of the names of the artists
    *
    * (Note: Probably may better solution... Nitry ko gawing tree set yung catalogue kaso nagcoconflict siya sa ibang code)
    */
    @Override
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
    
    @Override
    public boolean isAlbumHere(String artist, String album) {
        // Early exit if artist is not on the catalogue
        if(!isArtistHere(artist)) {
            System.out.println("Artist is not even on the catalogue.");
            return false;
        }
        // Retrieve a reference of the artist from the catalogue
        Artist found = null;
        for (Artist a : this.catalogue) {
            if(a.getName().equals(artist)) {
                found = a;
                break;
            }
        }
        if (found == null) {
            return false;
        }
        TreeSet<String> temp = new TreeSet<>();
        for(Album a : found.getDiscography()) {
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
    
    @Override
    public void addAlbum(String artist, String album, int year) {
        // early exit if artist is not on the catalogue
        if(!isArtistHere(artist)) {
            System.out.println("Artist is not on catalogue.");
            return;
        }
        // Retrieve a reference of the artist from the catalogue
        Artist found = null;
        Iterator<Artist> itr = this.catalogue.iterator();
        while(itr.hasNext()) {
            Artist a = itr.next();
            if(a.getName().equals(artist)) {
                found = a;
                break;
            }
        }
        // IDK PATCHWORK CODE
        if (found == null) {
            return;
        }
        // Early exit if album is already on catalogue
        if(isAlbumHere(found.getName(), album)) {
            System.out.println("Album is already on the discography.");
            return;
        }
        // Add Album
        found.addAlbum(new Album(album, year));
        
    }
    
    @Override
    public void removeAlbum(String artist, String album) {
        // early exit if artist is not on the catalogue
        if(!isArtistHere(artist)) {
            System.out.println("Artist is not on catalogue.");
            return;
        }
        // Retrieve a reference of the artist from the catalogue
        Artist found = null;
        Iterator<Artist> itr = this.catalogue.iterator();
        while(itr.hasNext()) {
            Artist a = itr.next();
            if(a.getName().equals(artist)) {
                found = a;
                break;
            }
        }
        // IDK PATCHWORK CODE
        if (found == null) {
            return;
        }
        // Early exit if album is already on catalogue
        if(!isAlbumHere(found.getName(), album)) {
            System.out.println("Album is not on the discography.");
            return;
        }
        found.removeAlbum(album);
    }
    
   /*
    *   May mas maayos na method for sure, pero mababaliw na ko...
    */
    @Override
    public void displayAlbums() {
        // Adds all the artists to a temporary queue
        Queue<Artist> alltists = new ArrayDeque<>();
        for(Artist a : this.catalogue) {
            alltists.add(a);
        }
        // Adds all the albums of all those artists to a temporary queue
        Queue<Album> allbums = new ArrayDeque<>();
        for(Artist a : alltists) {
            for(Album b : a.getDiscography()) {
                allbums.add(b);
            }
        }
        // Adds album title and year to a temporary TreeSet<String> to display it in alphabetical order
        TreeSet<String> temp = new TreeSet<>();
        for(Album a : allbums) {
            temp.add(a.getTitle() + " (" + a.getYear() + ")");
        }
        for(String a : temp) {
            System.out.println(a);
        }
    }
    
    
}
