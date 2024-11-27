package finals_lab.tn28;

import java.util.*;

public class Finals_LabTN28 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MusicCatalogueSystem mcs = new MusicCatalogueSystem(reader);
        
        int main_opt;
        do {
            System.out.println("[1] - Catalogue");
            System.out.println("[2] - Library");
            System.out.println("[3] - Exit");
            main_opt = Integer.parseInt(reader.nextLine());
            switch (main_opt) {
                case 1:
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
                    {
                        int opt = Integer.parseInt(reader.nextLine());
                        switch (opt) {
                            case 1:
                                
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }
                    break;
                case 2:
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
            // mcs.viewArtist_C()
            // mcs.addArtist_C()
            // mcs.removeArtist_C()
        
            // mcs.viewAlbum_C()
            // mcs.addAlbum_C()
            // mcs.removeAlbum_C()
        
        // LIBRARY FUCNTIONS
            // mcs.viewArtist_L()
            // mcs.addArtist_L()
            // mcs.removeArtist_L()
        
            // mcs.viewAlbum_L()
            // mcs.addAlbum_L()
            // mcs.removeArtist_L()
        
        
    }
}


