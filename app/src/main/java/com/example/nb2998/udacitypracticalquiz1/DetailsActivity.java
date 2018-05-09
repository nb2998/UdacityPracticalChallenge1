package com.example.nb2998.udacitypracticalquiz1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import static com.example.nb2998.udacitypracticalquiz1.MainActivity.MY_PREFS;

public class DetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView usernameDetails, userEmailDetails, userDescDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = findViewById(R.id.tool_bar_details);
        usernameDetails = findViewById(R.id.username_details);
        userEmailDetails = findViewById(R.id.user_email_details);
        userDescDetails = findViewById(R.id.user_description_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SharedPreferences sp = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        if (sp != null) {
            usernameDetails.setText(sp.getString(getResources().getString(R.string.username), getResources().getString(R.string.demo_user_name)));
            userEmailDetails.setText(sp.getString(getResources().getString(R.string.email), getResources().getString(R.string.demo_email)));
            userDescDetails.setText(sp.getString(getResources().getString(R.string.user_description), getResources().getString(R.string.demo_email)));
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
