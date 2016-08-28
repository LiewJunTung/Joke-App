package com.liewjuntung.jokeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.liewjuntung.myapplication.backend.myApi.MyApi;
import com.liewjuntung.jokeactivity.JokeActivity;

public class MainActivity extends AppCompatActivity {

    Button mStartJokeButton;
    ProgressBar mStartJokeProgressBar;
    private static MyApi myApiService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartJokeButton = (Button) findViewById(R.id.start_joke_app_button);
        mStartJokeProgressBar = (ProgressBar) findViewById(R.id.start_joke_progressbar);
        mStartJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JokeAsyncTask() {
                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        loadJokes(s);
                    }
                }.execute();
                setIsLoading(true);
            }
        });
    }

    private void loadJokes(String joke){
        setIsLoading(false);
        if (joke == null){
            Toast.makeText(MainActivity.this, R.string.text_error, Toast.LENGTH_SHORT).show();
        } else {

            Intent intent = JokeAppUtil.getJokeActivity(MainActivity.this);
            intent.putExtra(JokeActivity.JOKE_INTENT, joke);
            startActivity(intent);
        }
    }

    private void setIsLoading(boolean loading){
        if (loading){
            mStartJokeButton.setEnabled(false);
            mStartJokeProgressBar.setVisibility(View.VISIBLE);
        } else {
            mStartJokeButton.setEnabled(true);
            mStartJokeProgressBar.setVisibility(View.GONE);
        }
    }

}
