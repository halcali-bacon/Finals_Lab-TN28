package finals_lab.tn28;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Queue;

public class Finals_LabTN28 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MusicCatalogueSystem mcs = new MusicCatalogueSystem(reader);
        
        int opt;
        do {
            System.out.println("[1] - ");
            System.out.println("[2] - ");
            System.out.println("[3] - ");
            System.out.println("[4] - ");
            System.out.println("[5] - ");
            opt = Integer.parseInt(reader.nextLine());
            switch (opt) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                default:
                    System.out.println("Invalid input.");
            }
            
        } while (opt != 0);
    }
    
    private static class MusicCatalogueSystem {
        Queue<Album> myAlbums;
        Queue<Artist> myArtists;
        Scanner reader;
        String username;

        MusicCatalogueSystem(Scanner reader) {
            this.reader = reader;
            myAlbums = new PriorityQueue<>();
            myArtists = new PriorityQueue<>();

            System.out.print("Enter your name: ");
            username = reader.nextLine();

            System.out.println("Welcome, " + username);
        }
    }
}


