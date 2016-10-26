package a2.t1mo.mobjav.a816.myapplication.DAO;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;

/**
 * Created by polialva on 26/10/16.
 */
public class PeliculasDAO {

    public PeliculaListContainer getInfoPeliculaJson(Context context){

        PeliculaListContainer peliculaListContainer = null;

        try {
            // ABRIR ARCHIVO
            AssetManager manager = context.getAssets();
            InputStream inputStream = manager.open("datosPeliculas.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // USO GSON
            Gson gson = new Gson();
            peliculaListContainer = gson.fromJson(bufferedReader,PeliculaListContainer.class);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        Log.d("tag", peliculaListContainer.toString());
        return peliculaListContainer;
    }
}
