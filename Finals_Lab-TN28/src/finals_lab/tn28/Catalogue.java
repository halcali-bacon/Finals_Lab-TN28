package finals_lab.tn28;

import java.util.*;

public class Catalogue {
    Queue<Artist> artistCatalogue;
    Queue<Album> albumCatalogue;
    
    // CONSTRUCTORS
    
    // This is the constructor for Catalogues that were retrieved from previous sessions
    Catalogue(Queue<Artist> artistCatalogue, Queue<Album> albumCatalogue) {
        this.artistCatalogue = new PriorityQueue<>(artistCatalogue);
        this.albumCatalogue = new PriorityQueue<>(albumCatalogue);
    }
    
    // This is the constructor for Catalogues created at runtime
    Catalogue() {
        artistCatalogue = new PriorityQueue<>();
        albumCatalogue = new PriorityQueue<>();
    }
}
