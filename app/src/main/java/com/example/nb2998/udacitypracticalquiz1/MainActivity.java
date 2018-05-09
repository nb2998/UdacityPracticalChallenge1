package com.example.nb2998.udacitypracticalquiz1;

import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREFS = "Shared_Pref";
    Toolbar toolbar;
    EditText editTextUserName, editTextUserEmail, editTextUserDesc;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tool_bar);
        editTextUserName = findViewById(R.id.username);
        editTextUserEmail = findViewById(R.id.user_email);
        editTextUserDesc = findViewById(R.id.user_description);
        btn_next = findViewById(R.id.btn_next);
        setSupportActionBar(toolbar);

        if(savedInstanceState != null) {
            editTextUserName.setText(savedInstanceState.getString(getResources().getString(R.string.username)));
            editTextUserEmail.setText(savedInstanceState.getString(getResources().getString(R.string.email)));
            editTextUserDesc.setText(savedInstanceState.getString(getResources().getString(R.string.user_description)));
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                editor.putString(getResources().getString(R.string.username), editTextUserName.getText().toString());
                editor.putString(getResources().getString(R.string.email), editTextUserEmail.getText().toString());
                editor.putString(getResources().getString(R.string.user_description), editTextUserDesc.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
                editTextUserEmail.setText("");
                editTextUserName.setText("");
                editTextUserDesc.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.openDetailsActivity) {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(intent);
        }
            return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(getResources().getString(R.string.username), editTextUserName.getText().toString());
        outState.putString(getResources().getString(R.string.email), editTextUserEmail.getText().toString());
        outState.putString(getResources().getString(R.string.user_description), editTextUserDesc.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
