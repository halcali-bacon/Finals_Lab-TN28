package finals_lab.tn28;

import java.util.*;

public class Finals_LabTN28 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MusicCatalogueSystem mcs = new MusicCatalogueSystem(reader);
        
        int main_opt;
        do {
            System.out.println("[1] - Catalogue");
            System.out.println("[2] - My Library");
            System.out.println("[3] - Exit");
            main_opt = Integer.parseInt(reader.nextLine());
            switch (main_opt) {
                case 1:
                    mcs.catalogueLoop();
                    break;
                case 2:
                    mcs.libraryLoop();
                    break;
                case 3:
                    // [3] - Exit
                    // Run code to print the catalogue to a text file
                    // Run code to print the user's library to a text file
                    break;
                default:
                    System.out.println("Invalid input.");
            }
            
        } while (main_opt != 3);
    }
    
    private static class MusicCatalogueSystem {
        Scanner reader;
        
        // These lists are for the catalogue
        Queue<Album> albumCatalogue;
        Queue<Artist> artistCatalogue;

        // These lists are for the user library
        Queue<Album> myAlbums;
        Queue<Artist> myArtists;
        String username;

        MusicCatalogueSystem(Scanner reader) {
            this.reader = reader;
            // Initializes the list for the catalogue
            albumCatalogue = new PriorityQueue<>();
            artistCatalogue = new PriorityQueue<>();
            
            // Initializes the lists for the user library
            myAlbums = new PriorityQueue<>();
            myArtists = new PriorityQueue<>();
            
            mcsSetup();
        }
        
        public final void mcsSetup () {
            // read catalogue txt file
            // read library txt file
        }
        
        // CATALOGUE FUNCTIONS
        // [1] - Catalogue
            // [1] - View catalogue
                // [1] - View artist catalogue
                // [2] - View album catalogue
                // [3] - Back
            // [2] - Add to catalogue
                // [1] - Add new artist to catalogue
                // [2] - Add new album to catalogue
                // [3] - Back
            // [3] - Remove from catalogue
                // [1] - Remove an artist (and all associated albums)
                // [2] - Remove an album
                // [3] - Back
                        // [4] - Back
        public void catalogueLoop() {
            int opt;
            
            do {
                System.out.println("[1] - View Catalogue");
                System.out.println("[2] - Add to Catalogue");
                System.out.println("[3] - Remove from Catalogue");
                System.out.println("[4] - Back");
                opt = Integer.parseInt(reader.nextLine());
                
                switch (opt) {
                    case 1:
                        viewLoop_C();
                        break;
                    case 2:
                        // Add
                        addLoop_C();
                        break;
                    case 3:
                        // Remove
                        removeLoop_C();
                        break;
                    case 4:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 4);
        }
        
        public void viewLoop_C() {
            int opt;
            
            do {
                System.out.println("[1] - View artist catalogue");
                System.out.println("[2] - View album catalogue");
                System.out.println("[3] - Back");
                opt = Integer.parseInt(reader.nextLine());
                
                switch (opt) {
                    case 1:
                        viewArtist_C();
                        break;
                    case 2:
                        viewAlbum_C();
                        break;
                    case 3:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 3);
        }
        
        public void viewArtist_C () {
            System.out.println("In viewArtist_C()");
        }
        
        public void viewAlbum_C () {
            System.out.println("In viewAlbum_C()");
        }
        
        public void addLoop_C() {
            int opt;
            
            do {
                System.out.println("[1] - Add new artist to catalogue");
                System.out.println("[2] - Add new album to catalogue");
                System.out.println("[3] - Back");
                opt = Integer.parseInt(reader.nextLine());
                
                switch (opt) {
                    case 1:
                        addArtist_C();
                        break;
                    case 2:
                        addAlbum_C();
                        break;
                    case 3:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 3);
        }
        
        public void addArtist_C () {
            System.out.println("In addArtist_C()");
        }

        public void addAlbum_C () {
            System.out.println("In addAlbum_C()");
        }
        
        public void removeLoop_C() {
            int opt;
            
            do {
                System.out.println("[1] - Remove an artist (and all associated albums)");
                System.out.println("[2] - Remove an album");
                System.out.println("[3] - Back");
                opt = Integer.parseInt(reader.nextLine());
                
                switch (opt) {
                    case 1:
                        removeArtist_C();
                        break;
                    case 2:
                        removeAlbum_C();
                        break;
                    case 3:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 3);
        }
        
        public void removeArtist_C () {
            System.out.println("In removeArtist_C()");
        }
        
        public void removeAlbum_C () {
            System.out.println("In removeAlbum_C()");
        }
        
        // LIBRARY FUCNTIONS
        // [2] - My Library
            // [1] - Artists
                // [1] - View my artist list
                // [2] - Add new artist
                // [3] - Remove artist from library
                // [4] - Back
            // [2] - Albums
                // [1] - View my album list
                // [2] - Add new album
                // [3] - Remove album from library
                // [4] - Back
            // [3] - Back
        public void libraryLoop() {
            int opt;
            
            do {    
                System.out.println("[1] - Artists");
                System.out.println("[2] - Albums");
                System.out.println("[3] - Back");
                opt = Integer.parseInt(reader.nextLine());
                switch (opt) {
                    case 1:
                        // Artist
                        artistLoop_L();
                        break;
                    case 2:
                        // Album
                        albumLoop_L();
                        break;
                    case 3:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 4);
        }
        
        public void artistLoop_L() {
            int opt;
            
            do {
                System.out.println("[1] - View My Artist List");
                System.out.println("[2] - Add Artist to My List");
                System.out.println("[3] - Remove Artist from My List");
                System.out.println("[4] - Back");
                opt = Integer.parseInt(reader.nextLine());
                
                switch (opt) {
                    case 1:
                        viewArtist_L();
                        break;
                    case 2:
                        addArtist_L();
                        break;
                    case 3:
                        removeArtist_L();
                        break;
                    case 4:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 4);
        }
        
        public void viewArtist_L () {
            System.out.println("In viewArtist_L()");
        }
        
        public void addArtist_L () {
            System.out.println("In addArtist_L()");
        }
        
        public void removeArtist_L () {
            System.out.println("In removeArtist_L()");
        }
        
        public void albumLoop_L() {
            int opt;
            
            do {
                System.out.println("[1] - View My Artist List");
                System.out.println("[2] - Add Artist to My List");
                System.out.println("[3] - Remove Artist from My List");
                System.out.println("[4] - Back");
                opt = Integer.parseInt(reader.nextLine());
                
                switch (opt) {
                    case 1:
                        viewAlbum_L();
                        break;
                    case 2:
                        addAlbum_L();
                        break;
                    case 3:
                        removeAlbum_L();
                        break;
                    case 4:
                        // Back
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (opt != 4);
        }
        
        public void viewAlbum_L () {
            System.out.println("In viewAlbum_L()");
        }
        
        public void addAlbum_L () {
            System.out.println("In addAlbum_L()");
        }
        
        public void removeAlbum_L () {
            System.out.println("In removeAlbum_L()");
        }
    }
}


