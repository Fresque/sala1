package a2.t1mo.mobjav.a816.myapplication.Controller;

import android.content.Context;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.DAO.PeliculasDAO;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;

/**
 * Created by polialva on 26/10/16.
 */
public class PeliculaController {

    private ResultListener<PeliculaListContainer> resultListenerView;

    public void obtenerPeliculasPopulares (Context context, ResultListener<PeliculaListContainer> resultListenerView){
        //PEDIRLE AL DAO UNA PELICULA
        PeliculasDAO peliculasDAO = new PeliculasDAO();
        ResultListenerController resultListenerController = new ResultListenerController();
        this.resultListenerView = resultListenerView;
        peliculasDAO.obtenerMoviesJSon(context, resultListenerController);
    }

    private class ResultListenerController implements ResultListener<PeliculaListContainer> {

        @Override
        public void finish(PeliculaListContainer resultado) {
            //QUE TIENE QUE HACER EL CONTROLLER CUANDO EL DAO LE AVISA QUE TIENE LA PELICULA
            //LE AVISA A LA VISTA QUE CONSIGUIO LA PELICULA.
            resultListenerView.finish(resultado);
        }
    }
}