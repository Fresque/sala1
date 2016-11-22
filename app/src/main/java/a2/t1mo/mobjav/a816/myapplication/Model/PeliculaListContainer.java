package a2.t1mo.mobjav.a816.myapplication.Model;

import java.util.ArrayList;

/**
 * Created by marti on 10/26/2016.
 */

public class PeliculaListContainer {

    private ArrayList<Pelicula> results;

    public Pelicula getPelicula(int position){
        return results.get(position);
    }

    public ArrayList<Pelicula> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pelicula> results) {
        this.results = results;
    }
}
