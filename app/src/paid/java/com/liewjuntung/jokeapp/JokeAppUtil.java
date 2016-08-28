package com.liewjuntung.jokeapp;

import android.app.Activity;
import android.content.Intent;

import com.liewjuntung.jokeactivity.JokeActivity;

/**
 * Popular Movie App
 * Created by jtlie on 8/28/2016.
 */

public class JokeAppUtil {
    public static Intent getJokeActivity(Activity activity){
        return new Intent(activity, JokeActivity.class);
    }
}
