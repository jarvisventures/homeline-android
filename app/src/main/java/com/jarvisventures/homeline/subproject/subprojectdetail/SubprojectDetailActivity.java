package com.jarvisventures.homeline.subproject.subprojectdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.jarvisventures.homeline.R;
import com.jarvisventures.homeline.project.CurrentProject;

public class SubprojectDetailActivity extends AppCompatActivity {


    ListView activitiesList;
    TextView subprojectName;
    TextView subprojectBudget;
    TextView projectname;
    TextView completionDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subproject_detail);

        activitiesList = (ListView) findViewById(R.id.activitiesList);

        subprojectName = (TextView) findViewById(R.id.subprojectName);
        subprojectName.setText(CurrentSubProjects.currentSubProject.getName());

        subprojectBudget = (TextView) findViewById(R.id.subprojectBudget);

        projectname = (TextView) findViewById(R.id.projectName);
        projectname.setText(CurrentProject.getCurrentProject().getName());

        completionDate = (TextView) findViewById(R.id.subprojectCompletionDate);
        String[] s = CurrentProject.getCurrentProject().getEndDate().split("T");
        completionDate.setText(s[0]);





    }


}
