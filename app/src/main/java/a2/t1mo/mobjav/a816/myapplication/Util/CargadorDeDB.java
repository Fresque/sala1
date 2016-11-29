/*package a2.t1mo.mobjav.a816.myapplication.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;

*//**
 * Created by marti on 11/21/2016.
 *//*

public class CargadorDeDB extends SQLiteOpenHelper {

    private static final String POSTER_PATH = "POSTER PATH";
    private static final String ADULT = "ADULT";
    private static final String OVERVIEW = "OVERVIEW";
    private static final String RELEASE_DATE = "RELEASE_DATE";
    private static final String GENERE_ID = "GENERE_ID";
    private static final String ID = "ID";
    private static final String ORIGINAL_TITLE = "ORIGINAL_TITLE";
    private static final String ORIGINAL_LANGUAGE = "ORIGINAL_LANGUAGE";
    private static final String TITLE = "TITLE";
    private static final String BACKDROP_PATH = "BACKDROP_PATH";
    private static final String POPULARITY = "POPULARITY";
    private static final String VOTE_COUNT = "VOTE_COUNT";
    private static final String VIDEO = "VIDEO";
    private static final String VOTE_AVERAGE = "VOTE_AVERAGE";
    private static final String BUDGET = "BUDGET";
    private static final String HOMEPAGE = "HOMEPAGE";
    private static final String IMDB_ID = "IMDB_ID";
    private static final String REVENUE = "REVENUE";
    private static final String RUNTIME = "RUNTIME";

    //ES EL ENCARGADO DE CREAR LA BASE DE DATOS
    public CargadorDeDB(Context context) {
        super(context, "CargadorDeDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        //DEFINIR LA ESTRUCTURA DE NUESTRA BASE DE DATOS
        String createSQL =
                "CREATE TABLE " + POSTER_PATH + " ( " +
                        ADULT + " TEXT, " +
                        OVERVIEW + " TEXT, " +
                        RELEASE_DATE + " DATE, " +
                        GENERE_ID + " INTEGER, " +
                        ID + " INTEGER PRIMARY KEY" +  ORIGINAL_TITLE + " TEXT, " +
                        ORIGINAL_LANGUAGE + " TEXT, " +
                        TITLE + " TEXT, " +
                        BACKDROP_PATH + " INTEGER, " +
                        POPULARITY+ " TEXT" + VOTE_COUNT + " INTEGER, " +
                        VOTE_AVERAGE+ " DOUBLE, " +
                        VIDEO + " TEXT, " +
                        BUDGET + " DOUBLE, " +
                        HOMEPAGE + " TEXT" + IMDB_ID + " INTEGER, " +
                        REVENUE + " DOUBLE, " +
                        RUNTIME + " DOUBLE, " + ")";

        database.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //INSERTAR UNA PERSONA EN LA TABLA DE PERSONAS
    public void addPersonToDatabase(Pelicula person){

        ContentValues fila = new ContentValues();

        //CARGO LOS DATOS DENTRO DE LA FILA
        fila.put(ID, person.getId());
        fila.put(TITLE, person.getTitle());
        fila.put(ORIGINAL_TITLE, person.getOriginal_title());
        fila.put(OVERVIEW, person.getOverview());
        fila.put(HOMEPAGE, person.getHomepage());

        //PIDO UNA CONEXION A LA BASE DE DATOS
        SQLiteDatabase database = getWritableDatabase();

        //INSERTA EN LA TABLA PERSONAS LA FILA
        database.insert(Pelicula, null, fila);

        //CERRAR LA CONEXION
        database.close();
    }

    public Pelicula getPersonFromDatabase(Integer id){

        String selectQuery =
                "SELECT * FROM " + Pelicula +
                        " WHERE " + ID + "=" + id;

        //PIDO UNA CONEXION A LA BASE DE DATOS
        SQLiteDatabase database = getReadableDatabase();


        Cursor cursor = database.rawQuery(selectQuery, null);

        Pelicula pelicula = null;

        while(cursor.moveToNext()){
            //LEER CADA FILA DE LOS RESULTADOS

            pelicula = getPelicula(cursor);
        }

        cursor.close();
        database.close();
        return pelicula;
    }


    public List<Person> getPersonsFromDatabases(){

        String selectQuery = "SELECT * FROM " + TABLEPERSON;

        //PIDO UNA CONEXION A LA BASE DE DATOS
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery(selectQuery, null);
        List<Person> personList = new ArrayList<>();

        while(cursor.moveToNext()){

            Person person = getPerson(cursor);
            personList.add(person);
        }

        cursor.close();
        database.close();
        return personList;
    }


    private Person getPerson(Cursor cursor){
        Person person = new Person();

        Integer personID = cursor.getInt(cursor.getColumnIndex(ID));
        person.setId(personID);

        String personName = cursor.getString(cursor.getColumnIndex(NAME));
        person.setName(personName);

        String lastName = cursor.getString(cursor.getColumnIndex(LASTNAME));
        person.setLastName(lastName);

        Integer personAge = cursor.getInt(cursor.getColumnIndex(AGE));
        person.setAge(personAge);

        String personLastTweet = cursor.getString(cursor.getColumnIndex(LASTTWEET));
        person.setLastTweet(personLastTweet);

        return person;
    }
}*/
