package a2.t1mo.mobjav.a816.myapplication.View;


import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Controller.GenerosControler;
import a2.t1mo.mobjav.a816.myapplication.Model.Generos;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;
import a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager.DetalleViewPagerAdapter;
import a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager.ViewPagerDetallePeliculasFragment;
import a2.t1mo.mobjav.a816.myapplication.View.PrincipalViewPager.MoviesViewPagerFragment;
import a2.t1mo.mobjav.a816.myapplication.View.PrincipalViewPager.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements MoviesViewPagerFragment.ComunicadorEntreFragmentYActivity{

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
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
    public void notificarClick(List<Pelicula> peliculas, Integer position) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (ArrayList) peliculas);
        bundle.putInt("posicion", position);

        ViewPagerDetallePeliculasFragment viewPagerDetallePeliculasFragment = new ViewPagerDetallePeliculasFragment();

        viewPagerDetallePeliculasFragment.setArguments(bundle);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.acaVaElFragment, viewPagerDetallePeliculasFragment);
        fragmentTransaction.commit();
    }

    private class ListenerNavigationView implements NavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            /*android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment unFragment = null;

            if( item.getItemId() == R.id.peliculasAccionFragment){
                unFragment = new PeliculasAccion();
            }

            if( item.getItemId() == R.id.segundoFragment){
                unFragment = new SegundoFragment();

            }

            if( item.getItemId() == R.id.tercerFragment){
                unFragment = new TercerFragment();
            }

            fragmentTransaction.replace(R.id.aca_va_el_fragment, unFragment);
            fragmentTransaction.commit();
            drawerLayout.closeDrawers();*/
            return true;
        }
    }

    }


