package a2.t1mo.mobjav.a816.myapplication.View.PrincipalViewPager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 11/9/2016.
 */

public class ViewPagerFragment extends Fragment {

    //ADAPTER VIEWPAGER
    MoviesViewPagerAdapter moviesViewPagerAdapter;
    ViewPager mViewPager;
    TabLayout tabLayout;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vew_pager, container, false);


        // SETEA EL VIEW PAGER QUE EN UN FUTURO VA A CONTENER LOS DIFERENTES RECYCLERS
        moviesViewPagerAdapter = new MoviesViewPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.viewPagerPrincipal);
        mViewPager.setAdapter(moviesViewPagerAdapter);

        //SETEO EL TABlAYOUT AL VIEWPAGER
        //FALTA ESTABLECER COLORES Y DEMAS
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }
}

