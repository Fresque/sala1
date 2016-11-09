package a2.t1mo.mobjav.a816.myapplication.View;


import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;

public class MainActivity extends FragmentActivity {

    //ADAPTER VIEWPAGER
    MoviesViewPagerAdapter moviesViewPagerAdapter;
    ViewPager mViewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionBar = getActionBar();

        // SETEA EL VIEW PAGER QUE EN UN FUTURO VA A CONTENER LOS DIFERENTES RECYCLERS
        moviesViewPagerAdapter = new MoviesViewPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.viewPagerPrincipal);
        mViewPager.setAdapter(moviesViewPagerAdapter);

        //SETEO EL TABlAYOUT AL VIEWPAGER
        //FALTA ESTABLECER COLORES Y DEMAS
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

}

