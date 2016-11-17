package a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 10/27/2016.
 */

public class DetallePeliculaFragment extends Fragment {

    public static DetallePeliculaFragment dameUnFragment(Pelicula pelicula){

        //CREAR FRAGMENT
        //CREAR BUNDLE Y PONERLE ADENTRO LA INFO
        //ASOCIAR BUNDLE AL FRAGMENT

        DetallePeliculaFragment detallePeliculaFragment = new DetallePeliculaFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("pelicula", pelicula);
        detallePeliculaFragment.setArguments(bundle);

        return detallePeliculaFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        //RECIBIR EL BUNLE
        Bundle bundle = getArguments();
        Pelicula pelicula = (Pelicula) bundle.getSerializable("pelicula");


        //POPULAR CON LA INFO DEL BUNDLE
        TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
        textViewTitulo.setText(pelicula.getTitle());

        TextView textViewReleaseDate = (TextView) view.findViewById(R.id.textViewReleaseDate);
        textViewReleaseDate.setText(pelicula.getRelease_date());

        TextView textViewSinopsis = (TextView) view.findViewById(R.id.textViewSinopsis);
        textViewSinopsis.setText(pelicula.getOverview());

        ImageView imageViewBackdrop = (ImageView) view.findViewById(R.id.imagenFondoDetalle);
        Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500/" + pelicula.getBackdrop_path()).into(imageViewBackdrop);

        return view;
    }
}