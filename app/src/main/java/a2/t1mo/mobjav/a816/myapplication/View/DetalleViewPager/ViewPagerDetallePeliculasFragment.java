package a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 11/15/2016.
 */

public class ViewPagerDetallePeliculasFragment extends Fragment {

    //ADAPTER VIEWPAGER
    DetalleViewPagerAdapter detalleViewPagerAdapter;
    ViewPager mViewPager;

    private ArrayList<Pelicula> listaDePeliculas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        listaDePeliculas = (ArrayList) bundle.getSerializable("lista");

        View view = inflater.inflate(R.layout.fragment_viewpager_detalle, container, false);

        // SETEA EL VIEW PAGER QUE EN UN FUTURO VA A CONTENER LOS DIFERENTES RECYCLERS
        detalleViewPagerAdapter = new DetalleViewPagerAdapter(getFragmentManager(), listaDePeliculas);

        mViewPager = (ViewPager) view.findViewById(R.id.viewPagerDetalle);
        mViewPager.setAdapter(detalleViewPagerAdapter);



        return view;
    }
}
