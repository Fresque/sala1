package a2.t1mo.mobjav.a816.myapplication.DAO;

import android.content.Context;
import android.graphics.Movie;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;
import a2.t1mo.mobjav.a816.myapplication.Util.HTTPConnectionManager;

/**
 * Created by joe on 10/31/16.
 */
public class PeliculasDAO {

    public void obtenerMoviesJSon(Context context, ResultListener<PeliculaListContainer> resultListenerController){

        LeerdeJSONSAsynctask readFromJSONAsyncTask = new LeerdeJSONSAsynctask(context, resultListenerController);
        readFromJSONAsyncTask.execute();
    }

    private class LeerdeJSONSAsynctask extends AsyncTask<String, Void, PeliculaListContainer>{

        private Context context;
        private ResultListener<PeliculaListContainer> resultListenerController;

        public LeerdeJSONSAsynctask(Context context, ResultListener<PeliculaListContainer> resultListenerController) {
            this.context = context;
            this.resultListenerController = resultListenerController;
        }

        @Override
        protected PeliculaListContainer doInBackground(String... strings) {

            PeliculaListContainer listaDePeliculas = null;

            try {
                //BUSQUEDA EN INTERNET
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                InputStream newsJson = httpConnectionManager.getRequestStream("https://api.themoviedb.org/3/movie/popular?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US%22");

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