package com.connect.svecw;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Adminhome  extends AppCompatActivity {
    ImageButton img1,img2;
    TextView tv1,tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);
        tv1=(TextView)findViewById(R.id.textView15);
        Typeface typeFace1=Typeface.createFromAsset(getAssets(),"fonts/Raleway-ExtraBold.ttf");
        tv1.setTypeface(typeFace1);

        tv2=(TextView)findViewById(R.id.tv6);
        Typeface typeFace2=Typeface.createFromAsset(getAssets(),"fonts/Raleway-ExtraBold.ttf");
        tv2.setTypeface(typeFace2);

        img1=(ImageButton)findViewById(R.id.add_club);
        img2=(ImageButton)findViewById(R.id.logout);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go= new Intent(Adminhome.this,ListClubs.class);
                startActivity(go);

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent go2 = new Intent(Adminhome.this,Adminlogin.class);
                //startActivity(go2);
                Toast.makeText(Adminhome.this,"User loggedOut!!",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
