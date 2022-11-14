/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemons;

import com.mycompany.pokemon.Trainer;
import com.mycompany.pokemon.Type;

/**
 *
 * @author sdiazram
 */
public class Charizar extends Pokemon {
    
    public Charizar(Charmeleon charmeleon) {
        name = "Charizar";
        pokedexId = 6;
        health = charmeleon.health + 200;
        level = charmeleon.level;
        strength = charmeleon.strength + 20;
        type = Type.Fire;
        evolutionLevel = 101;
        incrementPerLevel = 8;
    }
    
    public Charizar() {
        this.trainer = trainer;
        name = "Charizar";
        pokedexId = 6;
        health = 500;
        level = 7;
        strength = 20;
        type = Type.Fire;
        evolutionLevel = 101;
        incrementPerLevel = 8;
    }
    
    public Charizar(Trainer trainer) {
        this.trainer = trainer;
        name = "Charizar";
        pokedexId = 6;
        health = 500;
        level = 7;
        strength = 20;
        type = Type.Fire;
        evolutionLevel = 101;
        incrementPerLevel = 8;
    }
    
    public Charizar(int lvl) {
        name = "Charizar";
        pokedexId = 6;
        health = 500;
        level = lvl;
        strength = level*incrementPerLevel;
        type = Type.Fire;
        evolutionLevel = 101;
        incrementPerLevel = 8;
    }
    @Override
    public Pokemon evolve() {
        return null;
    }   
}
