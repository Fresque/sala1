package a2.t1mo.mobjav.a816.myapplication.View.RecyclerViewPeliculas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 11/17/2016.
 */

public class AdaptadorDePeliculas extends RecyclerView.Adapter implements View.OnClickListener{

    private List<Pelicula> listaDePeliculas;
    private Context context;
    private View.OnClickListener listener;

    public AdaptadorDePeliculas(Context context){
        this.context = context;
    }

    public void setListaDePeliculas(List<Pelicula> listaDePeliculas) {
        this.listaDePeliculas = listaDePeliculas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewDeLaCelda = inflater.inflate(R.layout.layout_celda_poster, parent, false);
        HolderPeliculas holderPeliculas = new HolderPeliculas(viewDeLaCelda);
        viewDeLaCelda.setOnClickListener(this);
        return holderPeliculas;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        Pelicula unaPelicula = listaDePeliculas.get(position);
        HolderPeliculas holderPeliculas = (HolderPeliculas) holder;
        holderPeliculas.movieBinder(unaPelicula);
    }

    public Pelicula devolverPelicula(int posicion){
        return listaDePeliculas.get(posicion);
    }

    //Setea el listener
    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    //Seteaa tambien el listener
    public void onClick(View v){
        listener.onClick(v);
    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }


    //HOLDER
    private class HolderPeliculas extends RecyclerView.ViewHolder{

        private ImageView posterPelicula;

        public HolderPeliculas(View v){
            super(v);
            posterPelicula = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }

        public void movieBinder (Pelicula unaPelicula){
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + unaPelicula.getPoster_path()).into(posterPelicula);
        }
    }
}
