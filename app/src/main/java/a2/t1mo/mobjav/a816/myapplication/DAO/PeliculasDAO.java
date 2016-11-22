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
import a2.t1mo.mobjav.a816.myapplication.Util.HTTPConnectionManager;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;

/**
 * Created by marti on 11/22/2016.
 */

public class PeliculasDAO {

    public void obtenerMovieJSon(Context context, ResultListener<Pelicula> resultListenerController, String url){

        LevantarPeliculaDeJSONAsyncTask readFromJSONAsyncTask = new LevantarPeliculaDeJSONAsyncTask(context, resultListenerController, url);
        readFromJSONAsyncTask.execute();
    }

    private class LevantarPeliculaDeJSONAsyncTask extends AsyncTask<String, Void, Pelicula> {

        private Context context;
        private ResultListener<Pelicula> resultListenerController;
        private String url;

        public LevantarPeliculaDeJSONAsyncTask(Context context, ResultListener<Pelicula> resultListenerController, String url) {
            this.context = context;
            this.resultListenerController = resultListenerController;
            this.url = url;
        }

        @Override
        protected Pelicula doInBackground(String... strings) {

            Pelicula pelicula = null;

            try {
                //BUSQUEDA EN INTERNET
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                InputStream newsJson = httpConnectionManager.getRequestStream(url); //usa el url que le pasa el .execute

                //PARSEO GSON
                BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(newsJson));
                Gson gson = new Gson();
                pelicula = gson.fromJson(bufferReaderIn, Pelicula.class);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pelicula;
        }

        @Override
        protected void onPostExecute(Pelicula pelicula) {
            resultListenerController.finish(pelicula);
        }
    }
}
