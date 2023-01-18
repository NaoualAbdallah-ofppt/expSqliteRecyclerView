package com.example.exprecyclerview;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class Animal {
    private String nom;
    private byte[] photo;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Animal(String nom, byte[] photo) {
        this.nom = nom;
        this.photo = photo;
    }



public static ArrayList<Animal> getLstAnimals(Context C)
{
    AccessBDAnimal BD= new AccessBDAnimal(C);
    return BD.getLstAnimals()  ;


}
public void ajouter(Context C)
{

    AccessBDAnimal BD= new AccessBDAnimal(C);
    //this fait référence à l'objet Animal en cours
    BD.ajouter(this);  ;
}

}
