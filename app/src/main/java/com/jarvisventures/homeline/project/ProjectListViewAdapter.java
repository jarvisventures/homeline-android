package com.jarvisventures.homeline.project;

/**
 * Created by klaytonerekson on 3/3/17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jarvisventures.homeline.R;
import java.util.ArrayList;

/**
 * Created by klaytonerekson on 2/9/17.
 */

public class ProjectListViewAdapter extends BaseAdapter implements View.OnClickListener, Filterable {

    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Project tempValues=null;
    int i=0;
    private InventoryFilter inventoryFilter;
    private ArrayList<Project> itemList;
    private ArrayList<Project> filteredList;

    /*************  CustomAdapter Constructor *****************/
    public ProjectListViewAdapter(Activity a, ArrayList d,Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;
        this.itemList = d;
        this.filteredList = d;
        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        getFilter();

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return filteredList.size();
    }

    public Project getItem(int position) {
        return filteredList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView title;
        public TextView description;
        public ImageView image;
        public ProgressBar progressBar;

    }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.project_row, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.title = (TextView) vi.findViewById(R.id.title);
            holder.image=(ImageView) vi.findViewById(R.id.image);
            holder.progressBar = (ProgressBar) vi.findViewById(R.id.projectProgress);
            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.title.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( Project ) filteredList.get( position );

            /************  Set Model values in Holder elements ***********/

            holder.title.setText( tempValues.getName() );
            holder.title.setTypeface(Typeface.SERIF);
//            holder.description.setText( tempValues.getDescription() );
//            holder.description.setTypeface(Typeface.SERIF);
//            Picasso.with(this.activity).load(tempValues.getImage()).placeholder(R.drawable.placeholder).into(holder.image);
//            holder.progressBar.setVisibility(View.GONE);
            /******** Set Item Click Listner for LayoutInflater for each row *******/

            vi.setOnClickListener(new OnItemClickListener( position ));
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

            HomeActivity sct = (HomeActivity) activity;
            sct.onItemClick(mPosition);

        }
    }

    @Override
    public Filter getFilter() {

        if (inventoryFilter == null) {
            inventoryFilter = new InventoryFilter();
        }

        return inventoryFilter;
    }




    // *********** CUSTOM FILTER ***************** //
    /**
     * Custom filter for friend list
     * Filter content in friend list according to the search text
     */
    private class InventoryFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                ArrayList<Project> tempList = new ArrayList<Project>();

                // search content in friend list
                for (Project item : itemList) {
                    if (item.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(item);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = itemList.size();
                filterResults.values = itemList;
            }

            return filterResults;
        }

        /**
         * Notify about filtered list to ui
         * @param constraint text
         * @param results filtered result
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<Project>) results.values;
            notifyDataSetChanged();
        }
    }


}

