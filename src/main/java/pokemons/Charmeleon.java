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
public class Charmeleon extends Pokemon {

    public Charmeleon(Charmander charmander) {
        name = "Charmeleon";
        pokedexId = 6;
        health = charmander.health + 200;
        level = charmander.level;
        strength = charmander.strength + 20;
        type = Type.Fire;
        evolutionLevel = 7;
        incrementPerLevel = 5;
    }
    
    public Charmeleon() {
        this.trainer = trainer;
        name = "Charmeleon";
        pokedexId = 5;
        health = 300;
        level = 5;
        strength = 10; 
        type = Type.Fire;
        evolutionLevel = 7;
        incrementPerLevel = 5;
    }
    
    public Charmeleon(Trainer trainer) {
        this.trainer = trainer;
        name = "Charmeleon";
        pokedexId = 5;
        health = 300;
        level = 5;
        strength = 10; 
        type = Type.Fire;
        evolutionLevel = 7;
        incrementPerLevel = 5;
    }
    
    public Charmeleon(int lvl) {
        name = "Charmeleon";
        pokedexId = 5;
        health = 300;
        level = lvl;
        strength = level*incrementPerLevel;
        type = Type.Fire;
        evolutionLevel = 5;
        incrementPerLevel = 5;
    }
    public Pokemon evolve() {
        return new Charizar(this);
    }

}
