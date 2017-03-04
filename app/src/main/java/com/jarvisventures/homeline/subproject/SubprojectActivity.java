package com.jarvisventures.homeline.subproject;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvisventures.homeline.R;
import com.jarvisventures.homeline.project.CurrentProject;
import com.jarvisventures.homeline.project.FindProjectItemsImpl;
import com.jarvisventures.homeline.project.HomeActivity;
import com.jarvisventures.homeline.project.Project;
import com.jarvisventures.homeline.project.ProjectListViewAdapter;
import com.jarvisventures.homeline.project.ProjectPresenter;
import com.jarvisventures.homeline.project.ProjectPresenterImpl;
import com.jarvisventures.homeline.subproject.subprojectdetail.CurrentSubProjects;
import com.jarvisventures.homeline.subproject.subprojectdetail.SubprojectDetailActivity;
import com.vstechlab.easyfonts.EasyFonts;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SubprojectActivity extends AppCompatActivity implements SubprojectView {

    private ListView subprojectlistView;
    private TextView subprojectheader;
    private TextView projectTitle;
    private TextView projectBudget;
    private TextView projectCompletionDate;
    private Integer progressStatus;
    private Integer progressMax;

    private ProgressBar progressBar;
    private SubprojectPresenter presenter;
    private TextView toolbarTitle;
    private ImageView noInventoryImage;
    private ImageView noInventoryMask;
    private TextView noInventoryText;
    public SearchView searchView;
    SubprojectListViewAdapater adapter = null;
    public SubprojectActivity CustomListView = null;
    public  ArrayList<Subproject> customListArr = new ArrayList<Subproject>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subproject);

        subprojectlistView = (ListView) findViewById(R.id.subprojectList);
        subprojectheader = (TextView) findViewById(R.id.subprojectHeader);
        subprojectheader.setTypeface(EasyFonts.caviarDreams(this));

        projectTitle = (TextView) findViewById(R.id.projectName);
        projectTitle.setText(CurrentProject.getCurrentProject().getName());
        projectTitle.setTypeface(EasyFonts.caviarDreamsBold(this));

        projectBudget = (TextView) findViewById(R.id.projectBudgetHeader);
        projectBudget.setText("$1,000");
        projectBudget.setTypeface(EasyFonts.caviarDreamsBold(this));

        projectCompletionDate = (TextView) findViewById(R.id.projectCompletionDate);
        String[] s = CurrentProject.getCurrentProject().getEndDate().split("T");
        projectCompletionDate.setText("PROJECTED COMPLETION DATE: " + s[0]);

        presenter = new SubprojectPresenterImpl(this, new FindSubProjectsImpl());
    }

    @Override public void onResume() {
        super.onResume();
        presenter.onResume();

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void configureNoInventoryView() {

    }

    @Override
    public void hideNoInventoryView() {

    }

    @Override
    public void setItems(ArrayList<Subproject> items) {
        if (items.size() == 0) {
            // Show Message about no inventory

            showProgressBar();
        }
        else {
            Resources res = getResources();
            showProgressBar();
            customListArr = items;
            adapter = new SubprojectListViewAdapater(this, items, res);
            subprojectlistView.setAdapter(adapter);

        }

    }

    @Override
    public void onItemClick(int position) {
        CurrentSubProjects.setCurrentSubProject(customListArr.get(position));
        startActivity(new Intent(this, SubprojectDetailActivity.class));
    }

    @Override
    public void showMessage(String message) {

    }
}
