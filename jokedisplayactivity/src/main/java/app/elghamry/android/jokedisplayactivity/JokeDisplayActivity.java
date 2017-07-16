package app.elghamry.android.jokedisplayactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ELGHAMRY on 15/05/2017.
 */

public class JokeDisplayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("Joke_key");

        TextView jokeTextView = (TextView) findViewById(R.id.tv_joke);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
    }
}