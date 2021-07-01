package com.connect.svecw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;



public class ListClubs extends AppCompatActivity {


     EditText editname,editcm,editContact,uid;
     Button  btnchoose,btnadd,btnlist;
     TextView heading;
     ImageView imageView;

    public static  DBHelperClub dbHelperClub;
     final int REQUEST_CODE_GALLERY=999;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_club_details);
      init();
        dbHelperClub=new DBHelperClub(this, "ClubDB.sqlite" ,null ,2);
        dbHelperClub.queryData("CREATE TABLE IF NOT EXISTS CLUB_TABLE (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR,C_manager VARCHAR,contact VARCHAR,u_id VARCHAR,image BLOB)");

        btnchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        ListClubs.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    dbHelperClub.insertData(
                            editname.getText().toString().trim(),
                            editcm.getText().toString().trim(),
                            editContact.getText().toString().trim(),
                            uid.getText().toString().trim(),
                            imageViewToByte(imageView)

                );
                    Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                    editname.setText("");
                    editcm.setText("");
                    editContact.setText("");
                    uid.setText("");
                    imageView.setImageResource(R.drawable.acc);
                }
                catch (Exception e){

                    e.printStackTrace();
                }



            }
        });


        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListClubs.this,ClubList.class);
                startActivity(intent);

            }
        });
    }


    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }
            else{

                Toast.makeText(getApplicationContext(), "You don't have permission to access File location", Toast.LENGTH_SHORT).show();
            }
          return;

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE_GALLERY && resultCode==RESULT_OK && data !=null){

            Uri uri=data.getData();

            try {
                InputStream inputstream = getContentResolver().openInputStream(uri);

                Bitmap bitmap= BitmapFactory.decodeStream(inputstream);
                imageView.setImageBitmap(bitmap);
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void init(){
        editname=(EditText)findViewById(R.id.etname);
        editcm=(EditText)findViewById(R.id.etcm);
        editContact=(EditText)findViewById(R.id.etcmContact);
        uid=(EditText)findViewById(R.id.uniqueid);
        btnchoose=(Button)findViewById(R.id.btnchoose);
        btnadd=(Button)findViewById(R.id.btnUpdate);
        btnlist=(Button)findViewById(R.id.btnlist);
        imageView=(ImageView)findViewById(R.id.imageView);

        heading=(TextView)findViewById(R.id.Tv_gen_bill);
        Typeface typeFace2=Typeface.createFromAsset(getAssets(),"fonts/Raleway-ExtraBold.ttf");
        heading.setTypeface(typeFace2);


    }
}
