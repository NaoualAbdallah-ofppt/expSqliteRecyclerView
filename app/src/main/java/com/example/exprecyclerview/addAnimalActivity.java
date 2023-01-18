package com.example.exprecyclerview;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class addAnimalActivity extends AppCompatActivity {
ImageView img ;
EditText txt;
Button btnP,btnE;
    byte[] byteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
        img=findViewById(R.id.img);
        txt=findViewById(R.id.txtNom);
        btnE=findViewById(R.id.btnEnregistrer);
        btnP=findViewById(R.id.btnParcourir);
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Animal A = new Animal(txt.getText().toString(),byteArray);
A.ajouter(addAnimalActivity.this);
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent itt= new Intent(Intent.ACTION_PICK);
               itt.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                resultLaucher.launch(itt);


                // itt.setType("image/*");

            }
        });



    }

    ActivityResultLauncher<Intent> resultLaucher
            =registerForActivityResult
            (
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {

                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Uri u=result.getData().getData();
                          //    img.setImageURI(u);


                                try {
                                    //Récupérer un objet Bitmap à partir un uri
                                    Bitmap BmpImg = MediaStore.Images.Media.getBitmap(getContentResolver(), u);
                                   //On peut aussi afficher sous format Bitmap
                                     img.setImageBitmap(BmpImg);
                                    //Conversion d'un Bitmap en Bits
                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                    BmpImg.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                    byteArray = stream.toByteArray();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }



                            }
                        }
                    }
            );





}