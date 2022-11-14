/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemons;

import com.mycompany.pokemon.Type;

/**
 *  
 * @author sdiazram
 */
public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        this.trainer = trainer;
        name = "Bulbasaur";
        pokedexId = 4;
        health = 100;
        level = 1;
        strength = 10;
        type = Type.Grass;
        evolutionLevel = 5;
        incrementPerLevel = 3;
    }
    
    @Override
    public Pokemon evolve() {
        return null; 
    }
}
