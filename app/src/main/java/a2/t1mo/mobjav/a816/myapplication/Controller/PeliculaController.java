package a2.t1mo.mobjav.a816.myapplication.Controller;

import android.content.Context;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.DAO.PeliculasDAO;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;

/**
 * Created by polialva on 26/10/16.
 */
public class PeliculaController {


    public List<Pelicula> peliculaInfo(Context context){
        PeliculasDAO peliculasDAO = new PeliculasDAO();
        PeliculaListContainer peliculaListContainer = peliculasDAO.getInfoPeliculaJson(context);

        return peliculaListContainer.getResults();
    }
}