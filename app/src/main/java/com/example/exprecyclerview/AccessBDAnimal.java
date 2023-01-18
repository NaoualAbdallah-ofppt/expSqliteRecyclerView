package com.example.exprecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class AccessBDAnimal {
    MyHelper H;
    SQLiteDatabase db;
    public AccessBDAnimal(Context C) {
        //Création de la BD AnimalsDB avec sa table animal
        H = new MyHelper(C,"AnimalsDB",null,1);
    }

    public void ajouter(Animal A)
    {
        //Ajouter un objet animal à la table Animal de la base de données
        db=H.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("nom",A.getNom());
        values.put("photo",A.getPhoto());
        db.insert("Animal",null, values);
        db.close();
     //db.execSQL("insert into Animal values(" + A.getNom() + "," + A.getPhoto() + ")");
    }

    public ArrayList<Animal> getLstAnimals()
    {
        Log.d("aa","e5");
        //Récupérer la liste des animaux à partir de la table Animal
         db=H.getReadableDatabase();
        ArrayList<Animal> AL = new ArrayList<Animal>();
        Cursor cur = db.rawQuery("select * from Animal",null);
        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            String nom=cur.getString(0);
            byte[] photo =  cur.getBlob(1);
                    //cursor.getColumnIndex("nn");
            AL.add(new Animal(nom,photo));
            cur.moveToNext();
        }
        cur.close();
        return  AL;
    }
}
