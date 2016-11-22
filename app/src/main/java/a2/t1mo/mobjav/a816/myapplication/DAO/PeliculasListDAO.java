package a2.t1mo.mobjav.a816.myapplication.DAO;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;
import a2.t1mo.mobjav.a816.myapplication.Util.HTTPConnectionManager;

/**
 * Created by joe on 10/31/16.
 */

public class PeliculasListDAO {

    public void obtenerListaMoviesJSon(Context context, ResultListener<PeliculaListContainer> resultListenerController, String url){

        LevantarListaDeJSONAsyncTask readFromJSONAsyncTask = new LevantarListaDeJSONAsyncTask(context, resultListenerController, url);
        readFromJSONAsyncTask.execute();
    }



    private class LevantarListaDeJSONAsyncTask extends AsyncTask<String, Void, PeliculaListContainer>{

        private Context context;
        private ResultListener<PeliculaListContainer> resultListenerController;
        private String url;

        public LevantarListaDeJSONAsyncTask(Context context, ResultListener<PeliculaListContainer> resultListenerController, String url) {
            this.context = context;
            this.resultListenerController = resultListenerController;
            this.url = url;
        }

        @Override
        protected PeliculaListContainer doInBackground(String... strings) {

            PeliculaListContainer listaDePeliculas = null;

            try {
                //BUSQUEDA EN INTERNET
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                InputStream newsJson = httpConnectionManager.getRequestStream(url); //usa el url que le pasa el .execute

                //PARSEO GSON
                BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(newsJson));
                Gson gson = new Gson();
                listaDePeliculas = gson.fromJson(bufferReaderIn, PeliculaListContainer.class);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listaDePeliculas;
        }

        @Override
        protected void onPostExecute(PeliculaListContainer listaDePeliculas) {
            resultListenerController.finish(listaDePeliculas);
        }
    }




}