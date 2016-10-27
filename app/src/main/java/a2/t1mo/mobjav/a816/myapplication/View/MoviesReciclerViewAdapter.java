package a2.t1mo.mobjav.a816.myapplication.View;


import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 10/26/2016.
 */

public class MoviesReciclerViewAdapter extends RecyclerView.Adapter {

    private List<Pelicula> listaDePeliculas;
    private Context context;

    public MoviesReciclerViewAdapter(Context context, List<Pelicula> listaDePeliculas){
        this.listaDePeliculas = listaDePeliculas;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewDeLaCelda = inflater.inflate(R.layout.fragment_poster, parent, false);
        HolderPeliculas holderPeliculas = new HolderPeliculas(viewDeLaCelda);
        //listener jere
        return holderPeliculas;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        Pelicula unaPelicula = listaDePeliculas.get(position);
        HolderPeliculas holderPeliculas = (HolderPeliculas) holder;
        holderPeliculas.movieBinder(unaPelicula);
    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }


    private class HolderPeliculas extends RecyclerView.ViewHolder{

        private ImageView posterPelicula;

        public HolderPeliculas(View v){
            super(v);
            posterPelicula = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }
        public void movieBinder (Pelicula unaPelicula){

            posterPelicula.setImageResource(R.drawable.batman);
        }
    }
}
