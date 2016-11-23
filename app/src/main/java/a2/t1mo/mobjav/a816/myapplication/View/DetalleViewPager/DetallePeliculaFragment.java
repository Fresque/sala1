package a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Controller.PeliculaController;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.R;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;

/**
 * Created by marti on 10/27/2016.
 */

public class DetallePeliculaFragment extends Fragment {

    List<Pelicula> peliculaList;
    Pelicula pelicula;

    public static DetallePeliculaFragment dameUnFragment(Pelicula pelicula){

        //CREAR FRAGMENT
        //CREAR BUNDLE Y PONERLE ADENTRO LA INFO
        //ASOCIAR BUNDLE AL FRAGMENT

        DetallePeliculaFragment detallePeliculaFragment = new DetallePeliculaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", pelicula.getId());
        detallePeliculaFragment.setArguments(bundle);

        return detallePeliculaFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        //RECIBIR EL BUNLE
        Bundle bundle = getArguments();
        String id = bundle.getString("id");
        String url = "https://api.themoviedb.org/3/movie/"+ id +"?api_key=01a81d06ce53d8e3ef9e380989ea4f24&append_to_response=videos,reviews,credits";


        final TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
        final TextView textViewReleaseDate = (TextView) view.findViewById(R.id.textViewReleaseDate);
        final TextView textViewSinopsis = (TextView) view.findViewById(R.id.textViewSinopsis);
        final TextView textViewBudget = (TextView) view.findViewById(R.id.textViewBudget);
        final TextView textViewHomepage = (TextView) view.findViewById(R.id.textViewHomepage);
        final TextView textViewRevenue = (TextView) view.findViewById(R.id.textViewRevenue);
        final TextView textViewRuntime = (TextView) view.findViewById(R.id.textViewRuntime);
        final TextView textViewYoutube = (TextView) view.findViewById(R.id.textViewYoutube);
        final ImageView imageViewBackdrop = (ImageView) view.findViewById(R.id.imagenFondoDetalle);


        final PeliculaController peliculaController = new PeliculaController();
        peliculaController.obtenerPelicula(getContext(), new ResultListener<Pelicula>() {
            @Override
            public void finish(Pelicula resultado) {
                pelicula = resultado;

                Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500/" + pelicula.getBackdrop_path()).into(imageViewBackdrop);
                textViewTitulo.setText(pelicula.getTitle());
                textViewReleaseDate.setText(pelicula.getRelease_date());
                textViewSinopsis.setText(pelicula.getOverview());
                textViewBudget.setText("Budget: "+pelicula.getBudget());
                textViewHomepage.setText(pelicula.getHomepage());
                textViewRevenue.setText("Revenue: "+pelicula.getRevenue());
                textViewRuntime.setText("Runtime: "+pelicula.getRuntime());
                textViewYoutube.setText(pelicula.getKey(0));;


            }
        },url);


        return view;
    }
}