package com.connect.svecw;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adminlogin extends AppCompatActivity {
    Button login;
    EditText un,pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        login = (Button) findViewById(R.id.login1);
        un = (EditText) findViewById(R.id.un);
        pwd = (EditText) findViewById(R.id.pwd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = un.getText().toString();
                String password = pwd.getText().toString();
                String s1 = "Nagajyothi";
                String s2 = "123456";
                if(s1.equals(username)&&s2.equals(password)){
                    Intent go = new Intent(Adminlogin.this, Adminhome.class);
                    startActivity(go);

                }
                else {
                    un.setError("No such Username");
                    pwd.setError("No such Password");
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
                un.setText("");
                pwd.setText("");
            }
        });
    }
}
