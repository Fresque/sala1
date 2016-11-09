package a2.t1mo.mobjav.a816.myapplication.View;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import a2.t1mo.mobjav.a816.myapplication.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final ActionBar actionBar = getActionBar();

        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.acaVaElFragment, viewPagerFragment);
        fragmentTransaction.commit();

    }

}

