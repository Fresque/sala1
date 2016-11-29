package a2.t1mo.mobjav.a816.myapplication.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import a2.t1mo.mobjav.a816.myapplication.R;

/**
 * Created by marti on 11/24/2016.
 */

public class VideoFragment extends Fragment implements YouTubePlayer.OnInitializedListener {

    private static final String API_KEY = "AIzaSyDIFpn-ZFwiz9MDx0c6T0HnejlxE3N-zH8";
    YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String key;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        Bundle bundle = getArguments();
        key = bundle.getString("keyVideo");

        View view = inflater.inflate(R.layout.fragment_video, container, false);

        youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();

        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.acaVaElVideo,youTubePlayerSupportFragment);
        fragmentTransaction.commit();

        youTubePlayerSupportFragment.initialize(API_KEY, this);


        return view;
    }

    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        youTubePlayer.loadVideo(key);
        youTubePlayer.cueVideo(key);
        youTubePlayer.setFullscreen(false);
        youTubePlayer.play();
    }

    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getActivity(), "Oh no! ", Toast.LENGTH_LONG).show();
    }


}
