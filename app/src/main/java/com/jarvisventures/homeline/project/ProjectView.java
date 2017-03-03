package com.jarvisventures.homeline.project;

import java.util.ArrayList;

/**
 * Created by klaytonerekson on 3/3/17.
 */

public interface ProjectView {

    void showProgressBar();

    void hideProgressBar();

    void configureNoInventoryView();

    void hideNoInventoryView();

    void setItems(ArrayList<Project> items);

    void onItemClick(int position);

    void showMessage(String message);
}
