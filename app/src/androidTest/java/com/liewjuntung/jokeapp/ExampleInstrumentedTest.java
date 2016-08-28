package com.liewjuntung.jokeapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static com.liewjuntung.joke_library.JokeProvider.jokeList;
import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void testJokeAsyncTask() throws  Exception {
        JokeAsyncTask asyncTask = (JokeAsyncTask) new JokeAsyncTask().execute();
        String joke = asyncTask.get();
        boolean hasJoke = false;
        for (String jokeInList :
                jokeList) {
            if (jokeInList.equals(joke)){
                hasJoke = true;
            }
        }
        assertTrue("Joke doesn't exist", hasJoke);
    }
}
