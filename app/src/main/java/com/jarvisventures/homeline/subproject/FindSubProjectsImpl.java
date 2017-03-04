package com.jarvisventures.homeline.subproject;

import com.jarvisventures.homeline.project.CurrentProject;
import com.jarvisventures.homeline.project.FindProjectItems;
import com.jarvisventures.homeline.project.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public class FindSubProjectsImpl implements FindSubProjects {

    ArrayList<Subproject> list = new ArrayList<>();

    @Override
    public void findItems(FindSubProjects.OnFinishedListener listener, String listName) {
        list.clear();
        getProductsFromApi(listener);
    }

    private ArrayList<Subproject> createArrayList() {
        return new ArrayList<Subproject>(CurrentProject.getCurrentProject().getSubprojects());
    }

    private void getProductsFromApi(final FindSubProjects.OnFinishedListener listener) {

        listener.onFinished(createArrayList());

    }
}
