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
public class Charmander extends Pokemon {

    public Charmander(){
        this.trainer = trainer;
        name = "Charmander";
        pokedexId = 4;
        health = 100;
        level = 1;
        strength = 10;
        type = Type.Fire;
        evolutionLevel = 5;
        incrementPerLevel = 3;
    }
    public Charmander(Trainer trainer){
        this.trainer = trainer;
        name = "Charmander";
        pokedexId = 4;
        health = 100;
        level = 1;
        strength = 10;
        type = Type.Fire;
        evolutionLevel = 5;
        incrementPerLevel = 3;
    }
    
    public Charmander(int lvl) {
        name = "Charmander";
        pokedexId = 4;
        health = 100;
        level = lvl;
        strength = level*incrementPerLevel;
        type = Type.Fire;
        evolutionLevel = 5;
        incrementPerLevel = 3;
    }

    public Pokemon evolve() {
        return new Charmeleon(this);
    }
}
