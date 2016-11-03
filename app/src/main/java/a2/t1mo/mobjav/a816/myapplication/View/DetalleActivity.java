package a2.t1mo.mobjav.a816.myapplication.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 10/27/2016.
 */

public class DetalleActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String title = (String) bundle.get("title");
        String actors = (String) bundle.get("actors");
        String country = (String) bundle.get("country");
        String director = (String) bundle.get("director");
        String sinopsis = (String) bundle.get("sinopsis");
        String realizeDate = (String) bundle.get("realizeDate");
        String posterPelicula = (String) bundle.get("poster");

        ImageView posterImageView = (ImageView)findViewById(R.id.imagenFondoDetalle);
        TextView titleTextView = (TextView)findViewById(R.id.textViewTitulo);
        TextView realizeDateTextView = (TextView)findViewById(R.id.realizeDateDetalleView);
        TextView actorsTextView = (TextView)findViewById(R.id.textViewActores);
        TextView countryTextView = (TextView)findViewById(R.id.textViewPais);
        TextView directorTextView = (TextView)findViewById(R.id.textViewDirector);
        TextView sinopsisTextView = (TextView)findViewById(R.id.textViewSinopsis);

//        posterImageView.setImageResource(R.drawable.batman);
        titleTextView.setText(title);
        actorsTextView.setText(actors);
        countryTextView.setText(country);
        directorTextView.setText(director);
        sinopsisTextView.setText(sinopsis);

        realizeDateTextView.setText(realizeDate);
        sinopsisTextView.setText(sinopsis);

        Glide.with(DetalleActivity.this).load("https://image.tmdb.org/t/p/w500/" + posterPelicula).into(posterImageView);

    }
}