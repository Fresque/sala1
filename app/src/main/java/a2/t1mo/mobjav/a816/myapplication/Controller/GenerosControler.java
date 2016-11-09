package a2.t1mo.mobjav.a816.myapplication.Controller;

import android.content.Context;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.DAO.GenerosDAO;
import a2.t1mo.mobjav.a816.myapplication.Model.Generos;

/**
 * Created by polialva on 9/11/16.
 */
public class GenerosControler {

    public List<Generos> obtenerGenerosDeJSon(Context context){
        //PEDIRLE AL DAO UN GENERO
        GenerosDAO generosDAO = new GenerosDAO();
        List<Generos> generosList= generosDAO.obtenerGenerosJSon(context);
        return generosList;
    }
}
