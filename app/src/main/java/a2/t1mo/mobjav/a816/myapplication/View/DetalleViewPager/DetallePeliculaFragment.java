package a2.t1mo.mobjav.a816.myapplication.View.DetalleViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import a2.t1mo.mobjav.a816.myapplication.Controller.PeliculaController;
import a2.t1mo.mobjav.a816.myapplication.Model.Pelicula;
import a2.t1mo.mobjav.a816.myapplication.Model.PeliculaListContainer;
import a2.t1mo.mobjav.a816.myapplication.R;
import a2.t1mo.mobjav.a816.myapplication.Util.ResultListener;
import a2.t1mo.mobjav.a816.myapplication.View.RecyclerViewPeliculas.AdaptadorDePeliculas;
import a2.t1mo.mobjav.a816.myapplication.View.RecyclerViewPeliculas.RecyclerHolderFragment;


/**
 * Created by marti on 10/27/2016.
 */

public class DetallePeliculaFragment extends Fragment{



    Pelicula pelicula;

    RecyclerView recyclerView;
    AdaptadorDePeliculas adaptadorDePeliculas;

    List<Pelicula>recoList;

    IrAVideo interfaceVideo;
    FloatingActionButton floatingActionButton;

    public static DetallePeliculaFragment dameUnFragment(Pelicula pelicula){

        //CREAR FRAGMENT
        //CREAR BUNDLE Y PONERLE ADENTRO LA INFO
        //ASOCIAR BUNDLE AL FRAGMENT

        DetallePeliculaFragment detallePeliculaFragment = new DetallePeliculaFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", pelicula.getId());
        detallePeliculaFragment.setArguments(bundle);

        return detallePeliculaFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);


        //RECIBIR EL BUNLE
        Bundle bundle = getArguments();
        final String id = bundle.getString("id");
        String url = "https://api.themoviedb.org/3/movie/"+ id +"?api_key=01a81d06ce53d8e3ef9e380989ea4f24&append_to_response=videos,reviews,credits";



        final TextView textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
        final TextView textViewReleaseDate = (TextView) view.findViewById(R.id.textViewReleaseDate);
        final TextView textViewSinopsis = (TextView) view.findViewById(R.id.textViewSinopsis);
        final TextView textViewRating = (TextView) view.findViewById(R.id.textViewRating);
        final TextView textViewRevenue = (TextView) view.findViewById(R.id.textViewRevenue);
        final TextView textViewRuntime = (TextView) view.findViewById(R.id.textViewRuntime);
        final ImageView imageViewBackdrop = (ImageView) view.findViewById(R.id.imagenFondoDetalle);
        final ImageView imageViewMiniPoster = (ImageView) view.findViewById(R.id.imageViewMiniPoster);


        final PeliculaController peliculaController = new PeliculaController();
        peliculaController.obtenerPelicula(getActivity(), new ResultListener<Pelicula>() {
            @Override
            public void finish(Pelicula resultado) {
                pelicula = resultado;


                Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500/" + pelicula.getBackdrop_path()).into(imageViewBackdrop);
                Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500/" + pelicula.getPoster_path()).into(imageViewMiniPoster);
                textViewTitulo.setText(pelicula.getTitle());
                textViewReleaseDate.setText(pelicula.getRelease_date());
                textViewSinopsis.setText(pelicula.getOverview());
                textViewRating.setText("Rating: "+pelicula.getVote_average());
                textViewRevenue.setText("Revenue: "+pelicula.getRevenue());
                textViewRuntime.setText("Runtime: "+pelicula.getRuntime());



                String urlReco = "https://api.themoviedb.org/3/movie/"+id+"/similar?api_key=01a81d06ce53d8e3ef9e380989ea4f24&language=en-US";

                recoList = new ArrayList<>();
                recyclerView = (RecyclerView) view.findViewById(R.id.recyclerSugerencias);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                adaptadorDePeliculas = new AdaptadorDePeliculas(getActivity());
                adaptadorDePeliculas.setListaDePeliculas(recoList);

                recyclerView.setAdapter(adaptadorDePeliculas);

                PeliculaController peliculaController =  new PeliculaController();
                peliculaController.obtenerListaPeliculas(getContext(), new ResultListener<PeliculaListContainer>() {
                    @Override
                    public void finish(PeliculaListContainer resultado) {
                        recoList = resultado.getResults();
                        adaptadorDePeliculas.setListaDePeliculas(recoList);
                        adaptadorDePeliculas.notifyDataSetChanged();
                    }
                },urlReco);
            }
        },url);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceVideo.llamarVideo(pelicula.getKey(0));
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        interfaceVideo = (IrAVideo)activity;
    }

    public interface IrAVideo{
        public void llamarVideo (String keyVideo);

    }

    /*private static final String API_KEY = "AIzaSyDIFpn-ZFwiz9MDx0c6T0HnejlxE3N-zH8";
    YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    fragmentManager = getChildFragmentManager();
    fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.acaVaElVideo, youTubePlayerSupportFragment);
    fragmentTransaction.commit();
    youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
    youTubePlayerSupportFragment.initialize(API_KEY, DetallePeliculaFragment.this);
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        youTubePlayer.loadVideo(pelicula.getKey(0));
        youTubePlayer.cueVideo(pelicula.getKey(0));
        youTubePlayer.play();
    }
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getActivity(), "Oh no! ",Toast.LENGTH_LONG).show();
    }*/

}