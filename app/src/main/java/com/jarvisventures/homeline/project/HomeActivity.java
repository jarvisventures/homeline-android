package com.jarvisventures.homeline.project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jarvisventures.homeline.R;
import com.jarvisventures.homeline.account.AccountActivity;
import com.jarvisventures.homeline.subproject.Subproject;
import com.jarvisventures.homeline.subproject.SubprojectActivity;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements ProjectView, View.OnClickListener {

    private ListView listView;
    private TextView projectHeader;
    private Button accountButton;

    private ProgressBar progressBar;
    private ProjectPresenter presenter;
    private TextView toolbarTitle;
    private ImageView noInventoryImage;
    private ImageView noInventoryMask;
    private TextView noInventoryText;
    public SearchView searchView;
    ProjectListViewAdapter adapter = null;
    public  HomeActivity CustomListView = null;
    public  ArrayList<Project> customListArr = new ArrayList<Project>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = (ListView) findViewById(R.id.projectList);
        progressBar = (ProgressBar) findViewById(R.id.projectProgress);
        presenter = new ProjectPresenterImpl(this, new FindProjectItemsImpl());
        projectHeader = (TextView) findViewById(R.id.projectHeader);
        projectHeader.setTypeface(EasyFonts.caviarDreams(this));
        accountButton = (Button) findViewById(R.id.accountButton);
        accountButton.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgressBar() {
//        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
//        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void configureNoInventoryView() {

    }

    @Override
    public void hideNoInventoryView() {

    }

    @Override public void onResume() {
        super.onResume();
        presenter.onResume();

    }

    @Override
    public void setItems(ArrayList<Project> items) {

        if (items.size() == 0) {
            // Show Message about no inventory

            showProgressBar();
        }
        else {
            Resources res = getResources();
            showProgressBar();
            customListArr = items;
            adapter = new ProjectListViewAdapter(this, items, res);
            listView.setAdapter(adapter);

        }

    }

    @Override
    public void showMessage(String message) {

    }

    public void onItemClick(int postion){

        startActivity(new Intent(this, SubprojectActivity.class));
        CurrentProject.setCurrentProject(customListArr.get(postion));
//        CurrentSubProjects.setList(new ArrayList<>(customListArr.get(postion).getSubprojects()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.accountButton:
                startActivity(new Intent(this, AccountActivity.class));
                break;
        }
    }
}
