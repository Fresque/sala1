package a2.t1mo.mobjav.a816.myapplication.Controller;

import android.content.Context;

import a2.t1mo.mobjav.a816.myapplication.DAO.PeliculasDAO;
import a2.t1mo.mobjav.a816.myapplication.DAO.PeliculasListDAO;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;

/**
 * Created by polialva on 26/10/16.
 */
public class PeliculaController {

    private ResultListener<PeliculaListContainer> resultListenerListView;
    private ResultListener<Pelicula> resultListenerSoloView;

    public void obtenerListaPeliculas(Context context, ResultListener<PeliculaListContainer> resultListenerListView, String url){
        //PEDIRLE AL DAO UNA PELICULA
        PeliculasListDAO peliculasListDAO = new PeliculasListDAO();
        ResultListenerListaController resultListenerListaController = new ResultListenerListaController();
        this.resultListenerListView = resultListenerListView;
        peliculasListDAO.obtenerListaMoviesJSon(context, resultListenerListaController, url);
    }


    private class ResultListenerListaController implements ResultListener<PeliculaListContainer> {

        @Override
        public void finish(PeliculaListContainer resultado) {
            //QUE TIENE QUE HACER EL CONTROLLER CUANDO EL DAO LE AVISA QUE TIENE LA PELICULA
            //LE AVISA A LA VISTA QUE CONSIGUIO LA PELICULA.
            resultListenerListView.finish(resultado);
        }
    }

    public void obtenerPelicula(Context context, ResultListener<Pelicula> resultListenerSoloView, String url){
        //PEDIRLE AL DAO UNA PELICULA
        PeliculasDAO peliculasDAO = new PeliculasDAO();
        ResultListenerSoloController resultListenerSoloController = new ResultListenerSoloController();
        this.resultListenerSoloView = resultListenerSoloView;
        peliculasDAO.obtenerMovieJSon(context, resultListenerSoloController, url);
    }


    private class ResultListenerSoloController implements ResultListener<Pelicula> {

        @Override
        public void finish(Pelicula resultado) {
            //QUE TIENE QUE HACER EL CONTROLLER CUANDO EL DAO LE AVISA QUE TIENE LA PELICULA
            //LE AVISA A LA VISTA QUE CONSIGUIO LA PELICULA.
            resultListenerSoloView.finish(resultado);
        }
    }
}