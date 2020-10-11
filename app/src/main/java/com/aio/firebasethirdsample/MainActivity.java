package com.aio.firebasethirdsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editName, editGender, editAge, editMobile;
    Button editSave;
    //RecyclerView main_recyclerview;
    FirebaseDatabase rootNode;
    DatabaseReference databaseReference;
    UserHelperClass helperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editGender = findViewById(R.id.editGender);
        editAge = findViewById(R.id.editAge);
        editMobile = findViewById(R.id.editMobile);
        editSave = findViewById(R.id.editSave);
//        uploadData = new UploadData();
//        main_recyclerview = findViewById(R.id.main_recyclerview);
//        main_recyclerview.setHasFixedSize(true);
//        main_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        editSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get all the values from the text fields
//                String name = editName.getText().toString();
//                String gender = editGender.getText().toString();
//                int age = editAge.getText();
//                int mobile = editMobile.getText().toString();
//                //save edittext data to firebase instance
//                rootNode = FirebaseDatabase.getInstance();
//                databaseReference = rootNode.getReference("Users");
//                helperClass = new UserHelperClass(name, gender, age, mobile);
//                databaseReference.child(mobile).setValue(helperClass);
                //databaseReference.setValue(helperClass);
                //databaseReference.setValue("Hello");
            }
        });
    }
}