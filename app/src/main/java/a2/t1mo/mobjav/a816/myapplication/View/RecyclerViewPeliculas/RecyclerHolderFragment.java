package a2.t1mo.mobjav.a816.myapplication.View.RecyclerViewPeliculas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Controller.PeliculaController;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.R;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;

/**
 * Created by marti on 11/17/2016.
 */

public class RecyclerHolderFragment extends Fragment {

    RecyclerView recyclerView;
    AdaptadorDePeliculas adaptadorDePeliculas;
    List<Pelicula> peliculaList;

    ComunicadorEntreFragmentYActivityRecycler activityActual;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){



        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        peliculaList = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.fragmentRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        adaptadorDePeliculas = new AdaptadorDePeliculas(getActivity());
        adaptadorDePeliculas.setListaDePeliculas(peliculaList);
        adaptadorDePeliculas.setListener(new ListenerDeClicksMain());

        recyclerView.setAdapter(adaptadorDePeliculas);

        PeliculaController peliculaController =  new PeliculaController();
        peliculaController.obtenerListaPeliculas(getContext(), new ResultListener<PeliculaListContainer>() {
            @Override
            public void finish(PeliculaListContainer resultado) {
                peliculaList = resultado.getResults();
                adaptadorDePeliculas.setListaDePeliculas(peliculaList);
                adaptadorDePeliculas.notifyDataSetChanged();
            }
        },url);

        return view;
    }

    private class ListenerDeClicksMain implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int posicion = recyclerView.getChildAdapterPosition((v));
            activityActual.notificarClickRecycler(peliculaList, posicion);
            // Toast.makeText(v.getContext(), "Hicieron click en " + unaPeliculaAMostrar.getTitle(), Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityActual = (ComunicadorEntreFragmentYActivityRecycler) activity;
    }

    public interface ComunicadorEntreFragmentYActivityRecycler {

        public void notificarClickRecycler (List<Pelicula> peliculas, int position);
    }
}
