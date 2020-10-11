package com.aio.firebasethirdsample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

public class MultipleUploadActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    Button upload, choose, gridwall;
    TextView alert;
    ArrayList<Uri> ImageList = new ArrayList<Uri>();
    private Uri ImageUri;
    private ProgressDialog progressDialog;
    private int upload_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_upload);
        gridwall = findViewById(R.id.gridwall);
        alert = findViewById(R.id.alert);
        choose = findViewById(R.id.choose_image);
        upload = findViewById(R.id.upload_image);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Image Uploading Please Wait.........");

        //gridbutton click to open mail grid wallpaper activity
        gridwall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), WallpaperGridActivity.class);
                startActivity(intent);
            }
        });

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent,PICK_IMAGE);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                alert.setText("If Loading takes too long , please Press the button again");
                StorageReference ImageFolder =  FirebaseStorage.getInstance().getReference().child("ImageFolder");
                for (upload_count=0; upload_count < ImageList.size(); upload_count++) {
                    Uri IndividualImage  = ImageList.get(upload_count);
                    final StorageReference ImageName = ImageFolder.child("Image"+IndividualImage.getLastPathSegment());
                    ImageName.putFile(IndividualImage).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ImageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String url = String.valueOf(uri);
                                    StoreLink(url);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void StoreLink(String url) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserOne");
        HashMap<String,String > hashMap = new HashMap<>();
        hashMap.put("link",url);
        databaseReference.push().setValue(hashMap);
        progressDialog.dismiss();
        alert.setText("Images Uploaded successfully");
        upload.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            if (resultCode == RESULT_OK) {
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();

                    int currentImageSelect = 0;

                    while (currentImageSelect < count) {
                        ImageUri = data.getClipData().getItemAt(currentImageSelect).getUri();
                        ImageList.add(ImageUri);
                        currentImageSelect = currentImageSelect + 1;
                    }
                    alert.setVisibility(View.VISIBLE);
                    alert.setText("You Have Selected "+ ImageList.size() +" Images" );
                    choose.setVisibility(View.GONE);
                }else {
                    Toast.makeText(this, "Please select multiple images", Toast.LENGTH_SHORT).show();
                }

            }

        }



    }
}