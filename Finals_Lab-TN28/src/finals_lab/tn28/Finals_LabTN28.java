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
            System.out.print("\nEnter Option: ");
            main_opt = Integer.parseInt(reader.nextLine());
            switch (main_opt) {
                case 1:
                    mcs.catalogueLoop();
                    break;
                case 2:
                    mcs.libraryLoop();
                    break;
                case 3:
                    mcs.mcsClose();
                    break;
                default:
                    System.out.println("Invalid input.");
            }
            
        } while (main_opt != 3);
    }
    
    private static class MusicCatalogueSystem {
        Scanner reader;
        
        Catalogue myCatalogue = new Catalogue(reader);
        Library myLibrary = new Library();

        MusicCatalogueSystem(Scanner reader) {
            this.reader = reader;
            mcsSetup();
        }
        
        public final void mcsSetup () {
            // Catalogue Setup
                // Read from ArtistCatalogue.txt
                // Read from AlbumCatalogue.txt
            // read library txt file
                // Read from ArtistLibrary.txt
                // Read from ArtistLibrary.txt
        }
        
        public final void mcsClose() {
            // Save the changes into the Catalogue
                // Write to ArtistCatalogue.txt
                // Write to AlbumCatalogue.txt
            // Save the changes into the Library
                // Write to ArtistLibrary.txt
                // Write to AlbumLibrary.txt
        }
        
        // CATALOGUE FUNCTIONS
        
        public void catalogueLoop() {
            int opt;
            
            do {
                System.out.println("[1] - View Catalogue");
                System.out.println("[2] - Add to Catalogue");
                System.out.println("[3] - Remove from Catalogue");
                System.out.println("[4] - Back");
                System.out.print("\nEnter Option: ");
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
                System.out.print("\nEnter Option: ");
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
        
        public void addLoop_C() {
            int opt;
            
            do {
                System.out.println("[1] - Add new artist to catalogue");
                System.out.println("[2] - Add new album to catalogue");
                System.out.println("[3] - Back");
                System.out.print("\nEnter Option: ");
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
        
        public void removeLoop_C() {
            int opt;
            
            do {
                System.out.println("[1] - Remove an artist (and all associated albums)");
                System.out.println("[2] - Remove an album");
                System.out.println("[3] - Back");
                System.out.print("\nEnter Option: ");
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
        
        // LIBRARY FUCNTIONS
       
        public void libraryLoop() {
            int opt;
            
            do {    
                System.out.println("[1] - Artists");
                System.out.println("[2] - Albums");
                System.out.println("[3] - Back");
                System.out.print("\nEnter Option: ");
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
            } while (opt != 3);
        }
        
        public void artistLoop_L() {
            int opt;
            
            do {
                System.out.println("[1] - View My Artist List");
                System.out.println("[2] - Add Artist to My List");
                System.out.println("[3] - Remove Artist from My List");
                System.out.println("[4] - Back");
                System.out.print("\nEnter Option: ");
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
        
        public void albumLoop_L() {
            int opt;
            
            do {
                System.out.println("[1] - View My Artist List");
                System.out.println("[2] - Add Artist to My List");
                System.out.println("[3] - Remove Artist from My List");
                System.out.println("[4] - Back");
                System.out.print("\nEnter Option: ");
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
    }
}


