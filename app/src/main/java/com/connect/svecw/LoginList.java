package com.connect.svecw;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginList extends AppCompatActivity {
    Button adlogin;
    Button uslogin;
   // Button stlogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_list);
        adlogin = (Button) findViewById(R.id.alogin);
        uslogin = (Button) findViewById(R.id.ulogin);
       // stlogin = (Button) findViewById(R.id.slogin);
        uslogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(LoginList.this,LoginPage.class);
                startActivity(go);
            }
        });
       /* cllogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go2 = new Intent(LoginList.this,LoginPage.class);
                startActivity(go2);
            }
        });*/
        adlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go3 = new Intent(LoginList.this,Adminlogin.class);
                startActivity(go3);
            }
        });
    }
}
