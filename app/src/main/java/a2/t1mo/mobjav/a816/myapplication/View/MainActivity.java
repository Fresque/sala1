package a2.t1mo.mobjav.a816.myapplication.View;


//MODIFICADO!

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        adapter.setListener(new ListenerJuguetes());

        moviesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        moviesRecyclerView.setAdapter(adapter);


    }

    private class ListenerJuguetes implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int posicion = moviesRecyclerView.getChildAdapterPosition((v));
            Pelicula unaPeliculaAMostrar = adapter.devolverPelicula(posicion);

            //Toast.makeText(v.getContext(), "Hicieron click en " + unJugueteAMostrar.getNombre(), Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
            Bundle bundle = new Bundle();

            bundle.putString("titulo", unaPeliculaAMostrar.getTitle());
            bundle.putString("actors", unaPeliculaAMostrar.getActors());
            bundle.putString("country", unaPeliculaAMostrar.getCountry());
            bundle.putString("director", unaPeliculaAMostrar.getDirector());
            bundle.putString("sinopsis", unaPeliculaAMostrar.getPlot());

            intent.putExtras(bundle);
            startActivity(intent);

        }
    }


}
