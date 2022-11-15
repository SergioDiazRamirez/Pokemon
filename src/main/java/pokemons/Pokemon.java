/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pokemons;

import com.mycompany.pokemon.DB;
import com.mycompany.pokemon.Trainer;
import com.mycompany.pokemon.Type;

/**
 *
 * @author sdiazram
 */
public abstract class Pokemon {
    Trainer trainer;
    String name;
    double health;
    int pokedexId;
    int level;
    int strength;
    Type type;
    int evolutionLevel;
    int incrementPerLevel;

    public Pokemon() {}
    
    public Pokemon(int id, int level) {
        Pokemon pokemon = DB.getPokemon(id);
        this.name = pokemon.name;
        this.pokedexId = id;
        this.health = 100;
        this.level = level;
        this.strength = pokemon.strength + level*pokemon.incrementPerLevel;
        this.type = pokemon.type;
        this.evolutionLevel = pokemon.evolutionLevel;
        this.incrementPerLevel = pokemon.incrementPerLevel;
    }

    public Pokemon(String name, int id, int level, int strength, Type type, int evolutionLevel, int incrementPerLevel) {
        this.name = name;
        this.pokedexId = id;
        this.health = 100;
        this.level = level;
        this.strength = strength;
        this.type = type;
        this.evolutionLevel = evolutionLevel;
        this.incrementPerLevel = incrementPerLevel;
    }
    
    public void train() {
        if(level < 100) {
            level++;
            strength += incrementPerLevel;
        }
    }
    
    public abstract Pokemon evolve();
    
    public int fight(Pokemon enemy) {
        int strengthForFight = strength;
        if(this.isStrongVersus(enemy)) {
            strengthForFight += 15;
        }
        else if(this.isWeakVersus(enemy)) {
            strengthForFight -= 15;
        }
        
        if(strengthForFight > enemy.getStrength()) {
            train();
            train();
            return 1;
        }
        if(strengthForFight < enemy.getStrength()) {
            train();
            return -1;
        }
        return 0;                
    }
    
    public boolean isStrongVersus(Pokemon enemy) {
        Type strongType = DB.getStrength(this);
        return strongType == enemy.type;
    }
    
    public boolean isWeakVersus(Pokemon enemy) {
        Type weakType = DB.getWeakness(this);
        return weakType == enemy.type;
    }

    public boolean equals(Pokemon pokemon) {
        return this.hashCode() == pokemon.hashCode();
    }
    
    @Override
    public String toString() {
        String result = "Name: " + name + "\n" +
                "Level: " + level + "\n" +
                "Strength: " + strength + "\n" +
                "Type: " + type
                ;
        return result;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    
    public String getName() {
        return name;
    }

    public int getId() {
        return pokedexId;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int newLevel) {
        level = newLevel;
        strength = newLevel * incrementPerLevel;
    }

    public int getEvolutionLevel() {
        return evolutionLevel;
    }
    public int getStrength() {
        return strength;
    }

    public Type getType() {
        return type;
    }
}
