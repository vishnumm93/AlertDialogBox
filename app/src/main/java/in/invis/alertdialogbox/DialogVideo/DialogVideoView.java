package in.invis.alertdialogbox.DialogVideo;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import in.invis.alertdialogbox.R;

public class DialogVideoView extends AppCompatActivity {
    Button alert;


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



         final Dialog dialog = new Dialog(DialogVideoView.this);
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
                Intent intent = new Intent(DialogVideoView.this, YoutubeVideoActivity.class);
                startActivity(intent);
               // final Dialog dialog = new Dialog(DialogVideoView.this);
               // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
              //  dialog.setContentView(R.layout.customdialogvideo);
              //  VideoView myvideo = (VideoView) dialog.findViewById(R.id.myvideo);
              //  myvideo.setVideoPath(tandc);
             //   myvideo.start();



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
