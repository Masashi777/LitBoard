package com.lifeistech.android.a025_litboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //for Fierbase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference();

    //view component
    ListView mListView;
    Button mButton;

    //fields
    ArrayList<Post> items;

    //adapter
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list_view);
        mButton = (Button)findViewById(R.id.button);

        mButton.setOnClickListener(this);

        items = new ArrayList<>();
        postAdapter = new PostAdapter(this, 0, items);

        mListView.setAdapter(postAdapter);

        refMsg.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //TODO:投稿を読み込むときの処理
                //データを取得
                Post value = dataSnapshot.getValue(Post.class);

                //リストに追加
                items.add(value);

                //画面を更新
                postAdapter.clear();
                postAdapter.addAll(items);
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
        Log.e("TAG","TAG");

        finish();
    }
}
