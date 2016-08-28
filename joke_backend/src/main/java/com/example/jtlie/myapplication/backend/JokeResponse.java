package com.example.jtlie.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeResponse {

    private String joke;

    public JokeResponse(String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}