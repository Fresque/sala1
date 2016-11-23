package a2.t1mo.mobjav.a816.myapplication.View;


import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

import java.util.ArrayList;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Controller.GenerosControler;
import a2.t1mo.mobjav.a816.myapplication.Model.Generos;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;
import a2.t1mo.mobjav.a816.myapplication.Util.TMDBHelper;
import a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager.ViewPagerDetallePeliculasFragment;
import a2.t1mo.mobjav.a816.myapplication.View.PrincipalViewPager.MoviesViewPagerFragment;
import a2.t1mo.mobjav.a816.myapplication.View.PrincipalViewPager.ViewPagerFragment;
import a2.t1mo.mobjav.a816.myapplication.View.RecyclerViewPeliculas.RecyclerHolderFragment;

public class  MainActivity extends AppCompatActivity implements MoviesViewPagerFragment.ComunicadorEntreFragmentYActivity{

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "bpIfsLARachzlEVdskss6jOZR";
    private static final String TWITTER_SECRET = "CEWWlEryD2NMMTL99GYZLeY6zR7UzYnzqF4DBN6ACIxFcxCiGp";

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);



        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.acaVaElFragment, viewPagerFragment);
        fragmentTransaction.commit();

        //BUSCO EL NAVIGATION VIEW EN EL XML
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        //BUSCAR EL DRAWER LAYOUT
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //CREO UN LISTENER DEL TIPO LISTENER NAVIGATION VIEW
        ListenerNavigationView unListener = new ListenerNavigationView();

        //ASIGNO AL NAVIGATION VIEW EL LISTENER
        navigationView.setNavigationItemSelectedListener(unListener);
        cargarGenerosNavigation();
    }

    public void cargarGenerosNavigation(){
        GenerosControler generosControler = new GenerosControler();
        List<Generos> generosList = generosControler.obtenerGenerosDeJSon(this);
        Menu menu = navigationView.getMenu();
        for (Generos generos:generosList){
            menu.add(generos.getName());
        }

    }

    @Override
    public void notificarClick(List<Pelicula> peliculas, int position) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (ArrayList) peliculas);
        bundle.putInt("posicion", position);

        ViewPagerDetallePeliculasFragment viewPagerDetallePeliculasFragment = new ViewPagerDetallePeliculasFragment();

        viewPagerDetallePeliculasFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.acaVaElFragment, viewPagerDetallePeliculasFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private class ListenerNavigationView implements NavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            if  (item.getTitle().equals("Action")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_ACTION);
            }
            if  (item.getTitle().equals("Adventure")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_ADVENTURE);
            }
            if  (item.getTitle().equals("Animation")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_ANIMATION);
            }
            if  (item.getTitle().equals("Comedy")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_COMEDY);
            }
            if  (item.getTitle().equals("Crime")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_CRIME);
            }
            if  (item.getTitle().equals("Documentary")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_DOCUMENTARY);
            }
            if  (item.getTitle().equals("Drama")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_DRAMA);
            }
            if  (item.getTitle().equals("Family")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_FAMILY);
            }
            if  (item.getTitle().equals("Fantasy")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_FANTASY);
            }
            if  (item.getTitle().equals("History")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_HISTORY);
            }
            if  (item.getTitle().equals("Horror")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_HORROR);
            }
            if  (item.getTitle().equals("Music")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_MUSIC);
            }
            if  (item.getTitle().equals("Mystery")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_MYSTERY);
            }
            if  (item.getTitle().equals("Romance")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_ROMANCE);
            }
            if  (item.getTitle().equals("Science Fiction")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_SCIENCE_FICTION);
            }
            if  (item.getTitle().equals("TV Movie")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_SCIENCE_TV_MOVIE);
            }
            if  (item.getTitle().equals("Triller")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_SCIENCE_THRILLER);
            }
            if  (item.getTitle().equals("War")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_SCIENCE_WAR);
            }
            if  (item.getTitle().equals("Western")){
                Toast.makeText(MainActivity.this, "Hicieron click en " + item.getTitle(), Toast.LENGTH_LONG).show();
                iniciarFragmentPorGenero(TMDBHelper.MOVIE_GENRE_SCIENCE_WESTERN);
            }

            return true;
        }

        private void iniciarFragmentPorGenero (String string){

            Bundle bundle = new Bundle();
            bundle.putString("url", TMDBHelper.getMoviesByGenre(string));

            RecyclerHolderFragment recyclerHolderFragment = new RecyclerHolderFragment();
            recyclerHolderFragment.setArguments(bundle);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.acaVaElFragment, recyclerHolderFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            drawerLayout.closeDrawers();
        }
    }
}