package a2.t1mo.mobjav.a816.myapplication.Controller;

import android.content.Context;

import a2.t1mo.mobjav.a816.myapplication.DAO.PeliculasDAO;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaInfoContainer;

/**
 * Created by polialva on 26/10/16.
 */
public class PeliculaController {

    public PeliculaInfoContainer peliculaInfo(Context context){
        PeliculasDAO weatherDAO = new PeliculasDAO();
        PeliculasDAO peliculasDAO = weatherDAO.getInfoPeliculaJson(context);
        return peliculasDAO;
    }
}
