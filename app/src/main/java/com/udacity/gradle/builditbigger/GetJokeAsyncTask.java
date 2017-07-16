package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.elghamry.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by ELGHAMRY on 15/05/2017.
 */

public class GetJokeAsyncTask extends AsyncTask<Void, Void, String> {
    public GetJokeAsyncTask(DataLoadedListener listener) {
        this.listener = listener;
    }

    private static MyApi myApiService = null;
    private Context mContext;
DataLoadedListener listener ;
    public GetJokeAsyncTask (Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params){
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.1.4:8080/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.parseData(result);
    }
}
