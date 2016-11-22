package a2.t1mo.mobjav.a816.myapplication.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;

/**
 * Created by marti on 11/21/2016.
 */

public class CargadorDeDB extends SQLiteOpenHelper {

    public CargadorDeDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void cargarPelicula(Pelicula pelicula){
        //Este se llama cuando quiero cargar una peli en la DB
    }
}
