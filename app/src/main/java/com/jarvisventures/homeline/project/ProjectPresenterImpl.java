package com.jarvisventures.homeline.project;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class ProjectPresenterImpl implements ProjectPresenter, FindProjectItems.OnFinishedListener {

    private ProjectView projectView;
    private FindProjectItems findProjectItems;


    public ProjectPresenterImpl(ProjectView projectView, FindProjectItems findProjectItems) {
        this.projectView = projectView;
        this.findProjectItems = findProjectItems;
    }

    @Override
    public void onFinished(ArrayList<Project> items) {
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
        projectView = null;
    }
}
