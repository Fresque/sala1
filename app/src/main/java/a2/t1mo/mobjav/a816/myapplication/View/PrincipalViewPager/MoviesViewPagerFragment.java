package a2.t1mo.mobjav.a816.myapplication.View.PrincipalViewPager;

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
 * Created by marti on 11/3/2016.
 */

public class MoviesViewPagerFragment extends Fragment{
    RecyclerView moviesRecyclerView;
    MoviesReciclerViewAdapter adapter;
    List<Pelicula> peliculaList;
    ComunicadorEntreFragmentYActivityMain activityActual;


    public static MoviesViewPagerFragment nuevoFragment(String url){

        MoviesViewPagerFragment fragment = new MoviesViewPagerFragment();
        //paso el url
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        fragment.setArguments(bundle);

        return fragment;
    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //QUE HACE LA VISTA CUANDO RECIBE EL RESULTADO
        //MUESTRA LA PELICULA

        peliculaList = new ArrayList<>();
        Bundle bundle = getArguments();
        String url = bundle.getString("url");


        //CARGA CADA FRAGMENT AL OBTENER LAS LISTAS
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.obtenerListaPeliculas(getContext(), new ResultListener<PeliculaListContainer>() {
            @Override
            public void finish(PeliculaListContainer resultado) {

                peliculaList = resultado.getResults();
                adapter.setListaDePeliculas(peliculaList);
                adapter.notifyDataSetChanged();
            }
        },url);

        View fragmentView = inflater.inflate(R.layout.fragment_recycler, container, false);

        moviesRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.fragmentRecycler);
        moviesRecyclerView.setHasFixedSize(true);

        adapter = new MoviesReciclerViewAdapter(getActivity());
        adapter.setListaDePeliculas(peliculaList);
        adapter.setListener(new ListenerDeClicksRecycler());

        moviesRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false));
        moviesRecyclerView.setAdapter(adapter);


        return fragmentView;
    }


    private class ListenerDeClicksRecycler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int posicion = moviesRecyclerView.getChildAdapterPosition((v));
            activityActual.notificarClickMain(peliculaList, posicion);
           // Toast.makeText(v.getContext(), "Hicieron click en " + unaPeliculaAMostrar.getTitle(), Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        activityActual = (ComunicadorEntreFragmentYActivityMain) activity;
    }

    public interface ComunicadorEntreFragmentYActivityMain {

        public void notificarClickMain(List<Pelicula> peliculas, int position);
    }

}
