package supcom.projetdevmob.com.firebasetest123;

/**
 * Created by pc on 12/10/2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 12/10/2016.
 */
public class ListAdapter extends BaseAdapter {

    ArrayList<university> arrayList ;
    Context context ;

    public ListAdapter(ArrayList<university> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }




    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView =  LayoutInflater.from(context).inflate(R.layout.adapter,parent,false);

        }
        TextView nomv= (TextView) convertView.findViewById(R.id.univname);
        TextView prenomv= (TextView) convertView.findViewById(R.id.univspec);

        university u = (university) getItem(position) ;

        nomv.setText(u.getName());
        prenomv.setText(u.getSpeciality()) ;



        return convertView  ;
    }



}

