package a2.t1mo.mobjav.a816.myapplication.View;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import a2.t1mo.mobjav.a816.myapplication.Controller.PeliculaController;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.R;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;

public class MainActivity extends AppCompatActivity {

    RecyclerView moviesRecyclerView;
    MoviesReciclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PeliculaController peliculaController = new PeliculaController();
        ResultListenerView resultListener = new ResultListenerView();

        peliculaController.obtenerPeliculasPopulares(MainActivity.this, resultListener);

    }

    public class ResultListenerView implements ResultListener<PeliculaListContainer> {

        @Override
        public void finish(PeliculaListContainer peliculaListContainer) {
            //QUE HACE LA VISTA CUANDO RECIBE EL RESULTADO
            //MUESTRA LA PELICULA
            moviesRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewPosters);
            moviesRecyclerView.setHasFixedSize(true);

            adapter = new MoviesReciclerViewAdapter(MainActivity.this, peliculaListContainer.getResults() );
            adapter.setListener(new ListenerDeClicks());

            moviesRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3, LinearLayoutManager.VERTICAL, false));
            moviesRecyclerView.setAdapter(adapter);

        }
    }

    /*private class ListenerDeClicks implements View.OnClickListener {

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
            bundle.putString("realizeDate" unaPeliculaAMostrar.getRelease_date());

            intent.putExtras(bundle);
            startActivity(intent);

        }
    }*/


}
