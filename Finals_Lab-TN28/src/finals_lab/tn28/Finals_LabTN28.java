package finals_lab.tn28;

import java.util.*;
import java.io.*;

public class Finals_LabTN28 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);    
        MusicCatalogueSystem mcs = new MusicCatalogueSystem(reader);
        
        int main_opt;
        
        do {
            System.out.println("---------MENU------------------");
            System.out.println("[1] View Catalogue");
            System.out.println("[2] Add to Catalogue");
            System.out.println("[3] Remove from Catalogue");
            System.out.println("[4] Exit System");
            System.out.println("\nEnter option: ");
            main_opt = Integer.parseInt(reader.nextLine());
            
            switch (main_opt) {
                case 1:
                {
                    int opt;
                    do {
                        System.out.println("---------VIEW------------------");
                        System.out.println("[1] View Artists");
                        System.out.println("[2] View Albums");
                        System.out.println("[3] Back");
                        System.out.println("\nEnter option: ");
                        opt =Integer.parseInt(reader.nextLine());
                        
                        switch (opt) {
                            case 1:
                                System.out.println("Artists in Catalogue:");
                                mcs.displayArtists();
                                break;
                            case 2:
                                System.out.println("Albums in Catalogue:");
                                mcs.displayAlbums();
                                break;
                            case 3:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } while (opt != 3);
                }
                    break;
                case 2:
                {
                    int opt;
                    do {
                        System.out.println("---------ADD-------------------");
                        System.out.println("[1] Add Artist");
                        System.out.println("[2] Add Album");
                        System.out.println("[3] Back");
                        System.out.println("\nEnter option: ");
                        opt =Integer.parseInt(reader.nextLine());
                        
                        switch (opt) {
                            case 1:
                            {
                                System.out.print("Enter artist name: ");
                                String name = reader.nextLine();
                                mcs.addArtist(name);
                            }
                                break;
                            case 2:
                            {
                                System.out.print("Enter artist name: ");
                                String name = reader.nextLine();
                                System.out.print("Enter album title: ");
                                String title = reader.nextLine();
                                System.out.print("Enter album year: ");
                                int year = Integer.parseInt(reader.nextLine());
                                mcs.addAlbum(name, title, year);
                            }
                                break;
                            case 3:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } while (opt != 3);
                }
                    break;
                case 3:
                {
                    int opt;
                    do {
                        System.out.println("---------REMOVE----------------");
                        System.out.println("[1] Remove Artist");
                        System.out.println("[2] Remove Album");
                        System.out.println("[3] Back");
                        System.out.println("\nEnter option: ");
                        opt =Integer.parseInt(reader.nextLine());
                        
                        switch (opt) {
                            case 1:
                            {
                                System.out.print("Enter artist name: ");
                                String name = reader.nextLine();
                                mcs.removeArtist(name);
                            }
                                break;
                            case 2:
                            {
                                System.out.println("Enter artist name: ");
                                String name = reader.nextLine();
                                System.out.println("Enter album title: ");
                                String title = reader.nextLine();
                                mcs.removeAlbum(name, title);
                            }
                                break;
                            case 3:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } while (opt != 3);
                }   
                    break;
                case 4:
                    System.out.println("Exiting Program...");
                    mcs.closeSystem();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (main_opt != 4);
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