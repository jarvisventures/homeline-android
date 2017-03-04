package com.jarvisventures.homeline.subproject;

import com.jarvisventures.homeline.project.FindProjectItems;
import com.jarvisventures.homeline.project.Project;
import com.jarvisventures.homeline.project.ProjectView;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class SubprojectPresenterImpl implements SubprojectPresenter, FindSubProjects.OnFinishedListener {

    private SubprojectView projectView;
    private FindSubProjects findProjectItems;


    public SubprojectPresenterImpl(SubprojectView projectView, FindSubProjects findProjectItems) {
        this.projectView = projectView;
        this.findProjectItems = findProjectItems;
    }


    @Override
    public void onFinished(ArrayList<Subproject> items) {
        if (projectView != null && items != null) {
            if (items.size() != 0) {
                projectView.setItems(items);
                projectView.hideProgressBar();
                projectView.hideNoInventoryView();
            }
            else {
                projectView.showProgressBar();
                projectView.configureNoInventoryView();
                projectView.hideProgressBar();
            }
        }
    }

    @Override
    public void onResume() {
        if (projectView != null) {
            projectView.showProgressBar();
        }
        projectView.showProgressBar();
        findProjectItems.findItems(this, "inventory");
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onDestroy() {

    }
}
