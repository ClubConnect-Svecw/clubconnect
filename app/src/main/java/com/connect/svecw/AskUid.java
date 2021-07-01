package com.connect.svecw;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class AskUid extends AppCompatActivity {
    Button submit;
    EditText ed1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_uid);

        submit=(Button)findViewById(R.id.sub1);
        ed1=(EditText)findViewById(R.id.a_uid);
    }
}
