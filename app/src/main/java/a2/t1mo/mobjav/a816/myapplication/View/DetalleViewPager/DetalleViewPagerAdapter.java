package a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;

/**
 * Created by marti on 11/15/2016.
 */
public class DetalleViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> listaDeFragmentos = new ArrayList<>();

    private List<Pelicula> listaDepeliculas;

    //En el adaptador del View Pager, recibir una lista de objetos, crear un for each que por cada objeto
    //llame a dame un fragment y devuelva una lista de fragments

    public DetalleViewPagerAdapter(FragmentManager fm, ArrayList<Pelicula> peliculas){
        super(fm);

        listaDepeliculas = peliculas;

        for (Pelicula pelicula:listaDepeliculas) {
            listaDeFragmentos.add(DetallePeliculaFragment.dameUnFragment(pelicula));
        }

    }

    @Override
    public Fragment getItem(int position) {
        return listaDeFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return listaDeFragmentos.size();
    }

}
