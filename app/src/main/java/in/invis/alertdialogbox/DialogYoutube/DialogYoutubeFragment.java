package in.invis.alertdialogbox.DialogYoutube;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import in.invis.alertdialogbox.R;



public class DialogYoutubeFragment extends FragmentActivity {
    Button alert;
    YoutubeFragment fragment;
    FrameLayout container1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alert = (Button)findViewById(R.id.alert);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdialogbox("Trivandrum","https://www.keralatourism.org/expressionappfiles/videos/1.mp4");
            }
        });
    }

    public void showdialogbox(final String strPlaceName,final String tandc){



        final Dialog dialog = new Dialog(DialogYoutubeFragment.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_detail_dialog);
        //final Dialog dialog1 = new Dialog(StreetviewActivity.this);


        // set the custom dialog components - text, image and button
        TextView txtPlaceName = (TextView) dialog.findViewById(R.id.txtPlaceName);
        txtPlaceName.setText(strPlaceName);
        dialog.show();

        final Button btnMore= (Button) dialog.findViewById(R.id.btnMore);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                final Dialog dialog = new Dialog(DialogYoutubeFragment.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.customyoutubefragment);
                container1 = (FrameLayout) dialog.findViewById(R.id.container1);

                //FragmentTransaction ft = ((FragmentActivity) dialog.getOwnerActivity()).getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putInt("vidcat",0);
                fragment = new YoutubeFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container1, fragment)
                        .commit();

                dialog.show();


            }


        });

        ImageButton imgBtnDialogClose= (ImageButton) dialog.findViewById(R.id.imgBtnDialogClose);
        imgBtnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
