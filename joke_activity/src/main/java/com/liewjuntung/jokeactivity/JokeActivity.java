package com.liewjuntung.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_INTENT = "joke_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_INTENT);
        if (joke != null){
            ((TextView) findViewById(R.id.joke_text)).setText(joke);
        } else {
            Toast.makeText(this, getString(R.string.text_error_display_jokes), Toast.LENGTH_SHORT).show();
            finish();
        }
        if (getSupportActionBar() != null){
            getSupportActionBar()
                    .setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case(android.R.id.home):
                finish();
                return true;
        }
        return false;
    }
}
