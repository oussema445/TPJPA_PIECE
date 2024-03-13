package com.oussema.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Piece implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    
    private String nom_piece;
    private double prix_piece; 

    // Getters et Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom_piece() {
        return nom_piece;
    }

    public void setNom_piece(String nom_piece) {
        this.nom_piece = nom_piece;
    }

    public double getPrix_piece() {
        return prix_piece;
    }

    public void setPrix_piece(double prix_piece) {
        this.prix_piece = prix_piece;
    }
}
