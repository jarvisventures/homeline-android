package com.jarvisventures.homeline.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jarvisventures.homeline.R;
import com.jarvisventures.homeline.login.LoginActivity;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        logout = (Button) findViewById(R.id.logoutbutton);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutbutton:
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
