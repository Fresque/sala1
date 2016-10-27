package a2.t1mo.mobjav.a816.myapplication.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Controller.PeliculaController;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView moviesRecyclerView;
    MoviesReciclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeliculaController peliculaController = new PeliculaController();
        List<Pelicula> peliculasList = peliculaController.peliculaInfo(this);

        moviesRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewPosters);
        moviesRecyclerView.setHasFixedSize(true);

        adapter = new MoviesReciclerViewAdapter(this, peliculasList);
        //Setear listener

        moviesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        moviesRecyclerView.setAdapter(adapter);


    }

}


// hola como estas