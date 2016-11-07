package a2.t1mo.mobjav.a816.myapplication.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by marti on 11/2/2016.
 */

public class MoviesViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> listaDeFragmentos = new ArrayList<>();

    public MoviesViewPagerAdapter(FragmentManager fm) {
        super(fm);

        //listaDeFragmentos.add(MoviesViewPagerFragment.nuevoFragment("https://api.themoviedb.org/3/movie/latest?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US"));
        listaDeFragmentos.add(MoviesViewPagerFragment.nuevoFragment("https://api.themoviedb.org/3/movie/now_playing?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US"));
        listaDeFragmentos.add(MoviesViewPagerFragment.nuevoFragment("https://api.themoviedb.org/3/movie/popular?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US"));
        listaDeFragmentos.add(MoviesViewPagerFragment.nuevoFragment("https://api.themoviedb.org/3/movie/top_rated?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US"));
        listaDeFragmentos.add(MoviesViewPagerFragment.nuevoFragment("https://api.themoviedb.org/3/movie/upcoming?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US"));
    }

    @Override
    public Fragment getItem(int i) {
        return listaDeFragmentos.get(i);
    }

    @Override
    public int getCount() {
        return listaDeFragmentos.size();
    }


}
