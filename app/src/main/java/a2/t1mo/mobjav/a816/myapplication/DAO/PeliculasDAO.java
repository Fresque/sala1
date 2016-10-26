package a2.t1mo.mobjav.a816.myapplication.DAO;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaContainer;

/**
 * Created by polialva on 26/10/16.
 */
public class PeliculasDAO {

    public obtenerPelicula getInfoPeliculaJson(Context context){

        PeliculaContainer peliculaContainer = null;

        try {
            // ABRIR ARCHIVO
            AssetManager manager = context.getAssets();
            InputStream inputStream = manager.open("batman.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // USO GSON
            Gson gson = new Gson();
            peliculaContainer = gson.fromJson(bufferedReader,PeliculaContainer.class);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        Log.d("tag", peliculaContainer.toString());
        return peliculaContainer;
    }
}
