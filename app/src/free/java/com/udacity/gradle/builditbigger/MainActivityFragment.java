package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import app.elghamry.android.jokedisplayactivity.JokeDisplayActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements DataLoadedListener {
    private ProgressDialog progress;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        Button btn_tj= (Button) root.findViewById(R.id.tellJoke);
        btn_tj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });
        return root;
    }

    public void tellJoke() {
        showProgressDialog();
        GetJokeAsyncTask getJokeAsyncTask = new GetJokeAsyncTask(this);
        getJokeAsyncTask.execute();
    }


    @Override
    public void parseData(String data) {
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra("Joke_key", data);
        dismissProgressDialog();
        startActivity(intent);
    }
    void showProgressDialog() {
        progress = ProgressDialog.show(getActivity(), "", "Loading", true);
    }

    void dismissProgressDialog() {
        progress.dismiss();
    }
}
