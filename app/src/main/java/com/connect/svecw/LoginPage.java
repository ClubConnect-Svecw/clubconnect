package com.connect.svecw;

import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

//import static com.ruuha.bmscms.R.id.pwd;
//import static com.ruuha.bmscms.R.id.un;


public class LoginPage extends AppCompatActivity{

    Button login;
    EditText pwd,un;
   private static int RC_SIGN_IN=0;
    private static String TAG="LOGIN_PAGE";
  //  private GoogleApiClient mGoogleApiClient;
  private FirebaseAuth mAuth;
  //  private FirebaseAuth.AuthStateListener mAuthListener;

    SQLiteDBHelper helper=new SQLiteDBHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);





       /* mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    Toast.makeText(LoginPage.this, "User Logged In!!", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(LoginPage.this, "User Logged out!!", Toast.LENGTH_SHORT).show();
                }
            }
        };*/

       /* GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient=new  GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });*/




        login = (Button) findViewById(R.id.login1);
        un = (EditText) findViewById(R.id.un);
        pwd = (EditText) findViewById(R.id.pwd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = un.getText().toString();
                String password = pwd.getText().toString();

                String passw =helper.searchPass(username);
                if(passw.equals(password)){
                   // Intent go = new Intent(LoginPage.this, HomePage.class);
                   // startActivity(go);
                   // mAuth=FirebaseAuth.getInstance();
                  //  if(mAuth.getCurrentUser()!=null){
                    Intent go = new Intent(LoginPage.this, HomePage.class);
                    startActivity(go);

                    }
                    /*else{
                        startActivityForResult(AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setProviders(
                                        AuthUI.EMAIL_PROVIDER
                                         )
                                .build(),RC_SIGN_IN);

                    }*/
                else
                {
                     un.setError("No such Username");
                    pwd.setError("No such Password");
                    Toast.makeText(LoginPage.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
                un.setText("");
                pwd.setText("");
                // validateUserTask task = new validateUserTask();
               // task.execute(new String[]{username, password});


            }
        });
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
              if(resultCode==RESULT_OK){
                  Intent go = new Intent(LoginPage.this,HomePage.class);
                  startActivity(go);

              }
             else{

                  Toast.makeText(this, "Not authenticated", Toast.LENGTH_SHORT).show();
              }

        }*/




   // @Override
   /* public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Connection Failed!!", Toast.LENGTH_SHORT).show();
    }*/



  /*  class validateUserTask extends AsyncTask<String, Void, String> {
         SQLiteDatabase db;

       @Override
        protected String doInBackground(String... params) {
            String u= params[0];
           String p=params[1];
           db=openOrCreateDatabase("Main", SQLiteDatabase.CREATE_IF_NECESSARY,null);
            Cursor c = db.rawQuery("SELECT * FROM users WHERE username = '"+u.trim()+"' and password='"+p.trim()+"'", null);
           if(c.getCount()==0){

               Toast.makeText(LoginPage.this,"Valid user",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(LoginPage.this,HomePage.class);
               startActivity(i);
           }
            else  {
                Toast.makeText(LoginPage.this,"Not Valid user", Toast.LENGTH_SHORT).show();

           }
            c.close();
           return null;
       }
   }*/




    }

