package a2.t1mo.mobjav.a816.myapplication.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import a2.t1mo.mobjav.a816.myapplication.R;

public class TwitterLogin extends AppCompatActivity {

    TwitterSession session = Twitter.getSessionManager().getActiveSession();
    TwitterAuthToken authToken = session.getAuthToken();
    String token = authToken.token;
    String secret = authToken.secret;

    TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_login);

        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                Intent unIntent = new Intent(TwitterLogin.this, MainActivity.class);

                Bundle unBundle = new Bundle();
                unBundle.putString("token", token);
                unBundle.putString("secret", secret);
                unIntent.putExtras(unBundle);

                startActivity(unIntent);
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
