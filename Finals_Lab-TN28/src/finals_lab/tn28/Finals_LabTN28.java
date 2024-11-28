package finals_lab.tn28;

import java.util.*;

public class Finals_LabTN28 {
    public static void main(String[] args) {
        Catalogue myCatalogue = new Catalogue();
        
        myCatalogue.addArtist(new Artist("Fiona Apple"));
        myCatalogue.addArtist(new Artist("Car Seat Headrest"));
        myCatalogue.addArtist(new Artist("Mitski"));
        myCatalogue.addArtist(new Artist("Geiko"));
        
        System.out.println("");
        
        myCatalogue.addAlbum("Fiona Apple", "When The Pawn...", 1999);
    }
}