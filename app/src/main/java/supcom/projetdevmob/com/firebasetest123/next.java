package supcom.projetdevmob.com.firebasetest123;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class next extends AppCompatActivity {
TextView mytext ;
    ListView listView ;
    ListAdapter listAdapter ;
    ArrayList<university> arrayList;
    private DatabaseReference databaseReference ;
    int num ;

    ProgressDialog  progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        databaseReference = FirebaseDatabase.getInstance().getReference() ;

        listView=(ListView)findViewById(R.id.listview);
        arrayList = new ArrayList<university>() ;



            progressDialog.setMessage("Loading");
            progressDialog.show();
        databaseReference.child("stats").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                stats s= dataSnapshot.getValue(stats.class);
                num=s.getNum_univ();
                Toast.makeText(getApplicationContext(),Integer.toString(s.getNum_univ()),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
       // Toast.makeText(getApplicationContext(),Integer.toString(num),Toast.LENGTH_SHORT).show();
        for(int i=0 ; i<num;i++) {

            databaseReference.child("universities/"+Integer.toString(i)).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    university u = dataSnapshot.getValue(university.class);
                    arrayList.add(u) ;

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });






        }
        progressDialog.dismiss();


        listAdapter= new ListAdapter(arrayList,getApplicationContext());
        listView.setAdapter(listAdapter);










    }
}
