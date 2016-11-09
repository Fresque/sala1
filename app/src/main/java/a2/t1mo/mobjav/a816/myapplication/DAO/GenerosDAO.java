package a2.t1mo.mobjav.a816.myapplication.DAO;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;

import com.google.gson.Gson;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Model.Generos;
import a2.t1mo.mobjav.a816.myapplication.Model.GenerosListContainer;

/**
 * Created by polialva on 9/11/16.
 */
public class GenerosDAO {

    public List<Generos> obtenerGenerosJSon(Context context){
        AssetManager manager = context.getAssets();
        InputStream generosJson = null;
        GenerosListContainer generosListContainer = null;

        try {
            generosJson = manager.open("generos.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(generosJson));
            Gson gson = new Gson();
            generosListContainer = gson.fromJson(bufferReaderIn, GenerosListContainer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return generosListContainer.getListaDeGeneros();
    }

}
