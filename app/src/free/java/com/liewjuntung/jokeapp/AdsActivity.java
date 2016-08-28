package com.liewjuntung.jokeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.liewjuntung.jokeactivity.JokeActivity;

public class AdsActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mInterstitialAd.isLoaded()){
                    mInterstitialAd.show();
                }
                findViewById(R.id.ads_progress).setVisibility(View.GONE);
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                String joke = getIntent().getStringExtra(JokeActivity.JOKE_INTENT);
                Intent jokeIntent = new Intent(AdsActivity.this, JokeActivity.class);
                jokeIntent.putExtra(JokeActivity.JOKE_INTENT, joke);
                startActivity(jokeIntent);
                finish();
            }
        });
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);
    }
}
