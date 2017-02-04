package in.invis.alertdialogbox.DialogYoutube;

/**
 * Created by VishnuM on 8/19/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import in.invis.alertdialogbox.R;
import in.invis.alertdialogbox.Constant.Constant;


public class YoutubeFragment extends Fragment {
    // API キー

    // YouTubeID
    public Boolean flag = false;
    YouTubePlayer ytplayer;
    //ImageButton fullscreen;

   public  String VIDEO_ID;

    int catid;
    int vidpos = 0;
    public String[][] vids = {
            {"z7ZKNt761hs",
                    "Tew-UteDXEw",
                    "LIbX0vlbGbE",
                    "Y0Z85e8BcCg",
                    "ipbiNOXL0F4",
                    "mlVeHNOlhYY",
                    "d4O3hoppciM",
                    "C2ucLjEbKaA",
                    "FKy-UjcHipw"},
            {"FafuWdPIXDE", "YEBkC-DFEAk", "c7GP8f0rBjc", "LuYKBO_ViTA", "NktuFFC3i8Q", "YW27BRRk5YU", "lxuDPXgwxY0"},
            {"dU66mMLXY94", "u0MHZsnfpYI", "SycQbl_vHIo", "CfmjsZ2UhZg", "F1p8V9nfJ58", "pCIrcfym3lk"}
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.you_tube_api, container, false);


        Bundle bundle = this.getArguments();
        //VIDEO_ID = bundle.getString("Videoid");
        // VIDEO_ID = "DlINSoSeknE";

        catid = getArguments().getInt("vidcat");

        Log.d("vidcat", " -- " + catid);
        VIDEO_ID = vids[catid][vidpos];


        //fullscreen = (ImageButton) rootView.findViewById(R.id.fullscreen);
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();


        youTubePlayerFragment.initialize(Constant.API_KEY, new OnInitializedListener() {


            @Override
            public void onInitializationSuccess(Provider provider, final YouTubePlayer player, boolean wasRestored) {
                ytplayer = player;
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                    player.cueVideo(VIDEO_ID);
                    player.play();

                }
            }


            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return rootView;
    }


    public String getCurrentVideo() {

        return vids[catid][vidpos];
    }


    public void nextVideo() {

        if (vidpos < (vids[catid].length - 1)) {
            vidpos = vidpos + 1;
            Log.d("vidpos", " -- " + vidpos);

            loadVideo(vids[catid][vidpos]);
        }
    }

    public void previousVideo() {
        if (vidpos > 0) {
            vidpos = vidpos - 1;
            Log.d("vidpos", " -- " + vidpos);
            loadVideo(vids[catid][vidpos]);
        }
    }

    public void changetofullscreen()
    {

        ytplayer.setFullscreen(true);
        flag=true;
       /* YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(Constant.API_KEY, new OnInitializedListener() {


            @Override
            public void onInitializationSuccess(Provider provider, final YouTubePlayer player, boolean wasRestored) {
                ytplayer = player;
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                    player.loadVideo(VIDEO_ID);
                    player.setFullscreen(true);
                    player.play();
                    flag = true;

                    }


            }


            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });  */

    }

    public boolean getFScreenStatus() {
        return flag;
    }

    public void changeFullScreen(Boolean status) {
        ytplayer.setFullscreen(status);
    }

    public String getVideoId(){
        return VIDEO_ID;
    }





    public void loadVideo(final String videoid) {
        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(Constant.API_KEY, new OnInitializedListener() {


            @Override
            public void onInitializationSuccess(Provider provider, final YouTubePlayer player, boolean wasRestored) {
                ytplayer = player;
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
                    player.loadVideo(videoid);
                    player.play();


                }
            }


            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

    }




}




