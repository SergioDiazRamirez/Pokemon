/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import pokemons.Pokemon;

/**
 *
 * @author sdiazram
 */
public class FightManagment {
    Pokemon pk1, pk2;
    
    /**
     * Creates a FightManagment object
     * 
     * @param pk1 Pokemon protagonista
     * @param pk2 Pokemon enemigo
     **/
    public FightManagment(Pokemon pk1, Pokemon pk2) {
        this.pk1 = pk1;
        this.pk2 = pk2;
    }
    
    /**
     *
     * @return
     */
    public int fight() {
        Trainer trainer1 = pk1.getTrainer();
        Trainer trainer2 = pk2.getTrainer();
        int fightResult = 0;
        
        int strengthForFight = pk1.getStrength();
        if(pk1.isStrongVersus(pk2)) {
            strengthForFight += 15;
        }
        else if(pk1.isWeakVersus(pk2)) {
            strengthForFight -= 15;
        }
        
        if(strengthForFight > pk2.getStrength()) {
            pk1.train();
            pk1.train();
            pk2.train();
            fightResult = 1;
        }
        if(strengthForFight < pk2.getStrength()) {
            pk1.train();
            pk2.train();
            pk2.train();
            fightResult = -1;
        }
        
       return fightResult;
    }
}
