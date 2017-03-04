package com.jarvisventures.homeline.subproject;

import com.jarvisventures.homeline.project.Project;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public interface SubprojectView {

    void showProgressBar();

    void hideProgressBar();

    void configureNoInventoryView();

    void hideNoInventoryView();

    void setItems(ArrayList<Subproject> items);

    void onItemClick(int position);

    void showMessage(String message);
}
