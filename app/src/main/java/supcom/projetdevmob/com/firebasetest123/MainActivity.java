package supcom.projetdevmob.com.firebasetest123;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog ;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText email , password ;
    private Button signup, login ;
    private TextView name;
    private DatabaseReference databaseReference ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog=new ProgressDialog(this);
            mAuth = FirebaseAuth.getInstance();
            databaseReference = FirebaseDatabase.getInstance().getReference() ;



        email = (EditText) findViewById(R.id.editemail);
        password  = (EditText)findViewById(R.id.passwordedit);
        signup = (Button)findViewById(R.id.signupbutton);
        login = (Button)findViewById(R.id.loginbutton);
        name = (TextView)findViewById(R.id.name) ;




        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }

            }
        };


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Creating account ...");
                progressDialog.show();
                createAccount(email.getText().toString(),password.getText().toString());

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(email.getText().toString(),password.getText().toString());


            }
        });



    }



    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);



        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                        Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_SHORT).show();
                        progressDialog.hide();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(), "failed",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }
    private void signIn(String email, final String password) {
        Log.d(TAG, "signIn:" + email);

        progressDialog.setMessage("Logging in ...");
        progressDialog.show();
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        FirebaseUser user = mAuth.getCurrentUser();
                        Informations informations = new Informations(password,"IMED","Aouidene") ;

                        Intent i = new Intent(getApplicationContext(),next.class);

                        startActivity(i);


                        /*university u1 = new university(0,"supcom","telecom","hhhhhh","jjjjj");
                        university u2 = new university(1,"supcom","telecom","hhhhhh","jjjjj");
                        university u3 = new university(2,"supcom","telecom","hhhhhh","jjjjj");
                        university u4 = new university(3,"supcom","telecom","hhhhhh","jjjjj");
                        university u5 = new university(4,"supcom","telecom","hhhhhh","jjjjj");
                        university u6 = new university(5,"supcom","telecom","hhhhhh","jjjjj");
                        university u7 = new university(6,"supcom","telecom","hhhhhh","jjjjj");
                        university u8 = new university(7,"supcom","telecom","hhhhhh","jjjjj");
                        university u9 = new university(8,"supcom","telecom","hhhhhh","jjjjj");
                        university u10 = new university(9,"supcom","telecom","hhhhhh","jjjjj");

                        databaseReference.child("universities/"+u1.getid()).setValue(u1) ;
                        databaseReference.child("universities/"+u2.getid()).setValue(u2) ;
                        databaseReference.child("universities/"+u3.getid()).setValue(u3) ;
                        databaseReference.child("universities/"+u4.getid()).setValue(u4) ;
                        databaseReference.child("universities/"+u5.getid()).setValue(u5) ;
                        databaseReference.child("universities/"+u6.getid()).setValue(u6) ;
                        databaseReference.child("universities/"+u7.getid()).setValue(u7) ;
                        databaseReference.child("universities/"+u8.getid()).setValue(u8) ;
                        databaseReference.child("universities/"+u9.getid()).setValue(u9) ;
                        databaseReference.child("universities/"+u10.getid()).setValue(u10) ;
*/


                        databaseReference.child("users/"+user.getUid()).setValue(informations) ;



                        name.setText(mAuth.getCurrentUser().getEmail());
                        progressDialog.hide();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(getApplicationContext(), ":( ! ",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            name.setText("ahah");
                        }

                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }


    private void updateUI(FirebaseUser user) {

        if (user != null) {
            name.setText(user.getEmail());


            findViewById(R.id.signupbutton).setVisibility(View.GONE);
            findViewById(R.id.passwordedit).setVisibility(View.GONE);
            findViewById(R.id.loginbutton).setVisibility(View.VISIBLE);
        }
    }



    public void resetPassword(){
        //setting connexion parameter


    }


}
