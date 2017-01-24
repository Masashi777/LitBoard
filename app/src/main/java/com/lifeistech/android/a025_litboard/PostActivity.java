package com.lifeistech.android.a025_litboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {

    //for firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference();

    //view component
    EditText mUsernameText;
    EditText mPostText;
    Button mPostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mUsernameText = (EditText)findViewById(R.id.username);
        mPostText = (EditText)findViewById(R.id.message);
        mPostButton = (Button)findViewById(R.id.post);

        mPostButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.post:
                //TODO:投稿ボタンの処理

                //投稿を作る
                String message = mPostText.getText().toString();
                String userName = mUsernameText.getText().toString();
                Post post = new Post(userName, message);

                Log.e(message,userName);

                //投稿する
                refMsg.push().setValue(post);

                //アクティビティを閉じる

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                finish();
                break;
        }
    }

}
