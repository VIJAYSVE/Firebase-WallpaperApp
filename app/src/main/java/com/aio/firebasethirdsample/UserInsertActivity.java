package com.aio.firebasethirdsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


import android.os.Bundle;

public class UserInsertActivity extends AppCompatActivity {
    private EditText mobile,title,description,author;
    private TextView text;
    private Button save,read;
    private DatabaseReference Post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_insert);
        //init();
        mobile = findViewById(R.id.mobile);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        author = findViewById(R.id.author);
        save = findViewById(R.id.save);
        read = findViewById(R.id.read);
        text = findViewById(R.id.text);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // readOneTime();
                //readRealTime();
//                Intent intent = new Intent(this, PostListActivity.class);
//                startActivity(intent);
            }
        });


    }

    private void readRealTime() {
        Post.child("-Ln9F3Km8HlwqS0oaD9Q")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String post = "Title : "+dataSnapshot.child("title").getValue(String.class)+"\n"
                                +"Description : "+dataSnapshot.child("description").getValue(String.class)+"\n"
                                +"Author : "+dataSnapshot.child("author").getValue(String.class);

                        text.setText(post);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void readOneTime() {
        Post.child("-Ln9F3Km8HlwqS0oaD9Q")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String post = "Title : "+dataSnapshot.child("title").getValue(String.class)+"\n"
                                +"Description : "+dataSnapshot.child("description").getValue(String.class)+"\n"
                                +"Author : "+dataSnapshot.child("author").getValue(String.class);

                        text.setText(post);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void save() {

        HashMap<String,Object> map = new HashMap<>();
        map.put("mobile",mobile.getText().toString());
        map.put("title",title.getText().toString());
        map.put("description",description.getText().toString());
        map.put("author",author.getText().toString());
        //save edittext data to firebase instance
                Post = FirebaseDatabase.getInstance().getReference("Post");
                Post.child(mobile.getText().toString()).setValue(map);

//        Post = FirebaseDatabase.getInstance().getReference("Post");
//
//        Post.push()
//                .setValue(map)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Log.i("jfbvkj", "onComplete: ");
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.i("jfbvkj", "onFailure: "+e.toString());
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.i("jfbvkj", "onSuccess: ");
//            }
//        });
    }

    private void init() {
        mobile = findViewById(R.id.mobile);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        author = findViewById(R.id.author);
        save = findViewById(R.id.save);
        read = findViewById(R.id.read);
        text = findViewById(R.id.text);

        Post = FirebaseDatabase.getInstance().getReference().child("Post");
    }


}
