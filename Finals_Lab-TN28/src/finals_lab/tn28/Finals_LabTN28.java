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
        myCatalogue.addAlbum("Fiona Apple", "Tidal", 1996);
        myCatalogue.addAlbum("Car Seat Headrest", "Twin Fantasy", 2018);
        myCatalogue.addAlbum("Car Seat Headrest", "Teens of Denial", 2016);
        myCatalogue.addAlbum("Mitski", "Bury Me At Makeout Creek", 2014);
        myCatalogue.addAlbum("Mitski", "Puberty 2", 2016);
        
        myCatalogue.displayAlbums();
    }
}