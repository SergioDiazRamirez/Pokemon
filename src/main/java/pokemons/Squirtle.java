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
public class Squirtle extends Pokemon {
    
    public Squirtle() {
        this.trainer = trainer;
        name = "Squirtle";
        pokedexId = 1;
        health = 100;
        level = 1;
        strength = 10;
        type = Type.Water;
        evolutionLevel = 5;
        incrementPerLevel = 3;
    }
    
    @Override
    public Pokemon evolve() {
        return null; 
    }
}
