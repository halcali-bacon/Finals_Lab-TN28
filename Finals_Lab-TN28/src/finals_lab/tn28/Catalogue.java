package finals_lab.tn28;

import java.util.*;

public class Catalogue implements Catalogueable {
    Scanner reader;
    // These lists are for the catalogue
    Queue<Artist> artistCatalogue;
    Queue<Album> albumCatalogue;
        
    Catalogue (Scanner reader) {
        this.reader = reader;
        // Initializes the list for the catalogue
        albumCatalogue = new PriorityQueue<>();
        artistCatalogue = new PriorityQueue<>();
    }
    
    public boolean isArtistOnList(String name) {
        boolean found = false;
        
        for (Artist a : artistCatalogue) {
            if(a.getArtistName().equals(name)) {
                found = true;
            }
        }
        
        return found;
    }
    
    @Override
    public void addArtist() {
        System.out.print("Enter artist name: ");
        String artistName = reader.nextLine();
        if(isArtistOnList(artistName)) {
            System.out.println("Artist already on list.");
        }
        else {
            System.out.println("Adding new artist...");
            artistCatalogue.offer(new Artist(artistName));
        }
    }
    
    @Override
    public void removeArtist() {
        System.out.println("Enter artist name: ");
        String artistName = reader.nextLine();
        if(isArtistOnList(artistName)) {
            System.out.print("Are you sure you want to remove that artist? {Yes or No): ");
            String choice = reader.nextLine();
            if (choice.equals("Yes") || choice.equals("yes")) {
                for (Artist a : artistCatalogue) {
                    if (a.getArtistName().equals(artistName)) {
                        artistCatalogue.remove(a);
                    }
                }
                System.out.println("Artist successfully removed.");
            }
            else if (choice.equals("No") || choice.equals("no")) {
                System.out.println("Artist not removed.");
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }
    
    @Override
    public void displayArtists() {
        Queue<Artist> temp = artistCatalogue;
        
        System.out.println("Artist Catalogue: ");
        while(temp.peek() != null) {
            System.out.println(temp.poll());
        }
    }
    
    @Override
    public void addAlbum() {
        System.out.print("Enter artist name:");
        String artistName = reader.nextLine();
        
        if(isArtistOnList(artistName)) {
            Queue<Artist> temp = artistCatalogue;
            Artist curr;
            while (!temp.peek().getArtistName().equals(artistName)) {
                curr = temp.peek();
            }
            // and di ko pa tapos...
        }
        
    }
}
