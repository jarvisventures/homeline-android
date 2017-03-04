package com.jarvisventures.homeline.subproject;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jarvisventures.homeline.R;
import com.jarvisventures.homeline.project.HomeActivity;
import com.jarvisventures.homeline.project.Project;
import com.squareup.picasso.Picasso;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class SubprojectListViewAdapater extends BaseAdapter implements View.OnClickListener {
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Subproject tempValues=null;
    int i=0;

    private ArrayList<Subproject> itemList;
    private ArrayList<Subproject> filteredList;

    /*************  CustomAdapter Constructor *****************/
    public SubprojectListViewAdapater(Activity a, ArrayList d,Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;
        this.itemList = d;
        this.filteredList = d;
        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return filteredList.size();
    }

    public Subproject getItem(int position) {
        return filteredList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView title;
        public TextView budget;
        public ImageView image;
        public ProgressBar progressBar;

    }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        SubprojectListViewAdapater.ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.subproject_row, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new SubprojectListViewAdapater.ViewHolder();
            holder.title = (TextView) vi.findViewById(R.id.subprojectTitle);
            holder.budget = (TextView) vi.findViewById(R.id.subprojectBudget);
//            holder.image=(ImageView) vi.findViewById(R.id.subprojectImage);
            holder.progressBar = (ProgressBar) vi.findViewById(R.id.subprojectProgress);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(SubprojectListViewAdapater.ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.title.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( Subproject ) filteredList.get( position );

            /************  Set Model values in Holder elements ***********/

            holder.title.setText( tempValues.getName() );
            holder.title.setTypeface(EasyFonts.caviarDreams(activity.getApplicationContext()));
            holder.budget.setText("$1,000");
            holder.budget.setTypeface(EasyFonts.caviarDreams(activity.getApplicationContext()));
//            holder.description.setText( tempValues.getDescription() );
//            holder.description.setTypeface(Typeface.SERIF);
//            Picasso.with(this.activity).load("https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb").into(holder.image);
//            holder.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            holder.progressBar.setVisibility(View.GONE);
            /******** Set Item Click Listner for LayoutInflater for each row *******/

            vi.setOnClickListener(new SubprojectListViewAdapater.OnItemClickListener( position ));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener{
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {

            /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
            System.out.println(mPosition);

            SubprojectActivity sct = (SubprojectActivity) activity;
            sct.onItemClick(mPosition);

        }
    }

}
