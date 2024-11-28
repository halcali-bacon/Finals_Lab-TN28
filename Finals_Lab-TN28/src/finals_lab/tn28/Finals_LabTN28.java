package finals_lab.tn28;

import java.util.*;
import java.io.*;

public class Finals_LabTN28 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);    
        MusicCatalogueSystem mcs = new MusicCatalogueSystem(reader);
        
//        mcs.addArtist("Neutral Milk Hotel");
//        mcs.addArtist("ASIAN KUNG-FU GENERATION");
//        mcs.addArtist("Weezer");
//        
//        mcs.displayArtists();
//        
//        mcs.addAlbum("Car Seat Headrest", "Twin Fantasy", 2018);
//        mcs.addAlbum("Fiona Apple", "Tidal", 1996);
//        mcs.addAlbum("Fiona Apple", "When The Pawn...", 1999);
//        mcs.addAlbum("Fiona Apple", "Fetch The Bolt Cutters", 2020);
        
        mcs.displayArtists();
        System.out.println("");
        mcs.displayAlbums();
        
        mcs.closeSystem();
        
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("Artists.txt"));
//            String line;
//            while((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//            br.close();
//        } catch (IOException ioe) {
//            System.out.println("Error, buddy.");
//        }
    }
    
    private static class MusicCatalogueSystem implements Catalogueable {
        Catalogue myCatalogue;
        Scanner reader;
        
        // CONSTRUCTORS
        
        MusicCatalogueSystem(Scanner reader) {
            this.reader = reader;
            myCatalogue = new Catalogue();
            setupSystem();
        }
        
        // IMPLEMENTED METHODS

        @Override
        public boolean isArtistHere(String name) {
            return myCatalogue.isArtistHere(name);
        }

        @Override
        public void addArtist(String name) {
            myCatalogue.addArtist(name);
        }

        @Override
        public void removeArtist(String name) {
            myCatalogue.removeArtist(name);
        }

        @Override
        public void displayArtists() {
            myCatalogue.displayArtists();
        }

        @Override
        public boolean isAlbumHere(String artist, String title) {
            return myCatalogue.isAlbumHere(artist, title);
        }

        @Override
        public void addAlbum(String name, String title, int year) {
            myCatalogue.addAlbum(name, title, year);
        }

        @Override
        public void removeAlbum(String name, String title) {
            myCatalogue.removeAlbum(name, title);
        }

        @Override
        public void displayAlbums() {
            myCatalogue.displayAlbums();
        }
        
        // CUSTOM METHODS
        
        public void setupSystem() {
            // Read the contents of a .txt file and place it into the Artist catalogue
            readArtistFile("Artist Catalogue");
            // Read the contents of the .txt files of the respective artists and store them into their discography
            
            // Adds all the artists to a temporary queue
            Queue<Artist> alltists = new ArrayDeque<>();
            for(Artist a : myCatalogue.catalogue) {
                alltists.add(a);
            }
            // Writes all the albums in a discography of an artist on a .txt file with filename the same as the name of the artist.
            for(Artist a : alltists) {
                readAlbumFile(a, a.getName());
            }
        }
        
        public void closeSystem() {
            // Write contents of Artist catalogue to a .txt file
            writeArtistFile("Artist Catalogue");
            
            // Write to a separate .txt file per artist the contents of their discography
            
            // Adds all the artists to a temporary queue
            Queue<Artist> alltists = new ArrayDeque<>();
            for(Artist a : myCatalogue.catalogue) {
                alltists.add(a);
            }
            // Writes all the albums in a discography of an artist on a .txt file with filename the same as the name of the artist.
            for(Artist a : alltists) {
                writeAlbumFile(a, a.getName());
            }
        }
        
        public void readArtistFile(String filename) {
            filename += ".txt";
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String line;
                while((line = br.readLine()) != null) {
                    myCatalogue.catalogue.add(new Artist(line));
                }
                br.close();
            } catch (IOException ioe) {
                System.out.println("Error, buddy.");
            }
        }
        
        public void writeArtistFile(String filename) {
            filename += ".txt";
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
                for(Artist a : myCatalogue.catalogue) {
                    bw.write(a.getName() + "\n");
                }
                bw.close();
            } catch (IOException ioe) {
                System.out.println("Error, buddy.");
            }
        }
        
        public void readAlbumFile(Artist artist, String filename) {
            filename += ".txt";
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String line;
                while((line = br.readLine()) != null) {
//                    myCatalogue.catalogue.add(new Artist(line));
                    String title = line;
                    int year = Integer.parseInt(br.readLine());
                    artist.addAlbum(new Album(title, year));
                    
                }
                br.close();
                /*
                for(Album a : artist.getDiscography()) {
                    bw.write(a.getTitle() + "\n");
                    bw.write(a.getYear() + "\n");
                }
                bw.close();
                */
            } catch (IOException ioe) {
                System.out.println("Error, buddy.");
            }
        }
        
        public void writeAlbumFile(Artist artist, String filename) {
            // Early return if artist is not on the catalogue
            if(!isArtistHere(artist.getName())) {
                return;
            }
            filename += ".txt";
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
                for(Album a : artist.getDiscography()) {
                    bw.write(a.getTitle() + "\n");
                    bw.write(a.getYear() + "\n");
                }
                bw.close();
            } catch (IOException ioe) {
                System.out.println("Error, buddy.");
            }
        }
    }
}