package com.oussema.test; 

import com.oussema.dao.PieceDao; 
import com.oussema.entities.Piece; 

public class PieceTest {
    public static void main(String[] args) {
     
        Piece p = new Piece();
        p.setNom_piece("Retouviseur");
        p.setPrix_piece(150); 

        
        PieceDao pieceDao = new PieceDao();
        pieceDao.ajouter(p);

        System.out.println("Appel de la méthode listerTous");
        for (Piece piece : pieceDao.listerTous())
            System.out.println(piece.getCode() + " " + piece.getNom_piece());

        System.out.println("Appel de la méthode listerParNom");
        for (Piece piece : pieceDao.listerParNom("Retou"))
            System.out.println(piece.getCode() + " " + piece.getNom_piece());

    }
}
