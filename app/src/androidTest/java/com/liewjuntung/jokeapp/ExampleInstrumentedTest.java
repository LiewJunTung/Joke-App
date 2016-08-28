package com.liewjuntung.jokeapp;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    public static String[] jokeList = {
            "Q: What's the best thing thing about UDP jokes? \n\nA: I don't care if you get them",
            "Q: How many programmers does it take to screw in a light bulb? \n\nA: None. It's a hardware problem. ",
            "A guy walks into a bar and asks for 1.4 root beers. The bartender says \"I'll have to charge you extra, that's a root beer float\". The guy says \"In that case, better make it a double.\"",
            "A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn’t.",
            "Why C gets all the chicks and Java doesn't? \n\nBecause C doesn't treat them like objects.",
            "In order to understand recursion you must first understand recursion.",
            "There are 10 kinds of people in this world: \n\nThose who understand binary, those who don't, and those who weren't expecting a base 3 joke.",
            "A programmer is heading out to the grocery store, so his wife tells him \"get a gallon of milk, and if they have eggs, get a dozen.\" \n\nHe returns with 13 gallons of milk. ",
            "Java: OK guys. Any idea how to make women more interested in us?\n\n" +
                    "C++: More exceptions?\n\n" +
                    "Python: Define our methods?\n\n" +
                    "ANSI-C: Stop treating them like objects?",
            "Q: Why did the Python programmer not respond to the foreign mails he got?? \n\nA: In their mousepads ",
            "Q: What do you get when you cross a computer with an elephant? \n\nA: Because his interpreter was busy collecting garbage.",
            "A SQL statement walks into a bar and sees two tables. It approaches, and asks \n\n'may I join you?'"
    };

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
